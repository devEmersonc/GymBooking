package com.devemersonc.gymbooking.mapper;

import com.devemersonc.gymbooking.dto.LessonDTO;
import com.devemersonc.gymbooking.model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface LessonMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "coach", source = "coach")
    LessonDTO toDto(Lesson lesson);
    List<LessonDTO> toDtoList(List<Lesson> lessons);
}
