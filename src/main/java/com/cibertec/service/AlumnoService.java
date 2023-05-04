package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Alumno;

public interface AlumnoService {

	public List<Alumno> listaAlumno();
	public Alumno insertaAlumno(Alumno obj);
}
