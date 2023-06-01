package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Alumno;

public interface AlumnoService {

	public List<Alumno> listaAlumno();
	public Alumno insertaAlumno(Alumno obj);
	public Optional<Alumno> buscaAlumno(int idAlumno);
	public List<Alumno>  listaAlumno(int idAlumno, String nombre, String dni);
	public void eliminaAlumno(int idAlumno);
	
}
