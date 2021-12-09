package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataAsignature;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataCenter;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataDualManager;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence.NttdataStudent;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services.NttdataAsignatureManagementServiceI;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services.NttdataCenterManagementServiceI;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services.NttdataDualManagerManagementServiceI;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services.NttdataStudentManagementServiceI;
import com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.services.NttdataStudentManagementServiceJPAI;

/**
 * Proyecto Dual Gestion.
 *
 * Clase Main de la app.
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {

	/* Logger */
	final static Logger LOG = LoggerFactory.getLogger(App.class);

	@Autowired
	private NttdataStudentManagementServiceI serviceStudent;
	@Autowired
	private NttdataCenterManagementServiceI serviceCenter;
	@Autowired
	private NttdataStudentManagementServiceJPAI serviceStudentJPA;
	@Autowired
	private NttdataAsignatureManagementServiceI serviceAsignature;
	@Autowired
	private NttdataDualManagerManagementServiceI serviceDualManager;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		LOG.info("Programa finalizado");

	}

	@Override
	public void run(String... args) throws Exception {
		// Auditoría.
		final String updatedUser = "JAVIER_SYS";
		final Date updatedDate = new Date();

		// Generacion de encargados de dual
		LOG.info("Creando objetos en la main.");
		NttdataDualManager manager1 = new NttdataDualManager();
		manager1.setDNI("20049203B");
		manager1.setName("Julio");
		manager1.setSurname("Márquez");
		manager1.setTeacherCode("Cod300");
		manager1.setUpdatedDate(updatedDate);
		manager1.setUpdatedUser(updatedUser);

		NttdataDualManager manager2 = new NttdataDualManager();
		manager2.setDNI("20049203C");
		manager2.setName("Eva");
		manager2.setSurname("Martinez");
		manager2.setTeacherCode("Cod301");
		manager2.setUpdatedDate(updatedDate);
		manager2.setUpdatedUser(updatedUser);

		// Generacion de centros
		NttdataCenter center1 = new NttdataCenter();
		center1.setCifCenter("200F");
		center1.setDirectionCenter("Alfonso X el sabio");
		center1.setNameCenter("Hnos Machado");
		center1.setUpdatedDate(updatedDate);
		center1.setUpdatedUser(updatedUser);
		center1.setManager(manager1);

		// Generación de estudiantes.
		NttdataStudent student1 = new NttdataStudent();
		student1.setDNI("20061899B");
		student1.setName("Javier");
		student1.setLastname("Jiménez");
		student1.setUpdatedDate(updatedDate);
		student1.setUpdatedUser(updatedUser);
		student1.setCenter(center1);

		NttdataStudent student2 = new NttdataStudent();
		student2.setDNI("20341899B");
		student2.setName("Joger");
		student2.setLastname("Jiménez");
		student2.setUpdatedDate(updatedDate);
		student2.setUpdatedUser(updatedUser);
		student2.setCenter(center1);

		// Generación de asignaturas.
		NttdataAsignature asignature1 = new NttdataAsignature();
		asignature1.setCodeAsignature("COD:1");
		asignature1.setNameAsignature("Matemáticas");
		asignature1.setUpdatedDate(updatedDate);
		asignature1.setUpdatedUser(updatedUser);

		// Generación de asignaturas.
		NttdataAsignature asignature2 = new NttdataAsignature();
		asignature2.setCodeAsignature("COD:2");
		asignature2.setNameAsignature("Lengua");
		asignature2.setUpdatedDate(updatedDate);
		asignature2.setUpdatedUser(updatedUser);

		List<NttdataAsignature> lista = new ArrayList<NttdataAsignature>();
		lista.add(asignature1);
		lista.add(asignature2);
		student1.setListAsignature(lista);
		student2.setListAsignature(lista);
		LOG.info("Finalización de creación de objetos");

		LOG.info("Realizando Cruds");
		// LLamada a los servicios
		serviceAsignature.insertNewAsignature(asignature1);
		serviceAsignature.insertNewAsignature(asignature2);
		serviceDualManager.insertNewManager(manager1);
		serviceDualManager.insertNewManager(manager2);
		serviceCenter.insertNewCenter(center1);
		serviceStudent.insertNewStudent(student1);
		serviceStudent.insertNewStudent(student2);
		LOG.info("Cruds terminados.");

		LOG.info("Lanzamiento de consultas.");
		System.out.println(serviceStudentJPA.searchByDNI("20061899B"));
		System.out.println(serviceCenter.findByCifCenter("200F"));
		System.out.println(serviceDualManager.findByDNI("20049203C"));
		LOG.info("finalización de consultas.");

	}
}
