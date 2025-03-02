package com.devemersonc.gymbooking.service;

import com.devemersonc.gymbooking.dto.LessonDTO;
import com.devemersonc.gymbooking.dto.NewLessonDTO;

import java.util.List;

public interface LessonService {
    List<LessonDTO> getLessons();
    LessonDTO getLesson(Long id);
    void saveLesson(Long coach_id, NewLessonDTO lessonDTO);
    void updateLesson(Long id, NewLessonDTO lessonDTO);
    void deleteLesson(Long id);
}
