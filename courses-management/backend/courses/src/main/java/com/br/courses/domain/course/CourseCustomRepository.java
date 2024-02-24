package com.br.courses.domain.course;

import java.util.List;

interface CourseCustomRepository {

    List<Course> findAllCourses();
}
