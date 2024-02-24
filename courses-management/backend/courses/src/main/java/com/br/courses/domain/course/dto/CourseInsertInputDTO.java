package com.br.courses.domain.course.dto;

import com.br.courses.domain.course.Course;
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
