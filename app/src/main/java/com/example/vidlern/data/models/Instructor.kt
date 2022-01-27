package com.example.vidlern.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Instructor(
    @PrimaryKey val id: Int,
    val name: String,
    val display_name: String,
    val job_title: String,
    val image_100x100: String
)
