package com.nttdata.nttdata_sevilla_eclipse_dualgestion_ejerciciofinal.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Proyecto Dual Gestion.
 * 
 * Entidad abstracta.
 * 
 * @author Javier Jiménez Montesinos.
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/**
	 * Versión.
	 */
	private static final long serialVersionUID = 1L;

	/** Usuario que actualiza */
	private String updatedUser;

	/** Día actualizado */
	private Date updatedDate;

	@Column(name = "UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	@Column(name = "UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
