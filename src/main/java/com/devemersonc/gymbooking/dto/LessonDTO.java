package com.devemersonc.gymbooking.dto;

import com.devemersonc.gymbooking.model.User;

public class LessonDTO {
    private Long id;
    private String name;
    private int available_places;
    private UserDTO coach;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailable_places() {
        return available_places;
    }

    public void setAvailable_places(int available_places) {
        this.available_places = available_places;
    }

    public UserDTO getCoach() {
        return coach;
    }

    public void setCoach(UserDTO coach) {
        this.coach = coach;
    }
}
