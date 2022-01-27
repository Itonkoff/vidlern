package com.example.vidlern.data.models

data class ApiCoursesResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Course>
)
