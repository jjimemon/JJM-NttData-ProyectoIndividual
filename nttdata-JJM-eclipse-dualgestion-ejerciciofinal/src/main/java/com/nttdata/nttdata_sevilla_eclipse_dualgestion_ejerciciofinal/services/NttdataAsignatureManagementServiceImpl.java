package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataAsignature;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataAsignatureRepositoryI;

/**
 * Proyecto Dual Gestion.
 * 
 * implentación del servicio de las asignaturas.
 * 
 * @author Javier Jiménez Montesino
 *
 */

@Service
public class NttdataAsignatureManagementServiceImpl implements NttdataAsignatureManagementServiceI {

	@Autowired
	NttdataAsignatureRepositoryI asignatureRepo;
	/* Logger */
	final static Logger LOG = LoggerFactory.getLogger(NttdataAsignatureManagementServiceImpl.class);

	@Override
	public void insertNewAsignature(NttdataAsignature newAsignature) {
		LOG.info("Entrada al método insertNewAsignature de la clase NttdataAsignatureManagementServiceImpl");
		// Verificación de nulidad e inexistencia.
		if (newAsignature != null && newAsignature.getIdAsignature() == null) {

			asignatureRepo.saveAndFlush(newAsignature);

		}
		LOG.info("saliendo del metodo insertNewAsignature de la clase NttdataAsignatureManagementServiceImpl");

	}

	@Override
	public void deleteAsignature(NttdataAsignature Asignature) {
		LOG.info("Entrada al método deleteAsignature de la clase NttdataAsignatureManagementServiceImpl");
		// Verificación de nulidad e inexistencia.
		if (Asignature != null && Asignature.getIdAsignature() != null) {

			asignatureRepo.delete(Asignature);

		}
		LOG.info("saliendo del metodo insertNewAsignature de la clase NttdataAsignatureManagementServiceImpl");

	}

	@Override
	public Optional<NttdataAsignature> searchById(Integer AsignatureID) {
		// Resultado.
		Optional<NttdataAsignature> asignature = null;
		LOG.info("Entrada al método searchById de la clase NttdataAsignatureManagementServiceImpl");
		// Verificación de nulidad.
		if (AsignatureID != null) {

			// Obtención del producto por ID.
			asignature = asignatureRepo.findById(AsignatureID);
		}
		LOG.info("saliendo del método searchById de la clase NttdataAsignatureManagementServiceImpl");
		return asignature;
	}

	@Override
	public List<NttdataAsignature> searchAll() {
		// Resultado.
		List<NttdataAsignature> asignatureList = new ArrayList<NttdataAsignature>();
		LOG.info("Entrada al método searchAll de la clase NttdataAsignatureManagementServiceImpl");

		// Obtención del edificio.
		asignatureList = asignatureRepo.findAll();

		LOG.info("saliendo del método searchAll de la clase NttdataAsignatureManagementServiceImpl");
		return asignatureList;
	}

}
