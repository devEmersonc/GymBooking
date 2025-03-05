package com.devemersonc.gymbooking.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classes")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int available_places;
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private User coach;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public User getCoach() {
        return coach;
    }

    public void setCoach(User coach) {
        this.coach = coach;
    }

    public int getAvailable_places() {
        return available_places;
    }

    public void setAvailable_places(int available_places) {
        this.available_places = available_places;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}