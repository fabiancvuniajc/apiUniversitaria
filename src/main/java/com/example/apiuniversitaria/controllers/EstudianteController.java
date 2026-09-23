package com.example.apiuniversitaria.controllers;

import com.example.apiuniversitaria.controllers.dto.CreateEstudianteRequest;
import com.example.apiuniversitaria.controllers.dto.EstudianteResponse;
import com.example.apiuniversitaria.repositories.entities.Estudiante;
import com.example.apiuniversitaria.services.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// El restController le permite a la clase ser administrada por la inversion de control de spring
@RestController
// El request mapping es el encargo de establecer la raiz de la url del controlador
@RequestMapping("/api/v1/estudiantes")
// Sirve para identificar que hace el controlador
@Tag(name = "Estudiantes", description = "Administracion de estudiantes universitarios")
public class EstudianteController {

    //aca se declara el servicio que va ser utilizado con injeccion de dependencia
    private final EstudianteService estudianteService;

    //aca se realiza la injeccion de dependencia
    public EstudianteController(EstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }

    @GetMapping
    @Operation(summary = "Consulta de estudiantes", description = "Consulta de estudiantes universitarios")
    @ApiResponse(responseCode = "200", description = "Consulta de estudiantes exitosa")
    @ApiResponse(responseCode = "503", description = "Error interno")
    public ResponseEntity<List<EstudianteResponse>> listar(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(estudianteService.listar());
    }

    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody CreateEstudianteRequest estudiante){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(estudianteService.crear(estudiante));
    }

    @GetMapping("/{documento}")
    public ResponseEntity<Void> buscar(@PathVariable String documento){
        estudianteService.borrar(documento);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PutMapping("/{documento}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable String documento,
                                                 @RequestBody Estudiante estudiante){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(estudianteService.actualizar(documento, estudiante));
    }

    @DeleteMapping("/{documento}")
    public ResponseEntity<Estudiante> borrar(@PathVariable String documento){;
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(estudianteService.buscar(documento));
    }
}
