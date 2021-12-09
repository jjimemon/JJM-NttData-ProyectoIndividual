package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Proyecto Dual Gestion.
 * 
 * DualManager Repository.
 * 
 * @author Javier Jiménez Montesino
 *
 */
@Repository
public interface NttdataDualManagerRepositoryI extends JpaRepository<NttdataDualManager, Integer> {

	/*
	 * Devuelve un manager con un dni concreto
	 */
	public NttdataDualManager findByDNI(String DNI);
}
