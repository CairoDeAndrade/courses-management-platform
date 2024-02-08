package com.br.courses.course.dto;

import com.br.courses.course.Course;

import java.util.UUID;

public record CourseOutputDTO(UUID id, String name, String category) {

    public CourseOutputDTO(Course entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getCategory()
        );
    }
}
