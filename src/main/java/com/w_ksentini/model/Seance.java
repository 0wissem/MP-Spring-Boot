package com.w_ksentini.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Seance {
	@Override
	public String toString() {
		return "Seance [id=" + id + ", date=" + date + ", duree=" + duree + ", description=" + description + ", groupe="
				+ groupe + ", formateur=" + formateur + ", matiere=" + matiere + ", list_students=" + list_students
				+ "]";
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private java.util.Date date;
	private Long duree;
	private String description;
	@ManyToOne
	private Groupe groupe;
	
	public Seance () {}
	
	
	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	@ManyToOne
	private Formateur formateur;
	
	@ManyToOne
	private Matiere matiere;
	
	@ManyToMany
	private Collection<Student> list_students= new ArrayList<Student>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public Long getDuree() {
		return duree;
	}

	public void setDuree(Long duree) {
		this.duree = duree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Collection<Student> getList_students() {
		return list_students;
	}

	public void setList_students(Collection<Student> list_students) {
		this.list_students = list_students;
	}

}
