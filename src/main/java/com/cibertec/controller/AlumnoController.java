package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Alumno;
import com.cibertec.service.AlumnoService;

@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService service;
	
	@GetMapping()
	public ResponseEntity<?>  lista(){
		List<Alumno> lstSalida = service.listaAlumno();
		return ResponseEntity.ok(lstSalida);
	}
	@PostMapping
	public ResponseEntity<?>  inserta(@RequestBody Alumno obj){
		Alumno objSalida = service.insertaAlumno(obj);
		return ResponseEntity.ok(objSalida);
	}
}






