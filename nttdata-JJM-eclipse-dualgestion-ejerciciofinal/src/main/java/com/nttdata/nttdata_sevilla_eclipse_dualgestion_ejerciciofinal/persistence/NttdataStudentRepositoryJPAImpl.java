package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Proyecto Spring taller 1.
 *
 * Implementación de la entidad estudiante.
 * 
 * @author Javier Jiménez Montesinos.
 *
 */
@Repository
public class NttdataStudentRepositoryJPAImpl implements NttdataStudentRepositoryJPAI {

	/** Manejador de entidades */
	@Autowired
	private EntityManager entityManager;

	/* Logger */
	final static Logger LOG = LoggerFactory.getLogger(NttdataStudentRepositoryJPAImpl.class);

	public NttdataStudent searchByDNI(String dni) {
		LOG.info("Entrada al metodo searchByDNI de la clase NttdataStudentRepositoryJPAImpl");
		// Obtención de sesión.
		Session session = entityManager.unwrap(Session.class);

		// Búsqueda por nombre aplicando JPA CRITERIA
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttdataStudent> cQuery = cb.createQuery(NttdataStudent.class);
		final Root<NttdataStudent> rootP = cQuery.from(NttdataStudent.class);
		final Join<NttdataStudent, NttdataCenter> pJoinT = rootP.join("center");

		final Predicate pr1 = cb.like(pJoinT.getParent().<String>get("DNI"), dni);

		cQuery.select(rootP).where(cb.and(pr1));

		final List<NttdataStudent> resultList = session.createQuery(cQuery).getResultList();

		NttdataStudent results = resultList.get(0);
		LOG.info("Salida del metodo searchByDNI de la clase NttdataStudentRepositoryJPAImpl");
		return results;

	}
}
