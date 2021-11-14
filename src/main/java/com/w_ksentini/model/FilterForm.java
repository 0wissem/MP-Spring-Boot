package com.w_ksentini.model;

public class FilterForm {
	public FilterForm() {}
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
	@Override
	public String toString() {
		return "FilterForm [groupe=" + groupe + ", matiere=" + matiere + "]";
	}
	private Groupe groupe;
	private Matiere matiere;
}
