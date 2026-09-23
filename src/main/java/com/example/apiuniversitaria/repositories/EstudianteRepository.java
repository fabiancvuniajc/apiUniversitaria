package com.example.apiuniversitaria.repositories;

import com.example.apiuniversitaria.repositories.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// El Repository le permite a la interface ser administrada por la inversion de control de spring
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
