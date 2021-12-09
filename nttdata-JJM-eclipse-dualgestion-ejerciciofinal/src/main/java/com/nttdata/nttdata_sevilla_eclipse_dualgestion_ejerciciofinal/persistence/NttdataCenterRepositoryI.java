package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Proyecto Dual Gestion.
 * 
 * Center Dao Interfaz.
 * 
 * @author Javier Jiménez Montesino
 *
 */
@Repository
public interface NttdataCenterRepositoryI extends JpaRepository<NttdataCenter, Integer> {

	/*
	 * Devuelve el centro con un cif concreto
	 */
	public NttdataCenter findByCifCenter(String cif);
}
