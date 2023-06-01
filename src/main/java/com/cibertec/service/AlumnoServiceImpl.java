package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Alumno;
import com.cibertec.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public List<Alumno> listaAlumno() {
		return repository.findAll();
	}

	@Override
	public Alumno insertaAlumno(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Alumno> buscaAlumno(int idAlumno) {
		return repository.findById(idAlumno);
	}

	@Override
	public List<Alumno> listaAlumno(int idAlumno, String nombre, String dni) {
		return repository.listaAlumno(idAlumno, nombre, dni);
	}

	@Override
	public void eliminaAlumno(int idAlumno) {
		repository.deleteById(idAlumno);
	}

}


