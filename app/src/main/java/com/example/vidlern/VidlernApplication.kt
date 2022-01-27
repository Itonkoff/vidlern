package com.example.vidlern

import android.app.Application
import androidx.work.WorkManager
import com.example.vidlern.data.Repository
import com.example.vidlern.data.room.CourseDatabase

class VidLernApplication : Application() {
    private val database by lazy { CourseDatabase.getDatabase(this) }
    private val workManager by lazy { WorkManager.getInstance(this) }
    val repository by lazy { Repository(database.dao(), workManager) }
}