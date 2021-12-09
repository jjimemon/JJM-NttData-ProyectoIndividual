package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Proyecto Dual Gestion.
 * 
 * Entidad de la tabla centros.
 * 
 * @author Javier Jiménez Montesino.
 *
 */
@Entity
@Table(name = "CENTER")
public class NttdataCenter extends AbstractEntity implements Serializable {

	/**
	 * Versión
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Identificador del centro (PK)
	 */
	private Integer IdCenter;

	/*
	 * Cif del centro (Unique)
	 */
	private String CifCenter;

	/*
	 * Nombre del centro
	 */
	private String nameCenter;

	/*
	 * Dirección del centro
	 * 
	 */
	private String directionCenter;

	/*
	 * Lista de estudiantes del centro.
	 */
	private List<NttdataStudent> studentList;

	/*
	 * Encargado del centro.
	 */
	private NttdataDualManager manager;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdCenter() {
		return IdCenter;
	}

	public void setIdCenter(Integer idCenter) {
		IdCenter = idCenter;
	}

	@Column(name = "CIF", nullable = false, unique = true)
	public String getCifCenter() {
		return CifCenter;
	}

	public void setCifCenter(String cifCenter) {
		CifCenter = cifCenter;
	}

	@Column(name = "NAME", nullable = false)
	public String getNameCenter() {
		return nameCenter;
	}

	public void setNameCenter(String nameCenter) {
		this.nameCenter = nameCenter;
	}

	@Column(name = "DIRECTION", nullable = false)
	public String getDirectionCenter() {
		return directionCenter;
	}

	public void setDirectionCenter(String directionCenter) {
		this.directionCenter = directionCenter;
	}

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "center")
	public List<NttdataStudent> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<NttdataStudent> studentList) {
		this.studentList = studentList;
	}

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "IdManager", referencedColumnName = "IdManager", nullable = false)
	public NttdataDualManager getManager() {
		return manager;
	}

	public void setManager(NttdataDualManager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "NttdataCenter [IdCenter=" + IdCenter + ", CifCenter=" + CifCenter + ", nameCenter=" + nameCenter
				+ ", directionCenter=" + directionCenter + ", manager=" + manager + "]";
	}

}
