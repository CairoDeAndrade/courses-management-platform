package com.br.courses.controller;

import com.br.courses.domain.course.CourseService;
import com.br.courses.domain.course.dto.CourseInsertInputDTO;
import com.br.courses.domain.course.dto.CourseOutputDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<CourseOutputDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(new CourseOutputDTO(service.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseOutputDTO> update(@PathVariable UUID id, @RequestBody @Valid CourseInsertInputDTO dto) {
        return ResponseEntity.ok(
                new CourseOutputDTO(service.update(id, dto.name(), dto.category()))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
