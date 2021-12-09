package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataStudent;

/**
 * Proyecto Dual Gestion.
 * 
 * Interfaz del servicio de estudiante JPA.
 * 
 * @author Javier Jiménez Montesino
 *
 */

public interface NttdataStudentManagementServiceJPAI {

	public NttdataStudent searchByDNI(String dni);

}
