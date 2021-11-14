package com.w_ksentini.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Student_Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	private Long DC;
	private Long DS;

	public Long getDC() {
		return DC;
	}
	@ManyToOne
	private Student student;

	@ManyToOne
	private Matiere matiere;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	
	public void setDC(Long dC) {
		DC = dC;
	}

	public Long getDS() {
		return DS;
	}

	public void setDS(Long dS) {
		DS = dS;
	}
	
	public Student_Matiere() {
		
	}
	
	

}
