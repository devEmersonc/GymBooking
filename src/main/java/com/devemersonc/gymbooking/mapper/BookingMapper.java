package com.devemersonc.gymbooking.mapper;

import com.devemersonc.gymbooking.dto.BookingDTO;
import com.devemersonc.gymbooking.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, LessonMapper.class})
public interface BookingMapper {

    @Mapping(target = "client", source = "client")
    @Mapping(target = "lesson", source = "lesson")
    BookingDTO toDto(Booking booking);
    List<BookingDTO> toDtoList(List<Booking> bookings);
}
