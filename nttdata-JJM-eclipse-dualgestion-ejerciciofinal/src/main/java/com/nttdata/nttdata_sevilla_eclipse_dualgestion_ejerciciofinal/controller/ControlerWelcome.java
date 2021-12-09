package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Proyecto Dual Gestion.
 * 
 * Controlador de la ruta /home/.
 * 
 * @author Javier Jiménez Montesino.
 * 
 */

@Controller
@RequestMapping("/home/")
public class ControlerWelcome {

	/* Logger */
	final static Logger LOG = LoggerFactory.getLogger(ControlerWelcome.class);

	/**
	 * respuesta hacia vista la vista index.
	 * 
	 * Capta cualquier solicitud a /home/welcome
	 * 
	 * @return String
	 */
	@GetMapping("/welcome")
	public String oneIndexView() {
		LOG.info("Entrada al metodo oneIndexView de la clase ControlerWelcome");
		// Respuesta.
		final String responseBody = "index";
		System.out.println(responseBody);
		LOG.info("Salida del metodo oneIndexView de la clase ControlerWelcome");
		return responseBody;
	}
}
