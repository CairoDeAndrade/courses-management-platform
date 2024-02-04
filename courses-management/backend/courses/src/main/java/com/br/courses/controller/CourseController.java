package com.br.courses.controller;

import com.br.courses.course.CourseService;
import com.br.courses.course.dto.CourseInsertInputDTO;
import com.br.courses.course.dto.CourseOutputDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    public ResponseEntity<CourseOutputDTO> insert(@RequestBody @Valid CourseInsertInputDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new CourseOutputDTO(service.insert(dto.name(), dto.category()))
        );
    }

    @GetMapping
    public ResponseEntity<List<CourseOutputDTO>> findAll() {
        return ResponseEntity.ok(
                service.findAll().stream().map(CourseOutputDTO::new).toList()
        );
    }
}
