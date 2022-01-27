package com.example.vidlern.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vidlern.data.models.Course
import com.example.vidlern.data.models.Instructor

@Database(
    entities = [Course::class, Instructor::class, CoursesInstructorCrossRef::class],
    version = 1
)
abstract class CourseDatabase : RoomDatabase() {

    abstract fun dao(): Dao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CourseDatabase? = null

        fun getDatabase(context: Context): CourseDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CourseDatabase::class.java,
                    "udemy_course_database"
                )
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}