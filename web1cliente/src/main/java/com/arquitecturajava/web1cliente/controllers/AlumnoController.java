package com.arquitecturajava.web1cliente.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.arquitecturajava.web1cliente.models.Alumno;

@Controller
public class AlumnoController {

	@Autowired
	RestTemplate plantilla;
	@Value("${servidor.examenes}")
	private String servidorExamenes;
	
	@GetMapping("/listaalumnos")
	public String listaAlumnos(Model modelo) {
		
	
		
		Alumno[] listaArray=plantilla.getForEntity(servidorExamenes+"/webapi/alumnos", Alumno[].class).getBody();

	
		modelo.addAttribute("lista",Arrays.asList(listaArray) );

		return "listaalumnos.xhtml";

	}

	
}
