package com.br.courses.course;

import java.util.List;

interface CourseCustomRepository {

    List<Course> findAllCourses();
}
