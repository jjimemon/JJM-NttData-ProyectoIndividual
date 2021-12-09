package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Proyecto Dual Gestion.
 * 
 * Entidad de la tabla estudiante.
 * 
 * @author Javier Jiménez Montesino.
 *
 */
@Entity
@Table(name = "STUDENT")
public class NttdataStudent extends AbstractEntity implements Serializable {

	/**
	 * Versión
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * ID del estudiante, generado automáticamente (PK).
	 */
	private Integer IdStudent;
	/*
	 * Documento de identificación del estudiante(Unico).
	 */
	private String DNI;

	/*
	 * Nombre del estudiante
	 */
	private String name;

	/*
	 * Apellido del estudiante
	 */
	private String lastname;

	/*
	 * Centro al que pertenece
	 */
	private NttdataCenter center;

	/*
	 * Lista de asignaturas del estudiante.
	 */
	private List<NttdataAsignature> listAsignature;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdStudent() {
		return IdStudent;
	}

	public void setIdStudent(Integer idStudent) {
		IdStudent = idStudent;
	}

	@Column(name = "DNI", nullable = false, unique = true)
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "LASTNAME", nullable = false)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "IdCenter")
	public NttdataCenter getCenter() {
		return center;
	}

	public void setCenter(NttdataCenter center) {
		this.center = center;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "Student_Asignature", joinColumns = { @JoinColumn(name = "idStudent") }, inverseJoinColumns = {
			@JoinColumn(name = "idAsignature") })
	public List<NttdataAsignature> getListAsignature() {
		return listAsignature;
	}

	public void setListAsignature(List<NttdataAsignature> listAsignature) {
		this.listAsignature = listAsignature;
	}

	@Override
	public String toString() {
		return "NttdataStudent [IdStudent=" + IdStudent + ", DNI=" + DNI + ", name=" + name + ", lastname=" + lastname
				+ ", center=" + center + "]";
	}

}
