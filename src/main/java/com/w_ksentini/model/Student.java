package com.w_ksentini.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;
@Entity
public class Student extends User{
	
	
	
	@ManyToMany(mappedBy= "list_students")
	private Collection<Seance> list_seances= new ArrayList<Seance>();

	@ManyToOne
	private Groupe groupe;
	
	public Collection<Seance> getList_seances() {
		return list_seances;
	}

	public void setList_seances(Collection<Seance> list_seances) {
		this.list_seances = list_seances;
	}

	public Collection<Student_Matiere> getList_Student_Matiere() {
		return list_Student_Matiere;
	}

	public void setList_Student_Matiere(Collection<Student_Matiere> list_Student_Matiere) {
		this.list_Student_Matiere = list_Student_Matiere;
	}

	@OneToMany(mappedBy="student")
	private Collection<Student_Matiere> list_Student_Matiere = new ArrayList<Student_Matiere>();
	 
	public Student(String nom, String prenom) {
		super(nom, prenom);
	}

//	public Collection<Seance> getList_seances() {
//		return list_seances;
//	}
//
//	public void setList_seances(Collection<Seance> list_seances) {
//		this.list_seances = list_seances;
//	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return getNom() + " " + getPrenom();
	}

}
