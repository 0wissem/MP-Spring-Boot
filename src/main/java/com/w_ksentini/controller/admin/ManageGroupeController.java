package com.w_ksentini.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.w_ksentini.model.Formateur;
import com.w_ksentini.model.Groupe;
import com.w_ksentini.model.Matiere;
import com.w_ksentini.model.Student;
import com.w_ksentini.repository.FormateurRepository;
import com.w_ksentini.repository.GroupeRepository;
import com.w_ksentini.repository.MatiereRepository;
import com.w_ksentini.repository.StudentRepository;

@Controller
@RequestMapping(value = "/admin") // nom logique dans l'URL pour accéder au contrôleur
public class ManageGroupeController {
	@Autowired // pour l'injection de dépendances
	private FormateurRepository formateurRepository;
	@Autowired // pour l'injection de dépendances
	private GroupeRepository groupeRepository;
	@Autowired // pour l'injection de dépendances
	private StudentRepository studentRepository;
	@Autowired // pour l'injection de dépendances
	private MatiereRepository matiereRepository;

	@RequestMapping(value = "/groupes") // nom logique pour accéder à l'action "groupes" ou méthode "index
	public String index(Model model) {
		List<Groupe> lg = groupeRepository.findAll();// récupérer la liste des etudiants à partir de la couche
														// "service"
		model.addAttribute("groupes", lg); // placer la liste des etudiants dans le "Model" comme un attribut"
		return "/groupes/index"; // retourner le nom de la vue WEB à afficher
	}

	@RequestMapping(value = "/groupes/delete", method = RequestMethod.GET)
	public String delete(Long id) {
		groupeRepository.deleteById(id);
		return "redirect:/admin/groupes";
	}

//	@RequestMapping(value = "/groupes/edit", method = RequestMethod.GET)
//	public String edit(Model model, Long id) {
//		System.out.print("edit id:" + id);
//		Groupe gr = groupeRepository.getById(id);
//		// pass data?
//		return "groupes/edit_groupe";
//
//	}

//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String update(Model model,  Groupe groupe) {
//		if (false)
//			// en cas d'erreurs de validation
//			return "edit";
//		// get data for updates --------------------------------------
//		//groupeRepository.save(groupe);
//		// Afficher une page pour confirmer l'enregistrement
//		return "redirect:groupes";
//	}

	@RequestMapping(value = "/groupes/add", method = RequestMethod.GET)
	public String add(Model model, Groupe groupe) {
		Groupe g = new Groupe();
		model.addAttribute("groupe", g);
		// call students that have no groups// we can set the groupe if we want to show
		// them all
		List<Student> ls = studentRepository.findByGroupeIsNull();
		List<Matiere> lm = matiereRepository.findAll();
		model.addAttribute("students", ls);
		model.addAttribute("matieres", lm);
		return "groupes/add_groupe";
	}

	@RequestMapping(value = "/groupes/add", method = RequestMethod.POST)
	public String add_persist_groupe(Model model, Groupe groupe) {
		if (groupe.getNom() == null) {
			// send the error / add requirement..
			return "groupes/add_groupe";
		}
		//groupeRepository.save(groupe); // save groupe with student list
		groupeRepository.saveAndFlush(groupe);
		for (int counter = 0; counter < groupe.getList_students().size(); counter++) { // assign groupe to the new
																						// groupe
			Student student = (Student) groupe.getList_students().toArray()[counter];
			student.setGroupe(groupe);
			studentRepository.save(student);
		}

//		for (int counter = 0; counter < groupe.getList_matieres().size(); counter++) {
//			System.out.println("counter:"+counter);
//
//		Matiere matiere =  (Matiere) groupe.getList_matieres().toArray()[counter];
//		   java.util.Collection<Groupe> list = matiere.getList_groupes();
//		   list.add(groupe);
//		 // newListGroupes.
//		//matiere.setList_groupes(matiere.getList_groupes());
//			System.out.println("m1 gro"+list);
//			
//			
//		//	matiereRepository.save(matiere);
//		}

		return "redirect:/admin/groupes";

	}
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String add_Post_Request(Model model,  Student student) {
//		if (false)
//			// en cas d'erreurs de validation
//			return "edit";
//		//Student st = new Student("","");
//		//System.out.println(student.getGroupe());
//		// Afficher une page pour confirmer l'enregistrement
//		studentRepository.save(student);
//		return "redirect:students";
//	}

}