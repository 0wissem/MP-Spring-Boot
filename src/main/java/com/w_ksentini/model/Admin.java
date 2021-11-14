package com.w_ksentini.model;

import javax.persistence.Entity;
@Entity
public class Admin extends User {
	public Admin(String nom, String prenom) {
		super(nom, prenom);
	}

	public Admin() {

	}

	@Override
	public String toString() {
		return getNom() + " " + getPrenom();
	}
}
