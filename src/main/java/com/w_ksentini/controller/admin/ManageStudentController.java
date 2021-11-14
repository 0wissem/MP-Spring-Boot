package com.w_ksentini.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.w_ksentini.model.Formateur;
import com.w_ksentini.model.Groupe;
import com.w_ksentini.model.Student;
import com.w_ksentini.repository.FormateurRepository;
import com.w_ksentini.repository.GroupeRepository;
import com.w_ksentini.repository.StudentRepository;

@Controller
@RequestMapping(value = "/admin") // nom logique dans l'URL pour accéder au contrôleur
public class ManageStudentController {
	@Autowired // pour l'injection de dépendances
	private FormateurRepository formateurRepository;
	@Autowired // pour l'injection de dépendances
	private GroupeRepository groupeRepository;
	@Autowired // pour l'injection de dépendances
	private StudentRepository studentRepository;

	@RequestMapping(value = "/students") // nom logique pour accéder à l'action "students" ou méthode "index
	public String index(Model model) {
		List<Student> ls = studentRepository.findAll();// récupérer la liste des etudiants à partir de la couche
														// "service"
		model.addAttribute("students", ls); // placer la liste des etudiants dans le "Model" comme un attribut"
		return "students/index"; // retourner le nom de la vue WEB à afficher
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Long id) {
		studentRepository.deleteById(id);
		return "redirect:students";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, Long id) {
		System.out.print("edit id:" + id);
		Student st = studentRepository.getById(id);
		List<Groupe> lg = groupeRepository.findAll();
		model.addAttribute("groupes", lg);
		model.addAttribute("student", st);
		return "students/edit_student";
		// studentRepository.deleteById(id);
		// return "redirect:students";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model,  Student student) {
		if (false)
			// en cas d'erreurs de validation
			return "edit";
		studentRepository.save(student);
		// Afficher une page pour confirmer l'enregistrement
		return "redirect:students";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model,  Student student) {
		if (false)
			// en cas d'erreurs de validation
			return "edit";
		Student st = new Student("","");
		List<Groupe> lg = groupeRepository.findAll();
		model.addAttribute("groupes", lg);
		model.addAttribute("student", st);
		// Afficher une page pour confirmer l'enregistrement
		return "students/add_student";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add_Post_Request(Model model,  Student student) {
		if (false)
			// en cas d'erreurs de validation
			return "edit";
		//Student st = new Student("","");
		//System.out.println(student.getGroupe());
		// Afficher une page pour confirmer l'enregistrement
		studentRepository.save(student);
		return "redirect:students";
	}

}