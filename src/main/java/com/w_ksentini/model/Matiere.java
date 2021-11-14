package com.w_ksentini.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long nbre_tot_h;
	private String nom;
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getNbre_tot_h() {
		return nbre_tot_h;
	}


	public void setNbre_tot_h(Long nbre_tot_h) {
		this.nbre_tot_h = nbre_tot_h;
	}

//
//	public Formateur getFormateur() {
//		return formateur;
//	}
//
//
//	public void setFormateur(Formateur formateur) {
//		this.formateur = formateur;
//	}


//	public Collection<Seance> getList_seances() {
//		return list_seances;
//	}
//
//
//	public void setList_seances(Collection<Seance> list_seances) {
//		this.list_seances = list_seances;
//	}


//	public Collection<Groupe> getList_groupes() {
//		return list_groupes;
//	}
//
//
//	public void setList_groupes(Collection<Groupe> list_groupes) {
//		this.list_groupes = list_groupes;
//	}


	@ManyToOne
	private Formateur formateur;
	
//	@OneToMany (mappedBy = "matiere")
//	private Collection <Seance> list_seances = new ArrayList<Seance>();
	
	@ManyToMany
	private Collection<Groupe> list_groupes= new ArrayList<Groupe>();
	

	public Formateur getFormateur() {
		return formateur;
	}


	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}


	public Collection<Groupe> getList_groupes() {
		return list_groupes;
	}


	public void setList_groupes(Collection<Groupe> list_groupes) {
		this.list_groupes = list_groupes;
	}
	
	public void add_groupe(Groupe groupe) {
			 this.list_groupes.add(groupe);
		
	}


	public Matiere() {}
	public Matiere(Long nbre_tot_h, String nom) {
		this.nbre_tot_h =nbre_tot_h;
		this.nom=nom;
	}




	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + ", list_groupes=" + list_groupes + "]";
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
