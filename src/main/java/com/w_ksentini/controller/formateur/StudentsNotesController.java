package com.w_ksentini.controller.formateur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.w_ksentini.model.FilterForm;
import com.w_ksentini.model.Formateur;
import com.w_ksentini.model.Groupe;
import com.w_ksentini.model.Matiere;
import com.w_ksentini.model.Seance;
import com.w_ksentini.model.Student;
import com.w_ksentini.model.Student_Matiere;
import com.w_ksentini.repository.FormateurRepository;
import com.w_ksentini.repository.GroupeRepository;
import com.w_ksentini.repository.MatiereRepository;
import com.w_ksentini.repository.SeanceRepository;
import com.w_ksentini.repository.StudentRepository;
import com.w_ksentini.repository.Student_MatiereRepository;

@Controller
@RequestMapping(value = "/formateur") // nom logique dans l'URL pour accéder au contrôleur
public class StudentsNotesController {
	@Autowired // pour l'injection de dépendances
	private FormateurRepository formateurRepository;
	@Autowired // pour l'injection de dépendances
	private GroupeRepository groupeRepository;
	@Autowired // pour l'injection de dépendances
	private StudentRepository studentRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private Student_MatiereRepository student_MatiereRepository;
	
	@RequestMapping(value = "/notes")
	public String index(Model model, Student_Matiere student_matiere, Long id) {
		List<Student_Matiere> lsm = new ArrayList();
		Student student = studentRepository.getById(id);
		List<Matiere> matieres = new ArrayList();
		Groupe groupe = student.getGroupe();
		
		System.out.print("list des matieres du groupe"+groupe.getList_matieres().toString());
		

		model.addAttribute("student", student);
		
		return "/students/notes"; // retourner le nom de la vue WEB à afficher
	}

}