package com.richardzambrano.matriculasservicio;

import com.richardzambrano.matriculasservicio.client.AsignaturaClient;
import com.richardzambrano.matriculasservicio.client.UsuarioClient;
import com.richardzambrano.matriculasservicio.dto.MatriculaResponseDTO.AsignaturaDTO;
import com.richardzambrano.matriculasservicio.dto.MatriculaResponseDTO.UsuarioDTO;
import com.richardzambrano.matriculasservicio.entity.Matricula;
import com.richardzambrano.matriculasservicio.repository.MatriculaRepository;
import com.richardzambrano.matriculasservicio.service.MatriculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class MatriculasServicioApplicationTests {

	private UsuarioClient usuarioClient;
	private AsignaturaClient asignaturaClient;
	private MatriculaRepository matriculaRepository;
	private MatriculaService matriculaService;

	@BeforeEach
	void setUp() {
		usuarioClient = mock(UsuarioClient.class);
		asignaturaClient = mock(AsignaturaClient.class);
		matriculaRepository = mock(MatriculaRepository.class);
		matriculaService = new MatriculaService(usuarioClient, asignaturaClient, matriculaRepository);
	}

	@Test
	void testMatricularEstudiante() {
		Long usuarioId = 1L;
		Long asignaturaId = 2L;

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setId(usuarioId);
		usuario.setNombre("RichardZam");

		AsignaturaDTO asignatura = new AsignaturaDTO();
		asignatura.setId(asignaturaId);
		asignatura.setNombre("Microservicios");

		when(usuarioClient.getUsuarioById(usuarioId)).thenReturn(usuario);
		when(asignaturaClient.getAsignaturaById(asignaturaId)).thenReturn(asignatura);
		when(matriculaRepository.save(any(Matricula.class))).thenAnswer(invocation -> invocation.getArgument(0));

		String resultado = matriculaService.matricularEstudiante(usuarioId, asignaturaId);

		assertNotNull(resultado);
		assertTrue(resultado.contains("RichardZam"));
		assertTrue(resultado.contains("Microservicios"));

		verify(usuarioClient).getUsuarioById(usuarioId);
		verify(asignaturaClient).getAsignaturaById(asignaturaId);
		verify(matriculaRepository).save(any(Matricula.class));
	}

}

