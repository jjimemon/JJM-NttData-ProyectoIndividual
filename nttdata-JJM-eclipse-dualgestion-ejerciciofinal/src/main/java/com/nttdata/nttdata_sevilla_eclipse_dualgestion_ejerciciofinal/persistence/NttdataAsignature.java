package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Proyecto Dual Gestion.
 * 
 * Entidad de la tabla asignatura.
 * 
 * @author Javier Jiménez Montesino.
 *
 */
@Entity
@Table(name = "ASIGNATURE")
public class NttdataAsignature extends AbstractEntity implements Serializable {

	/**
	 * Versión
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Identificador de la asignatura (PK).
	 */

	private Integer IdAsignature;
	/*
	 * Código de la asignatura (Unique).
	 */
	private String codeAsignature;
	/*
	 * Nombre de la asignatura.
	 */
	private String nameAsignature;

	/*
	 * lista de alumnos con esa asignatura.
	 */
	private List<NttdataStudent> studentList;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdAsignature() {
		return IdAsignature;
	}

	public void setIdAsignature(Integer idAsignature) {
		IdAsignature = idAsignature;
	}

	@Column(name = "ASIGNATURE_CODE", nullable = false, unique = true)
	public String getCodeAsignature() {
		return codeAsignature;
	}

	public void setCodeAsignature(String codeAsignature) {
		this.codeAsignature = codeAsignature;
	}

	@Column(name = "NAME", nullable = false)
	public String getNameAsignature() {
		return nameAsignature;
	}

	public void setNameAsignature(String nameAsignature) {
		this.nameAsignature = nameAsignature;
	}

	@ManyToMany(mappedBy = "listAsignature")
	public List<NttdataStudent> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<NttdataStudent> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "NttdataAsignature [IdAsignature=" + IdAsignature + ", codeAsignature=" + codeAsignature
				+ ", nameAsignature=" + nameAsignature + ", studentList=" + studentList + "]";
	}

}
