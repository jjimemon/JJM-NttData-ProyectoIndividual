package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Proyecto Dual Gestion.
 * 
 * Entidad de la tabla DualManager.
 * 
 * @author Javier Jiménez Montesino.
 *
 */
@Entity
@Table(name = "DUALMANAGER")
public class NttdataDualManager extends AbstractEntity implements Serializable {

	/**
	 * Versión
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Identificador del profesor (PK)
	 */
	private Integer IdManager;

	/*
	 * Código del profesor (Unique).
	 */
	private String teacherCode;

	/*
	 * DNI del profesor (Unique).
	 */
	private String DNI;

	/*
	 * Nombre del profesor.
	 */
	private String name;

	/*
	 * Apellido del profesor.
	 */
	private String surname;

	/*
	 * Centro del cual es manager.
	 */
	private NttdataCenter center;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdManager() {
		return IdManager;
	}

	public void setIdManager(Integer idManager) {
		IdManager = idManager;
	}

	@Column(name = "TeacherCode", nullable = false, unique = true)
	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	@Column(name = "DNI", nullable = false, unique = true)
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Surname", nullable = false)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@OneToOne(mappedBy = "manager")
	public NttdataCenter getCenter() {
		return center;
	}

	public void setCenter(NttdataCenter center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "NttdataDualManager [IdManager=" + IdManager + ", teacherCode=" + teacherCode + ", DNI=" + DNI
				+ ", name=" + name + ", surname=" + surname + "]";
	}

}
