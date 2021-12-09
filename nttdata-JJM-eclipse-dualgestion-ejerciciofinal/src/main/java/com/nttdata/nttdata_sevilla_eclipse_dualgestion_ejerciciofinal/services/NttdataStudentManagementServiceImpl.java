package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataStudent;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataStudentRepositoryI;

/**
 * Proyecto Dual Gestion.
 * 
 * Implementación del servicio de Student.
 * 
 * @author Javier Jiménez Montesino
 *
 */
@Service
public class NttdataStudentManagementServiceImpl implements NttdataStudentManagementServiceI {

	@Autowired
	private NttdataStudentRepositoryI studentRepo;

	/* Logger */
	final static Logger LOG = LoggerFactory.getLogger(NttdataStudentManagementServiceImpl.class);

	@Override
	public void insertNewStudent(NttdataStudent newStudent) {
		LOG.info("Entrada al método insertNewStudent de la clase NttdataStudentManagementServiceImpl");
		// Verificación de nulidad e inexistencia.
		if (newStudent != null && newStudent.getIdStudent() == null) {

			studentRepo.saveAndFlush(newStudent);
		}
		LOG.info("saliendo del metodo insertNewStudent de la clase NttdataStudentManagementServiceImpl");
	}

	@Override
	public void deleteStudent(NttdataStudent Student) {
		LOG.info("Entrada al método deleteStudent de la clase NttdataStudentManagementServiceImpl");
		// Verificación de nulidad e inexistencia.
		if (Student != null && Student.getIdStudent() != null) {

			studentRepo.delete(Student);
		}
		LOG.info("saliendo del metodo deleteStudent de la clase NttdataStudentManagementServiceImpl");
	}

	@Override
	public Optional<NttdataStudent> searchById(Integer studentID) {
		LOG.info("Entrada al método searchById de la clase NttdataStudentManagementServiceImpl");
		// Resultado.
		Optional<NttdataStudent> student = null;

		// Verificación de nulidad.
		if (studentID != null) {

			// Obtención del producto por ID.
			student = studentRepo.findById(studentID);
		}
		LOG.info("saliendo del metodo searchById de la clase NttdataStudentManagementServiceImpl");
		return student;
	}

	@Override
	public List<NttdataStudent> searchAll() {
		LOG.info("Entrada al método searchAll de la clase NttdataStudentManagementServiceImpl");
		// Resultado.
		List<NttdataStudent> studentList = new ArrayList<NttdataStudent>();

		// Obtención del edificio.
		studentList = studentRepo.findAll();
		LOG.info("saliendo del metodo searchAll de la clase NttdataStudentManagementServiceImpl");
		return studentList;
	}

}
