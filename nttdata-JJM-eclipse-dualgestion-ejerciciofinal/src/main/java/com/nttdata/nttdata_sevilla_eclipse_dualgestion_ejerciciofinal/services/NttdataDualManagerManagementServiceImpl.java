package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataDualManager;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataDualManagerRepositoryI;

/**
 * Proyecto Dual Gestion.
 * 
 * Implementación del servicio de DualManager.
 * 
 * @author Javier Jiménez Montesino
 *
 */

@Service
public class NttdataDualManagerManagementServiceImpl implements NttdataDualManagerManagementServiceI {

	@Autowired
	NttdataDualManagerRepositoryI repoDualManager;

	/* Logger */
	final static Logger LOG = LoggerFactory.getLogger(NttdataDualManagerManagementServiceImpl.class);

	@Override
	public void insertNewManager(NttdataDualManager newManager) {
		LOG.info("Entrada al método insertNewManager de la clase NttdataDualManagerManagementServiceImpl");
		// Verificación de nulidad e inexistencia.
		if (newManager != null && newManager.getIdManager() == null) {

			repoDualManager.saveAndFlush(newManager);
		}
		LOG.info("saliendo del metodo insertNewManager de la clase NttdataDualManagerManagementServiceImpl");
	}

	@Override
	public void deleteManager(NttdataDualManager Manager) {
		LOG.info("Entrada al método deleteManager de la clase NttdataDualManagerManagementServiceImpl");
		// Verificación de nulidad e inexistencia.
		if (Manager != null && Manager.getIdManager() != null) {

			repoDualManager.delete(Manager);
		}
		LOG.info("saliendo del metodo deleteManager de la clase NttdataDualManagerManagementServiceImpl");
	}

	@Override
	public Optional<NttdataDualManager> searchById(Integer ManagerID) {
		LOG.info("Entrada al método searchById de la clase NttdataDualManagerManagementServiceImpl");
		// Resultado.
		Optional<NttdataDualManager> dualManager = null;

		// Verificación de nulidad.
		if (ManagerID != null) {

			// Obtención del producto por ID.
			dualManager = repoDualManager.findById(ManagerID);
		}
		LOG.info("saliendo del metodo searchById de la clase NttdataDualManagerManagementServiceImpl");
		return dualManager;
	}

	@Override
	public List<NttdataDualManager> searchAll() {
		LOG.info("Entrada al método searchAll de la clase NttdataDualManagerManagementServiceImpl");
		// Resultado.
		List<NttdataDualManager> dualManagerList = new ArrayList<NttdataDualManager>();

		// Obtención del edificio.
		dualManagerList = repoDualManager.findAll();

		LOG.info("saliendo del metodo searchAll de la clase NttdataDualManagerManagementServiceImpl");

		return dualManagerList;
	}

	@Override
	public NttdataDualManager findByDNI(String DNI) {
		LOG.info("Entrada al método findByDNI de la clase NttdataDualManagerManagementServiceImpl");
		NttdataDualManager manager = null;

		if (DNI != null) {

			// Obtención del producto por ID.
			manager = repoDualManager.findByDNI(DNI);
		}
		LOG.info("saliendo del metodo findByDNI de la clase NttdataDualManagerManagementServiceImpl");
		return manager;
	}

}
