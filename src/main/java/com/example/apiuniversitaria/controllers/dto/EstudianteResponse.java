package com.example.apiuniversitaria.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteResponse {

    private String nombre;
    private String documento;
    private String email;
}
