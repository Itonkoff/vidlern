package com.example.vidlern.data

import com.example.vidlern.data.retrofit.RetrofitClient
import com.example.vidlern.data.retrofit.models.ApiCoursesResponse

class Repository() {
    suspend fun getAllCourses():ApiCoursesResponse{
        return RetrofitClient.API_SERVICE.getAllCourses()
    }
}