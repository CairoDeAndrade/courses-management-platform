package com.br.courses.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CourseRepository extends JpaRepository<Course, UUID>, CourseCustomRepository {
}
