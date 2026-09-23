package com.example.apiuniversitaria.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Curso {

    private String nombre;
    private int cupo;
    private String grupo;
    private String codigo;
}
