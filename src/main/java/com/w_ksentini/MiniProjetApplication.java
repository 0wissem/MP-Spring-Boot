package com.w_ksentini;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.w_ksentini.model.Formateur;
import com.w_ksentini.model.Groupe;
import com.w_ksentini.model.Matiere;
import com.w_ksentini.model.Seance;
import com.w_ksentini.model.Student;
import com.w_ksentini.repository.FormateurRepository;
import com.w_ksentini.repository.GroupeRepository;
import com.w_ksentini.repository.MatiereRepository;
import com.w_ksentini.repository.SeanceRepository;
import com.w_ksentini.repository.StudentRepository;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MiniProjetApplication {
	static FormateurRepository formateurRepo;
	static StudentRepository studentRepo;
	static GroupeRepository groupeRepo;
	static MatiereRepository matiereRepo;
	static SeanceRepository seanceRepo;
	public static void main(String[] args) {
		ApplicationContext contexte = SpringApplication.run(MiniProjetApplication.class, args);
		formateurRepo = contexte.getBean(FormateurRepository.class);
		studentRepo = contexte.getBean(StudentRepository.class);
		groupeRepo = contexte.getBean(GroupeRepository.class);
		matiereRepo= contexte.getBean(MatiereRepository.class);
		seanceRepo = contexte.getBean(SeanceRepository.class);
		
		Formateur f1 = new Formateur("wissem", "ksentini");
		//formateurRepo.save(f1);
	
		Groupe g1 = new Groupe("G-1");
		Groupe g2 = new Groupe("G-2");
		//groupeRepo.save(g1);
		//groupeRepo.save(g2);
		Student st1 = new Student("mahdi","bou mendil");
		st1.setGroupe(g2);
		Student st2 = new Student("majdi","maatoug");
		st2.setGroupe(g2);
		Student st3 = new Student("hedi","bouchaala");
		st3.setGroupe(g1);
		//studentRepo.save(st1);
		//studentRepo.save(st2);
		//studentRepo.save(st3);
		Matiere m1 = new Matiere(20l,"python");
		Matiere m2 = new Matiere (20l,"java");
		//matiereRepo.save(m1);
		//matiereRepo.save(m2);
		Seance s1 = new Seance();
		s1.setFormateur(f1);
		s1.setDuree((long) 1.5);
		s1.setGroupe(g2);
		s1.setDate(new Date(112,02,14));
		s1.setMatiere(m2);
		List <Student> ls = new ArrayList();
		ls.add(st1);
		ls.add(st2);
		s1.setList_students(ls);
		//seanceRepo.save(s1);
		//afficherLesFormateurs();
		//afficherLesEtudents();
	}

	private static void afficherLesEtudents() {
		// TODO Auto-generated method stub
		
		System.out.println("Afficher tous les produits...");
		List<Student> ls = studentRepo.findAll();
		for (Student s : ls)
		{
		System.out.println(s);
		}
	}

	private static void afficherLesFormateurs() {
		// TODO Auto-generated method stub
		System.out.println("***************************************");
		// Lister l'ensemble des produits
		System.out.println("Afficher tous les produits...");
		List<Formateur> lp = formateurRepo.findAll();
		for (Formateur p : lp)
		{
		System.out.println(p);
		}
		System.out.println("***************************************");
	}

}
