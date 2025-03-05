package com.devemersonc.gymbooking.service.serviceImpl.userServiceImpl.bookingServiceImpl;

import com.devemersonc.gymbooking.dto.BookingDTO;
import com.devemersonc.gymbooking.dto.NewBookingDTO;
import com.devemersonc.gymbooking.exception.NoAvailableSpotsException;
import com.devemersonc.gymbooking.exception.ResourceNotFoundException;
import com.devemersonc.gymbooking.mapper.BookingMapper;
import com.devemersonc.gymbooking.model.Booking;
import com.devemersonc.gymbooking.model.Lesson;
import com.devemersonc.gymbooking.model.User;
import com.devemersonc.gymbooking.repository.BookingRepository;
import com.devemersonc.gymbooking.repository.LessonRepository;
import com.devemersonc.gymbooking.repository.UserRepository;
import com.devemersonc.gymbooking.service.BookingService;
import com.devemersonc.gymbooking.service.SecurityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingMapper bookingMapper;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;
    private final SecurityService securityService;

    public BookingServiceImpl(BookingMapper bookingMapper, BookingRepository bookingRepository, UserRepository userRepository, LessonRepository lessonRepository, SecurityService securityService) {
        this.bookingMapper = bookingMapper;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
        this.securityService = securityService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public List<BookingDTO> getBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookingMapper.toDtoList(bookings);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public BookingDTO getBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada."));
        return bookingMapper.toDto(booking);
    }

    @Override
    public void saveBooking(NewBookingDTO bookingDTO) {
        Booking booking = new Booking();
        Lesson lesson = lessonRepository.findById(bookingDTO.getLesson_id()).orElseThrow(() -> new ResourceNotFoundException("La clase ingresada no se ha encontrado."));
        User user = securityService.getAuthenticateUser();

        if(lesson.getAvailable_places() < 0) {
            throw new NoAvailableSpotsException("No hay cupos disponibles para esta clase.");
        }
        booking.setClient(user);
        booking.setLesson(lesson);
        bookingRepository.save(booking);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La clase ingresada no se ha encontrado."));
        bookingRepository.deleteById(booking.getId());
    }
}
