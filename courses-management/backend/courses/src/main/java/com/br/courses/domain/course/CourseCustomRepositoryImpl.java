package com.br.courses.domain.course;

import com.br.courses.domain.common.RepositoryBaseImpl;
import com.querydsl.jpa.impl.JPAQuery;

import java.util.List;

class CourseCustomRepositoryImpl extends RepositoryBaseImpl implements CourseCustomRepository {

    @Override
    public List<Course> findAllCourses() {
        QCourse qCourse = QCourse.course;
        JPAQuery<Course> query = select(qCourse).from(qCourse);

        return query.fetch();
    }
}
