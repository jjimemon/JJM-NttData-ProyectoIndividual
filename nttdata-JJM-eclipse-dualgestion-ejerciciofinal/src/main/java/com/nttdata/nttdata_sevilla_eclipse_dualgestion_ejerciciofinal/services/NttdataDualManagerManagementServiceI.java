package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataDualManager;

/**
 * Proyecto Dual Gestion.
 * 
 * Interfaz del servicio de DualManager.
 * 
 * @author Javier Jiménez Montesino
 *
 */
public interface NttdataDualManagerManagementServiceI {

	/**
	 * Inserta un nuevo encargado.
	 * 
	 * @param newManager
	 */
	public void insertNewManager(final NttdataDualManager newManager);

	/**
	 * Borra un encargado
	 * 
	 * @param Manager
	 */
	public void deleteManager(final NttdataDualManager Manager);

	/**
	 * elimina un encargado existente.
	 * 
	 * @param ManagerID
	 */
	public Optional<NttdataDualManager> searchById(final Integer ManagerID);

	/**
	 * Obtiene todos los encargados existentes.
	 * 
	 * @return List<NttdataDualManager>
	 */
	public List<NttdataDualManager> searchAll();

	/**
	 * Obtiene el manager con un DNI concreto.
	 * 
	 * @return NttdataDualManager
	 */
	public NttdataDualManager findByDNI(String DNI);

}
