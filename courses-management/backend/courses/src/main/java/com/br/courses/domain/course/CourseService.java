package com.br.courses.course;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return repository.findAllCourses();
    }

    @Transactional
    public Course insert(String name, String category) {
        Course entity = new Course();

        if (name != null && !name.isEmpty()) {
            entity.setName(name);
        }
        if (category != null && !category.isEmpty()) {
            entity.setCategory(category);
        }

        return repository.save(entity);
    }
}
