package com.arquitecturajava.web1cliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arquitecturajava.web1cliente.bussinesdelegate.AlumnoBusinessDelegate;

import es.curso.web1.dto.AlumnoDto;

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
	public String formularioAlumno(@ModelAttribute AlumnoDto alumno, Model modelo) {

		alumnoBussinesDelegate.insertar(alumno);
		modelo.addAttribute("lista", alumnoBussinesDelegate.buscarTodos());
		return "listaalumnos.xhtml";

	}

}
