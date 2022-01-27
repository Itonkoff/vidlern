package com.example.vidlern.data

import androidx.lifecycle.LiveData
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.vidlern.data.retrofit.RetrofitClient
import com.example.vidlern.data.models.ApiCoursesResponse
import com.example.vidlern.data.models.Course
import com.example.vidlern.data.models.Instructor
import com.example.vidlern.data.room.CoursesInstructorCrossRef
import com.example.vidlern.data.room.Dao
import com.example.vidlern.workers.DownloadAndUpdateCoursesWorker

class Repository(private val dao: Dao, private val workManager: WorkManager) {
    fun getAllCourses(): LiveData<List<Course>> {
        return dao.getAllCourses()
    }

    fun updateCourses() {
        workManager.enqueue(OneTimeWorkRequest.from(DownloadAndUpdateCoursesWorker::class.java))
    }
}