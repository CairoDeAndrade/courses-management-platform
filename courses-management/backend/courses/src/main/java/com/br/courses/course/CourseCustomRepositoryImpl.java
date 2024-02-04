package com.br.courses.course;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

class CourseCustomRepositoryImpl implements CourseCustomRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Course> findAllCourses() {
        QCourse qCourse = QCourse.course;

        return new JPAQuery<>(manager)
                .select(qCourse)
                .from(qCourse)
                .fetch();
    }
}
