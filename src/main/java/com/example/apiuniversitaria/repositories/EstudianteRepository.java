package com.example.apiuniversitaria.repositories;

import com.example.apiuniversitaria.repositories.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

// El Repository le permite a la interface ser administrada por la inversion de control de spring
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    //Select * from Estudiante where documento = 'miDocumento"
    Estudiante findByDocumento(String documento);

    /*@NativeQuery(value = "Select * from estudiante where documento =?1")
    Estudiante findByDocumentoNative(String documento);*/
}
