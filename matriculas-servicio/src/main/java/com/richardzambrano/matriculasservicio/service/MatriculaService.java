package com.richardzambrano.matriculasservicio.service;

import com.richardzambrano.matriculasservicio.client.AsignaturaClient;
import com.richardzambrano.matriculasservicio.client.UsuarioClient;
import com.richardzambrano.matriculasservicio.dto.MatriculaResponseDTO;
import com.richardzambrano.matriculasservicio.entity.Matricula;
import com.richardzambrano.matriculasservicio.repository.MatriculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MatriculaService {

    private final UsuarioClient usuarioClient;
    private final AsignaturaClient asignaturaClient;
    private final MatriculaRepository matriculaRepository;

    public String matricularEstudiante(Long usuarioId, Long asignaturaId) {
        MatriculaResponseDTO.UsuarioDTO usuario = usuarioClient.getUsuarioById(usuarioId);
        MatriculaResponseDTO.AsignaturaDTO asignatura = asignaturaClient.getAsignaturaById(asignaturaId);

        Matricula matricula = new Matricula();
        matricula.setIdUsuario(usuarioId);
        matricula.setIdAsignatura(asignaturaId);
        matricula.setFechaRegistro(LocalDate.now());

        matriculaRepository.save(matricula);

        return "Estudiante " + usuario.getNombre() +
                " matriculado en " + asignatura.getNombre();
    }
    public List<Matricula> listarTodas() {
        return matriculaRepository.findAll();
    }
    public List<Matricula> buscarPorEstudiante(Long idEstudiante) {
        return matriculaRepository.findByIdUsuario(idEstudiante);
    }

    public List<Matricula> buscarPorAsignatura(Long idAsignatura) {
        return matriculaRepository.findByIdAsignatura(idAsignatura);
    }

}
