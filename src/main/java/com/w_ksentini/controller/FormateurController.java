package com.w_ksentini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.w_ksentini.model.Formateur;
import com.w_ksentini.model.Groupe;
import com.w_ksentini.model.Student;
import com.w_ksentini.repository.FormateurRepository;
import com.w_ksentini.repository.GroupeRepository;
import com.w_ksentini.repository.StudentRepository;

@Controller
@RequestMapping(value = "/formateur") // nom logique dans l'URL pour accéder au contrôleur
public class FormateurController {
	
	@Autowired // pour l'injection de dépendances
	private StudentRepository studentRepository;
	@Autowired // pour l'injection de dépendances
	private FormateurRepository formateurRepository;
	@Autowired // pour l'injection de dépendances
	private GroupeRepository groupeRepository;
	

	@RequestMapping(value = "/index") // nom logique pour accéder à l'action "index" ou méthode "index
	public String index(Model model) {
		List <Formateur> lp = formateurRepository.findAll();
		//récupérer la liste des produits à partir de la couche "service"
		model.addAttribute("formateurs", lp); // placer la liste des produits dans le "Model" comme un attribut"
		return "formateurs"; // retourner le nom de la vue WEB à afficher
	}

}
