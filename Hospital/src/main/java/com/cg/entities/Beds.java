package com.cg.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Beds implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer patient_id;
	@NotEmpty(message = "Please enter bed name or number")
	@Size(max = 20, min = 2, message = "name should be of 2-20 character")
	private String name;
	private String room;

	@Enumerated(EnumType.STRING)
	private States state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Beds [id=" + id + ", patient_id=" + patient_id + ", name=" + name + ", room=" + room + ", state="
				+ state + "]";
	}

	public Beds(Integer id, Integer patient_id,
			@NotEmpty(message = "Please enter bed name or number") @Size(max = 20, min = 2, message = "name should be of 2-20 character") String name,
			String room, States state) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.name = name;
		this.room = room;
		this.state = state;
	}

	

}
