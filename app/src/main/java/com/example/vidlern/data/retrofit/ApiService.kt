package com.example.vidlern.data.retrofit

import com.example.vidlern.data.retrofit.models.ApiCoursesResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers(
        "Accept: application/json, text/plain, */*",
        "Authorization: Basic TjRTVEZYR1NtbmFWMTlzRkNuSDZ2cFgybUFuZVM4dmg3V2NyMnppWjprc2hNSnlnRFdkZURjUjJUYUFQNGlmS1lEZVp4Y3NyMGIzdWgyaGpjTFE1MzVYbG9GaDdGcktvS3U3Y1lIenJWNnRPSXBzUTlTcTRsajNUNlBOOWFGVmNvY0JYYmhEYloyOFluYTFZUUVUcFNBZTNGZmV0NW4yaUE0bEJzUlY1Vw==",
        "Content-Type: application/json;charset=utf-8"
    )
    @GET("courses")
    suspend fun getAllCourses(): ApiCoursesResponse
}