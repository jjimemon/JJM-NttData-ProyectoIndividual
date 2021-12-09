package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataAsignature;

/**
 * Proyecto Dual Gestion.
 * 
 * Interfaz del servicio de las asignaturas.
 * 
 * @author Javier Jiménez Montesino
 *
 */

public interface NttdataAsignatureManagementServiceI {
	/**
	 * Inserta una nueva asignatura.
	 * 
	 * @param newAsignature
	 */
	public void insertNewAsignature(final NttdataAsignature newAsignature);

	/**
	 * Borra una asignatura.
	 * 
	 * @param Asignature
	 */
	public void deleteAsignature(final NttdataAsignature Asignature);

	/**
	 * elimina una asignatura existente.
	 * 
	 * @param AsignatureID
	 */
	public Optional<NttdataAsignature> searchById(final Integer AsignatureID);

	/**
	 * Obtiene todas las asignaturas existentes.
	 * 
	 * @return List<NttdataAsignature>
	 */
	public List<NttdataAsignature> searchAll();
}
