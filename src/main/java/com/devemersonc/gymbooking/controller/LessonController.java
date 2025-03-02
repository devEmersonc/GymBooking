package com.devemersonc.gymbooking.controller;

import com.devemersonc.gymbooking.dto.LessonDTO;
import com.devemersonc.gymbooking.dto.NewLessonDTO;
import com.devemersonc.gymbooking.service.LessonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public ResponseEntity<List<LessonDTO>> getLessons() {
        List<LessonDTO> lessons = lessonService.getLessons();
        return ResponseEntity.ok(lessons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDTO> getLesson(@PathVariable Long id) {
        LessonDTO lesson = lessonService.getLesson(id);
        return ResponseEntity.ok(lesson);
    }

    @PostMapping("/{coach_id}")
    public ResponseEntity<String> saveLesson(@Valid @RequestBody NewLessonDTO lessonDTO, @PathVariable Long coach_id) {
        lessonService.saveLesson(coach_id, lessonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Nueva clase guardada.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLesson(@Valid @RequestBody NewLessonDTO lessonDTO, @PathVariable Long id) {
        lessonService.updateLesson(id, lessonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Clase actualizada.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.ok("Clase eliminada.");
    }
}