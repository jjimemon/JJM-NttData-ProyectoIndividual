package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataCenter;

/**
 * Proyecto Dual Gestion.
 * 
 * Interfaz del servicio de los centros.
 * 
 * @author Javier Jiménez Montesino
 *
 */
public interface NttdataCenterManagementServiceI {
	/**
	 * Inserta un nuevo centro.
	 * 
	 * @param newStudent
	 */
	public void insertNewCenter(final NttdataCenter newCenter);

	/**
	 * Borra un centro
	 * 
	 * @param Student
	 */
	public void deleteCenter(final NttdataCenter Center);

	/**
	 * elimina un centro existente.
	 * 
	 * @param studentID
	 */
	public Optional<NttdataCenter> searchById(final Integer CenterID);

	/**
	 * Obtiene todos los centro existentes.
	 * 
	 * @return List<NttdataCenter>
	 */
	public List<NttdataCenter> searchAll();

	/**
	 * Obtiene un centro con un cif concreto.
	 * 
	 * @return NttdataCenter
	 */
	public NttdataCenter findByCifCenter(String cif);
}
