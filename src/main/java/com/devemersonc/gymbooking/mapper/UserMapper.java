package com.devemersonc.gymbooking.mapper;

import com.devemersonc.gymbooking.dto.UserDTO;
import com.devemersonc.gymbooking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User user);
}
