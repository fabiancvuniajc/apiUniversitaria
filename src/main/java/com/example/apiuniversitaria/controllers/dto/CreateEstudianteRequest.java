package com.example.apiuniversitaria.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEstudianteRequest {

    private String nombre;
    private String documento;
    private String email;
    private int edad;
}
