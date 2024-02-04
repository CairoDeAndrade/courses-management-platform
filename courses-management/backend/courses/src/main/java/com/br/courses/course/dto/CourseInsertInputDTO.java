package com.br.courses.course.dto;

import com.br.courses.course.Course;
import jakarta.validation.constraints.NotBlank;

public record CourseInsertInputDTO(
        @NotBlank
        String name,
        @NotBlank
        String category
){

    public CourseInsertInputDTO(Course entity) {
        this(
                entity.getName(),
                entity.getCategory()
        );
    }
}
