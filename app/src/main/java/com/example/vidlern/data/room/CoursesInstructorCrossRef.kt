package com.example.vidlern.data.room

import androidx.room.Entity

@Entity(primaryKeys = ["courseId", "instructorId"])
class CoursesInstructorCrossRef(
    val courseId: Int,
    val instructorId: Int
)