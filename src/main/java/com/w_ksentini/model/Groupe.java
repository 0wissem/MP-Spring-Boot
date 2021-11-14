package com.w_ksentini.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Groupe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public String nom;
	
	// can not update student from foreign key 
	@OneToMany(mappedBy="groupe",cascade=CascadeType.ALL)
	private Collection<Student> list_students = new ArrayList<Student>();

	@ManyToMany(mappedBy="list_groupes")
	private Collection<Matiere> list_matieres= new ArrayList<Matiere>();

//	@ManyToOne
//	private Formateur formateur;

//	@OneToMany(mappedBy="groupe")
//	private Collection<Seance> list_seances= new ArrayList<Seance>();



	public Collection<Matiere> getList_matieres() {
		return list_matieres;
	}

	@Override
	public String toString() {
		return "Groupe [id=" + id + ", nom=" + nom + ", list_students=" + list_students + ", list_matieres="
				+ list_matieres + "]";
	}

	public void setList_matieres(Collection<Matiere> list_matieres) {
		this.list_matieres = list_matieres;
	}


	public Groupe() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Student> getList_students() {
		return list_students;
	}

	public void setList_students(Collection<Student> list_students) {
		this.list_students = list_students;
	}

	public Groupe(String nom) {
		this.nom = nom;
	}

}
