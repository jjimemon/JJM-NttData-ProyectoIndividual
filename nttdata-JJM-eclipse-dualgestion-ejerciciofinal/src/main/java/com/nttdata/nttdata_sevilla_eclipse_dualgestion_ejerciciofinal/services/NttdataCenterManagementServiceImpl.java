package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataCenter;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataCenterRepositoryI;

/**
 * Proyecto Dual Gestion.
 * 
 * Implementación del servicio de Center.
 * 
 * @author Javier Jiménez Montesino
 *
 */

@Service
public class NttdataCenterManagementServiceImpl implements NttdataCenterManagementServiceI {

	@Autowired
	NttdataCenterRepositoryI repoCenter;

	final static Logger LOG = LoggerFactory.getLogger(NttdataCenterManagementServiceImpl.class);

	@Override
	public void insertNewCenter(NttdataCenter newCenter) {
		LOG.info("Entrada al método insertNewCenter de la clase NttdataCenterManagementServiceImpl");

		// Verificación de nulidad e inexistencia.
		if (newCenter != null && newCenter.getIdCenter() == null) {

			repoCenter.saveAndFlush(newCenter);
		}
		LOG.info("Saliendo del método insertNewCenter de la clase NttdataCenterManagementServiceImpl");

	}

	@Override
	public void deleteCenter(NttdataCenter Center) {
		LOG.info("Entrada al método deleteCenter de la clase NttdataCenterManagementServiceImpl");

		// Verificación de nulidad e inexistencia.
		if (Center != null && Center.getIdCenter() != null) {

			repoCenter.delete(Center);

		}
		LOG.info("Saliendo del método deleteCenter de la clase NttdataCenterManagementServiceImpl");

	}

	@Override
	public Optional<NttdataCenter> searchById(Integer CenterID) {
		LOG.info("Entrada al método searchById de la clase NttdataCenterManagementServiceImpl");
		// Resultado.
		Optional<NttdataCenter> dualManager = null;

		// Verificación de nulidad.
		if (CenterID != null) {

			// Obtención del producto por ID.
			dualManager = repoCenter.findById(CenterID);

		}
		LOG.info("Saliendo del método searchById de la clase NttdataCenterManagementServiceImpl");
		return dualManager;
	}

	@Override
	public List<NttdataCenter> searchAll() {
		LOG.info("Entrada al método searchAll de la clase NttdataCenterManagementServiceImpl");
		// Resultado.
		List<NttdataCenter> centerList = new ArrayList<NttdataCenter>();

		// Obtención del edificio.
		centerList = repoCenter.findAll();
		LOG.info("Saliendo del método searchAll de la clase NttdataCenterManagementServiceImpl");
		return centerList;
	}

	@Override
	public NttdataCenter findByCifCenter(String cif) {
		LOG.info("Entrada al método findByCifCenter de la clase NttdataCenterManagementServiceImpl");
		NttdataCenter center = null;

		// Verificación de nulidad.
		if (cif != null) {

			// Obtención del producto por ID.
			center = repoCenter.findByCifCenter(cif);
		}
		LOG.info("Saliendo del método findByCifCenter de la clase NttdataCenterManagementServiceImpl");
		return center;
	}

}
