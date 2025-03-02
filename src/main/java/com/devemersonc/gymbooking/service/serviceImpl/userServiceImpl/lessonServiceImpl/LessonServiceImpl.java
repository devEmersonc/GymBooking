package com.devemersonc.gymbooking.service.serviceImpl.userServiceImpl.lessonServiceImpl;

import com.devemersonc.gymbooking.dto.LessonDTO;
import com.devemersonc.gymbooking.dto.NewLessonDTO;
import com.devemersonc.gymbooking.exception.ResourceNotFoundException;
import com.devemersonc.gymbooking.mapper.LessonMapper;
import com.devemersonc.gymbooking.model.Lesson;
import com.devemersonc.gymbooking.model.User;
import com.devemersonc.gymbooking.repository.LessonRepository;
import com.devemersonc.gymbooking.repository.UserRepository;
import com.devemersonc.gymbooking.service.LessonService;
import com.devemersonc.gymbooking.service.SecurityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final SecurityService securityService;
    private final UserRepository userRepository;

    public LessonServiceImpl(LessonRepository lessonRepository, LessonMapper lessonMapper, SecurityService securityService, UserRepository userRepository) {
        this.lessonRepository = lessonRepository;
        this.lessonMapper = lessonMapper;
        this.securityService = securityService;
        this.userRepository = userRepository;
    }

    @Override
    public List<LessonDTO> getLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessonMapper.toDtoList(lessons);
    }

    @Override
    public LessonDTO getLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La clase ingresada no se ha encontrado."));
        return lessonMapper.toDto(lesson);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_COACH')")
    @Override
    public void saveLesson(Long coach_id, NewLessonDTO lessonDTO) {
        Lesson lesson = new Lesson();
        User coach = userRepository.findById(coach_id).orElseThrow(() -> new ResourceNotFoundException("El coach ingresado no se ha encontrado."));
        User creator_user = new User();
        creator_user = securityService.getAuthenticateUser();
        lesson.setAvailable_places(lessonDTO.getAvailable_places());
        lesson.setName(lessonDTO.getName());
        lesson.setCreator(creator_user);
        lesson.setCoach(coach);
        lessonRepository.save(lesson);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_COACH') or #username == authentication.name")
    @Override
    public void updateLesson(Long id, NewLessonDTO lessonDTO) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La clase ingresada no se ha encontrado."));
        lesson.setName(lessonDTO.getName());
        lesson.setAvailable_places(lessonDTO.getAvailable_places());
        lessonRepository.save(lesson);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La clase ingresada no se ha encontrado."));
        lessonRepository.deleteById(lesson.getId());
    }
}