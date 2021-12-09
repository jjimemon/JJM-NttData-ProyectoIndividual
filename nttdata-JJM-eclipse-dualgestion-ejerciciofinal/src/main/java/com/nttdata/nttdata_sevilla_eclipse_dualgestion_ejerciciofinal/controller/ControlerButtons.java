package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataCenter;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataDualManager;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataStudent;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services.NttdataCenterManagementServiceI;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services.NttdataDualManagerManagementServiceI;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services.NttdataStudentManagementServiceJPAI;

/**
 * Proyecto Dual Gestion.
 * 
 * Controlador de la ruta /home/welcome.
 * 
 * @author Javier Jiménez Montesino.
 * 
 */

@Controller
@RequestMapping("/home/welcome/")
public class ControlerButtons {
	@Autowired
	NttdataStudentManagementServiceJPAI serviceStudentJPA;
	@Autowired
	NttdataCenterManagementServiceI serviceCenter;
	@Autowired
	NttdataDualManagerManagementServiceI serviceManager;

	/* Logger */
	final static Logger LOG = LoggerFactory.getLogger(ControlerButtons.class);

	/**
	 * respuesta hacia vista la vista studentSearch.
	 * 
	 * Capta cualquier solicitud a /home/welcome/searchStudents
	 * 
	 * @return String
	 */
	@GetMapping("/searchStudents")
	public String oneStudentSearchView() {

		LOG.info("Entrada en el metodo oneStudentSearchView de la clase ControlesButtons");
		// Respuesta.
		final String responseBody = "studentSearch";
		System.out.println(responseBody);
		LOG.info("Saliendo del metodo oneStudentSearchView de la clase ControlesButtons");
		return responseBody;
	}

	/**
	 * respuesta hacia vista la vista searchCenters.
	 * 
	 * Capta cualquier solicitud a /home/welcome/searchCenters
	 * 
	 * @return String
	 */
	@GetMapping("/searchCenters")
	public String oneCenterSeachView() {
		LOG.info("Entrada en el metodo oneCenterSeachView de la clase ControlesButtons");
		// Respuesta.
		final String responseBody = "centerSearch";
		System.out.println(responseBody);
		LOG.info("Saliendo del metodo oneCenterSeachView de la clase ControlesButtons");
		return responseBody;
	}

	/**
	 * respuesta hacia vista la vista searchAsignatures.
	 * 
	 * Capta cualquier solicitud a /home/welcome/searchAsignatures
	 * 
	 * @return String
	 */
	@GetMapping("/searchAsignatures")
	public String oneAsignatureSeachView() {
		LOG.info("Entrada en el metodo oneAsignatureSeachView de la clase ControlesButtons");
		// Respuesta.
		final String responseBody = "asignatureSearch";
		System.out.println(responseBody);
		LOG.info("Saliendo del metodo oneAsignatureSeachView de la clase ControlesButtons");
		return responseBody;
	}

	/**
	 * respuesta hacia vista la vista searchDualManagers.
	 * 
	 * Capta cualquier solicitud a /home/welcome/searchDualManagers
	 * 
	 * @return String
	 */
	@GetMapping("/searchDualManagers")
	public String oneDualManagerSeachView() {
		LOG.info("Entrada en el metodo oneDualManagerSeachView de la clase ControlesButtons");
		// Respuesta.
		final String responseBody = "dualManagerSearch";
		System.out.println(responseBody);
		LOG.info("Saliendo del metodo oneDualManagerSeachView de la clase ControlesButtons");
		return responseBody;
	}

	@PostMapping("/studentFound")
	public String StudentFound(String DNI, Model model) {
		LOG.info("Entrada en el metodo StudentFound de la clase ControlesButtons");
		// Respuesta

		NttdataStudent studentFound = serviceStudentJPA.searchByDNI(DNI);

		model.addAttribute("student", studentFound);
		LOG.info("Saliendo del metodo StudentFound de la clase ControlesButtons");
		return "/showStudent";
	}

	@PostMapping("/centerFound")
	public String CenterFound(String CenterCif, Model model) {
		LOG.info("Entrada en el metodo CenterFound de la clase ControlesButtons");
		// Respuesta
		NttdataCenter centerFound = serviceCenter.findByCifCenter(CenterCif);

		model.addAttribute("center", centerFound);
		LOG.info("Saliendo del metodo CenterFound de la clase ControlesButtons");
		return "/showCenter";
	}

	@PostMapping("/dualManagerFound")
	public String DualManagerFound(String DNI, Model model) {
		LOG.info("Entrada en el metodo DualManagerFound de la clase ControlesButtons");
		// Respuesta
		NttdataDualManager managerFound = serviceManager.findByDNI(DNI);

		model.addAttribute("dualManager", managerFound);
		LOG.info("Saliendo del metodo DualManagerFound de la clase ControlesButtons");
		return "/showDualManager";

	}

}
