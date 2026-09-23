package com.example.apiuniversitaria.services;

import com.example.apiuniversitaria.controllers.dto.CreateEstudianteRequest;
import com.example.apiuniversitaria.controllers.dto.EstudianteResponse;
import com.example.apiuniversitaria.repositories.entities.Estudiante;

import java.util.List;

public interface EstudianteService {

    List<EstudianteResponse> listar();

    Estudiante crear(CreateEstudianteRequest
                             estudiante);

    Estudiante buscar(String documento);

    Estudiante actualizar(String documento,
                          Estudiante estudiante);

    void borrar(String documento);
}
