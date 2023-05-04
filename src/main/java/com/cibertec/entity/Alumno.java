package com.cibertec.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlumno;
	
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column(length = 8, nullable = false)
	private String dni;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaNacimiento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date fechaRegistro;
	
	
}



