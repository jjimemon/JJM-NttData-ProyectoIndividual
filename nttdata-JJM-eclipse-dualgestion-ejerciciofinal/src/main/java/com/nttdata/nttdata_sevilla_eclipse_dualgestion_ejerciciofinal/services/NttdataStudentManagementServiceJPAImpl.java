package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataStudent;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataStudentRepositoryJPAI;

/**
 * Proyecto Dual Gestion.
 * 
 * Implementación del servicio de estudiante JPA.
 * 
 * @author Javier Jiménez Montesino
 *
 */
@Service
public class NttdataStudentManagementServiceJPAImpl implements NttdataStudentManagementServiceJPAI {

	@Autowired
	NttdataStudentRepositoryJPAI studentRepoJPA;

	/* Logger */
	final static Logger LOG = LoggerFactory.getLogger(NttdataStudentManagementServiceJPAImpl.class);

	@Override
	public NttdataStudent searchByDNI(String dni) {
		LOG.info("Entrada al método searchByDNI de la clase NttdataStudentManagementServiceJPAImpl");
		// Resultado.
		NttdataStudent student = new NttdataStudent();

		// Verificación de nulidad.
		if (StringUtils.hasText(dni)) {

			student = studentRepoJPA.searchByDNI(dni);

		}
		LOG.info("saliendo del metodo searchByDNI de la clase NttdataStudentManagementServiceJPAImpl");
		return student;
	}

}
