package com.example.vidlern.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vidlern.data.Repository

class CoursesViewModel(private val repository: Repository) : ViewModel() {
    val courses = repository.getAllCourses()
    val count = MutableLiveData<Int>(courses.value?.size)

    fun updateCoursesFromNetwork() {
        repository.updateCourses()
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