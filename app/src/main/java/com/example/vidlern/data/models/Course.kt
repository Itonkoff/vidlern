package com.example.vidlern.data.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey val id: Int,
    val title: String,
    val url: String,
    val is_paid: Boolean,
    val price: String,
    val image_480x270: String,
    val headline: String,
) {

    @Ignore
    var visible_instructors: List<Instructor> = listOf()
}
