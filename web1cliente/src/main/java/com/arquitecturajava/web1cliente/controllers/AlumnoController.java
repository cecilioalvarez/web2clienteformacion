package com.arquitecturajava.web1cliente.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlumnoController {

	@GetMapping("/listaalumnos")
	public String listaAlumnos(Model modelo) {
		
		//List<Alumno> lista = alumnoExamenesService.buscarTodosAlumnos();

		// asigna a la plantilla una nombre de lista junto con los datos
		//modelo.addAttribute("lista", lista);

		return "listaalumnos.xhtml";

	}

	
}
