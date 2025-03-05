package com.devemersonc.gymbooking.service;

import com.devemersonc.gymbooking.dto.BookingDTO;
import com.devemersonc.gymbooking.dto.NewBookingDTO;

import java.util.List;

public interface BookingService {
    List<BookingDTO> getBookings();
    BookingDTO getBooking(Long id);
    void saveBooking(NewBookingDTO bookingDTO);
    void deleteBooking(Long id);
}
