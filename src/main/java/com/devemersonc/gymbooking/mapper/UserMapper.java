package com.devemersonc.gymbooking.mapper;

import com.devemersonc.gymbooking.dto.UserDTO;
import com.devemersonc.gymbooking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);
    List<UserDTO> toDtoList(List<User> users);
}
