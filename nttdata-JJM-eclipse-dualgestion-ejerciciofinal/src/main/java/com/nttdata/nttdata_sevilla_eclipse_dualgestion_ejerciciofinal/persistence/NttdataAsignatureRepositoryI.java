package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Proyecto Dual Gestion.
 * 
 * Repository de la clase NttdataAsignatura.
 * 
 * @author Javier Jiménez Montesino.
 * 
 */

@Repository
public interface NttdataAsignatureRepositoryI extends JpaRepository<NttdataAsignature, Integer> {

}
