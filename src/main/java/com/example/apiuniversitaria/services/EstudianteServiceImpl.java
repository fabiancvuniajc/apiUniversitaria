package com.example.apiuniversitaria.services;

import com.example.apiuniversitaria.controllers.dto.CreateEstudianteRequest;
import com.example.apiuniversitaria.controllers.dto.EstudianteResponse;
import com.example.apiuniversitaria.repositories.EstudianteRepository;
import com.example.apiuniversitaria.repositories.entities.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// El Service le permite a la clase ser administrada por la inversion de control de spring
@Service
public class EstudianteServiceImpl implements EstudianteService {

    //aca se declara la lista de estudiantes que va ser utilizada con injeccion de dependencia
    private final List<Estudiante> estudianteList;
    //aca se declara el repositorio que va ser utilizado con injeccion de dependencia
    private final EstudianteRepository estudianteRepository;

    //aca se realiza la injeccion de dependencia
    public EstudianteServiceImpl(List<Estudiante> estudianteList, EstudianteRepository estudianteRepository)
    {
        this.estudianteList = estudianteList;
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public Estudiante crear(CreateEstudianteRequest estudianteRequest) {

        Estudiante estudiante = EstudianteMapper.INSTANCE.toEstudiante(estudianteRequest);
        /*Estudiante estudiante = new Estudiante();
        estudiante.setDocumento(estudianteRequest.getDocumento());
        estudiante.setEdad(estudianteRequest.getEdad());
        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setEmail(estudianteRequest.getEmail());*/

        estudianteList.add(estudiante);
        //se hace uso de los metodos que se obtienen al extender de JPA
        estudianteRepository.save(estudiante);
        return estudiante;
    }

    @Override
    public List<EstudianteResponse> listar() {

        List<Estudiante> listaEstudiantes = estudianteRepository.findAll();
        return listaEstudiantes.stream()
                .map(EstudianteMapper.INSTANCE::toEstudianteResponse)
                .toList();
        /*return listaEstudiantes.stream().map(
                estudiante -> {
                    EstudianteResponse response = new EstudianteResponse();
                    response.setDocumento(estudiante.getDocumento());
                    response.setEmail(estudiante.getEmail());
                    response.setNombre(estudiante.getNombre());
                    return response;
                }).toList();*/
    }

    @Override
    public Estudiante actualizar(String documento, Estudiante estudiante) {

        List<Estudiante> listaActualizada = new ArrayList<>();

        for(int i = 0; i < estudianteList.size(); i++){
            if(estudianteList.get(i).getDocumento().equalsIgnoreCase(documento)){
                listaActualizada.add(estudiante);
                break;
            }
            listaActualizada.add(estudianteList.get(i));
        }

        estudianteList.clear();
        estudianteList.addAll(listaActualizada);

        return estudiante;
    }

    @Override
    public void borrar(String documento) {
        for(int i = 0; i < estudianteList.size(); i++){
            if(estudianteList.get(i).getDocumento().equalsIgnoreCase(documento)){
                estudianteList.remove(i);
                break;
            }
        }
    }

    @Override
    public Estudiante buscar(String documento) {
        for(int i = 0; i < estudianteList.size(); i++){
            if(estudianteList.get(i).getDocumento().equalsIgnoreCase(documento)){
                return estudianteList.get(i);
            }
        }
        return null;
    }
}
