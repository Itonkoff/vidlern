package com.example.vidlern.data.room

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.vidlern.data.models.Course
import com.example.vidlern.data.models.Instructor

class CoursesWithInstructors(
    @Embedded val course: Course,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(CoursesInstructorCrossRef::class)
    ) val instructors: List<Instructor>
)