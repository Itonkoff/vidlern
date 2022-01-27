package com.example.vidlern.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.vidlern.data.retrofit.RetrofitClient
import com.example.vidlern.data.room.CoursesInstructorCrossRef
import com.example.vidlern.data.room.CourseDatabase

class DownloadAndUpdateCoursesWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    private val TAG = "DownloadAndUpdateCourse"
    private val client= RetrofitClient.API_SERVICE
    private val dao = CourseDatabase.getDatabase(context).dao()

    override suspend fun doWork(): Result {
        return try {
            val allCourses = client.getAllCourses().results
            allCourses.forEach { course ->
                Log.d(TAG, "doWork: INSERT course ID: ${course.id}")
                dao.insertCourse(course)
                course.visible_instructors.forEach {
                    dao.insertInstructor(it)
                    Log.d(TAG, "doWork: INSERT course ID: ${course.id}")
                    dao.insertCourseInstructor(CoursesInstructorCrossRef(course.id, it.id))
                }
            }
            Result.success()
        } catch (throwable: Throwable) {
            Log.e(TAG, "Error getting courses ${throwable.stackTrace}")
            Result.retry()
        }
    }
}