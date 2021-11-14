package com.w_ksentini.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity

public class Formateur extends User {
	
//	@OneToMany (mappedBy = "formateur")
//	private Collection <Seance> list_seances = new ArrayList<Seance>();
	
	@OneToMany (mappedBy = "formateur")
	private Collection <Matiere> list_matieres = new ArrayList<Matiere>();
	
	@OneToMany
	private Collection<Groupe> groupes= new ArrayList<Groupe>();
	
	public Formateur(String nom, String prenom) {
		super(nom, prenom);
	}

	public Formateur() {

	}

	@Override
	public String toString() {
		return getNom() + " " + getPrenom();
	}

//	public Collection<Seance> getList_seances() {
//		return list_seances;
//	}
//
//	public void setList_seances(Collection<Seance> list_seances) {
//		this.list_seances = list_seances;
//	}

}
