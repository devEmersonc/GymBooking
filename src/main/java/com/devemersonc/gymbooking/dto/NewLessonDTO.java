package com.devemersonc.gymbooking.dto;

import jakarta.validation.constraints.NotBlank;

public class NewLessonDTO {
    @NotBlank(message = "El nombre de la clase es obligatorio.")
    private String name;
    private int available_places;

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
}
