package com.example.vidlern.data.retrofit.models

data class ApiCoursesResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Course>
)
