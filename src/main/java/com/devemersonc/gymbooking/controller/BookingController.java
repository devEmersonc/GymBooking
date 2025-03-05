package com.devemersonc.gymbooking.controller;

import com.devemersonc.gymbooking.dto.BookingDTO;
import com.devemersonc.gymbooking.dto.NewBookingDTO;
import com.devemersonc.gymbooking.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getBookings() {
        List<BookingDTO> bookings = bookingService.getBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable Long id) {
        BookingDTO booking = bookingService.getBooking(id);
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<String> saveBooking(@RequestBody NewBookingDTO bookingDTO) {
        bookingService.saveBooking(bookingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva exitosa.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Reserva eliminada con éxito.");
    }
}
