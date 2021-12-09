package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Proyecto Dual Gestion.
 * 
 * Controlador de excepciones global.
 * 
 * @author Javier Jiménez Montesino.
 * 
 */

@ControllerAdvice
public class ControlerException {

	/* Logger */
	final static Logger LOG = LoggerFactory.getLogger(ControlerException.class);

	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest req, Exception e) {
		LOG.error(
				"Ha entrado en el metodo handleException de la clase ControlerException, a ocurrido un fallo en la aplicacion.");
		// Respuesta.
		final String responseBody = "Algo está mal...";
		System.out.println(responseBody);

		return responseBody;
	}

}
