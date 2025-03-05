package com.devemersonc.gymbooking.dto;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NewBookingDTO {
    private Date reservation_date;
    private Long lesson_id;

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public Long getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Long lesson_id) {
        this.lesson_id = lesson_id;
    }
}
