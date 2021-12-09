package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Proyecto Dual Gestion.
 * 
 * Estudiante Repository.
 * 
 * @author Javier Jiménez Montesino
 *
 */
@Repository
public interface NttdataStudentRepositoryI extends JpaRepository<NttdataStudent, Integer> {

}
