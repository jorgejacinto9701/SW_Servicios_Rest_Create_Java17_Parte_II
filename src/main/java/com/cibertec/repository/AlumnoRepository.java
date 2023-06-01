package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{

	
	@Query("select a from Alumno a where (?1 = -1 or a.idAlumno = ?1) and (a.nombre like ?2) and (?3 = '' or a.dni = ?3)")
	public List<Alumno>  listaAlumno(int idAlumno, String nombre, String dni);
}
