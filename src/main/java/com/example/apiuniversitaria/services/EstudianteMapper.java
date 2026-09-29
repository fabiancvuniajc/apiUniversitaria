package com.example.apiuniversitaria.services;

import com.example.apiuniversitaria.controllers.dto.CreateEstudianteRequest;
import com.example.apiuniversitaria.controllers.dto.EstudianteResponse;
import com.example.apiuniversitaria.repositories.entities.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstudianteMapper {

    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Mapping(source = "documento", target = "documento")
    Estudiante toEstudiante(CreateEstudianteRequest createEstudianteRequest);

    EstudianteResponse toEstudianteResponse(Estudiante estudiante);
}
