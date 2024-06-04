package com.arquitecturajava.web1cliente.bussinesdelegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arquitecturajava.web1cliente.models.Alumno;

@Service
public class AlumnoBusinessDelegate {

	@Autowired
	RestTemplate plantilla;
	@Value("${servidor.examenes}")
	private String servidorExamenes;

	public void insertar(Alumno alumno) {

		plantilla.postForEntity(servidorExamenes + "/webapi/alumnos", alumno, Alumno.class);

	}

	public List<Alumno> buscarTodos() {

		Alumno[] listaArray = plantilla.getForEntity(servidorExamenes + "/webapi/alumnos", Alumno[].class).getBody();
		return Arrays.asList(listaArray);

	}
}
