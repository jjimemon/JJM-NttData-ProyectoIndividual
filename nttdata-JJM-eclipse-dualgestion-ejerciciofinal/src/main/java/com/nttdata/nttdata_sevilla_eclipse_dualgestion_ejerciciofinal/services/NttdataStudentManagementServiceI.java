package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataStudent;

/**
 * Proyecto Dual Gestion.
 * 
 * Interfaz del servicio de estudiante.
 * 
 * @author Javier Jiménez Montesino
 *
 */

public interface NttdataStudentManagementServiceI {

	/**
	 * Inserta un nuevo estudiante.
	 * 
	 * @param newStudent
	 */
	public void insertNewStudent(final NttdataStudent newStudent);

	/**
	 * Borra un estudiante
	 * 
	 * @param Student
	 */
	public void deleteStudent(final NttdataStudent Student);

	/**
	 * elimina un estudiante existente.
	 * 
	 * @param studentID
	 */
	public Optional<NttdataStudent> searchById(final Integer studentID);

	/**
	 * Obtiene todos los estudiantes existentes.
	 * 
	 * @return List<NttdataStudent>
	 */
	public List<NttdataStudent> searchAll();

}
