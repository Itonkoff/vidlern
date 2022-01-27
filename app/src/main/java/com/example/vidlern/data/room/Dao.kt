package com.example.vidlern.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vidlern.data.models.Course
import com.example.vidlern.data.models.Instructor

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: Course)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertInstructor(instructor: Instructor)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourseInstructor(courseInstructors: CoursesInstructorCrossRef)

    @Query("SELECT * FROM Course")
    fun getAllCourses(): LiveData<List<Course>>

}