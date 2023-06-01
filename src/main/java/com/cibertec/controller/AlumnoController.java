package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/porId/{id}")
	public ResponseEntity<?>  listaPorIdEnPath(@PathVariable Integer id){
		Optional<Alumno> optSalida = service.buscaAlumno(id);
		return ResponseEntity.ok(optSalida.get());
	}
	@GetMapping("/porId")
	public ResponseEntity<?>  listaPorIdEnParamaterer(
		@RequestParam(name = "id", defaultValue = "0", required = true ) Integer id){
		Optional<Alumno> optSalida = service.buscaAlumno(id);
		return ResponseEntity.ok(optSalida.get());
	}
	@GetMapping("/porIdNombreDni")
	public ResponseEntity<?>  listaporIdNombreDni(
		@RequestParam(name = "id", defaultValue = "-1", required = false ) int id,
		@RequestParam(name = "nombre", defaultValue = "%", required = false ) String nombre,
		@RequestParam(name = "dni", defaultValue = "", required = false ) String dni){
		List<Alumno> lstAlumno = service.listaAlumno(id, nombre+"%", dni);
		return ResponseEntity.ok(lstAlumno);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  eliminaAlumno(@PathVariable Integer id){
		service.eliminaAlumno(id);
		Optional<Alumno> optAlumno = service.buscaAlumno(id);
		if (optAlumno.isEmpty()) {
			return ResponseEntity.ok("Eliminación exitosa");
		}
		return ResponseEntity.ok("No existe el id " + id);
	}
	
	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Alumno obj){
		Optional<Alumno> optAlumno = service.buscaAlumno(obj.getIdAlumno());
		if (optAlumno.isPresent()) {
			Alumno objSalida = service.insertaAlumno(obj);
			return ResponseEntity.ok(objSalida);
		}else {
			return ResponseEntity.ok("El alumno no existe");
		}
	}
}






