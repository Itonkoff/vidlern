package com.example.vidlern

import android.app.Application
import com.example.vidlern.data.Repository

class VidLernApplication : Application() {
    val repository by lazy { Repository() }
}