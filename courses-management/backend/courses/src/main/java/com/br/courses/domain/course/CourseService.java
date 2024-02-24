package com.br.courses.domain.course;

import com.br.courses.infra.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    @Transactional(readOnly = true)
    public Course findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    @Transactional
    public Course update(UUID id, String name, String category) {
        Course entity = findById(id);

        if (name != null && !name.isEmpty()) {
            entity.setName(name);
        }
        if (category != null && !category.isEmpty()) {
            entity.setCategory(category);
        }

        return repository.save(entity);
    }

    @Transactional
    public void delete(UUID id) {
        Course entity = findById(id);
        repository.delete(entity);
    }
}
