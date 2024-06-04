package com.arquitecturajava.web1cliente.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.arquitecturajava.web1cliente.bussinesdelegate.AlumnoBusinessDelegate;
import com.arquitecturajava.web1cliente.models.Alumno;

@Controller
public class AlumnoController {

	@Autowired
	AlumnoBusinessDelegate alumnoBussinesDelegate;

	@GetMapping("/listaalumnos")
	public String listaAlumnos(Model modelo) {

		modelo.addAttribute("lista", alumnoBussinesDelegate.buscarTodos());

		return "listaalumnos.xhtml";
	}

	@GetMapping("/formularioalumno")
	public String formularioAlumno() {

		return "formularioalumno.xhtml";
	}

	@PostMapping("/insertaralumno")
	public String formularioAlumno(@ModelAttribute Alumno alumno, Model modelo) {

		alumnoBussinesDelegate.insertar(alumno);
		modelo.addAttribute("lista", alumnoBussinesDelegate.buscarTodos());
		return "listaalumnos.xhtml";

	}

}
