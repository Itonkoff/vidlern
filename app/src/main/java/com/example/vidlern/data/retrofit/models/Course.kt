package com.example.vidlern.data.retrofit.models

data class Course(
    val id: Int,
    val title: String,
    val url: String,
    val is_paid: Boolean,
    val price: String,
    val image_480x270: String,
    val headline: String,
    val visible_instructors: List<Instructor>
)
