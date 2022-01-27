package com.example.vidlern.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.vidlern.data.Repository
import com.example.vidlern.data.retrofit.RetrofitClient
import com.example.vidlern.data.retrofit.models.Course
import kotlinx.coroutines.launch

class CoursesViewModel(val repository: Repository) : ViewModel() {
    val courses = MutableLiveData<List<Course>>()
    val count = MutableLiveData<Int>()

    fun getCourses(){
        viewModelScope.launch {
            val allCourses = repository.getAllCourses()
            courses.value = allCourses.results
            count.value = allCourses.count
        }
    }
}

class CoursesViewModelFactory(private val covStatsRepository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoursesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CoursesViewModel(covStatsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}