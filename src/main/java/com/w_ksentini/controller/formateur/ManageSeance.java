package com.w_ksentini.controller.formateur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.w_ksentini.repository.FormateurRepository;
import com.w_ksentini.repository.GroupeRepository;
import com.w_ksentini.repository.MatiereRepository;
import com.w_ksentini.repository.SeanceRepository;
import com.w_ksentini.repository.StudentRepository;

@Controller
@RequestMapping(value = "/formateur") // nom logique dans l'URL pour accéder au contrôleur
public class ManageSeance {
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

	@RequestMapping(value = "/seances")
	public String index(Model model, FilterForm filterForm) {
		System.out.println("-----------" + filterForm);
		List<Seance> ls;
		if (filterForm.getGroupe() != null && filterForm.getMatiere() != null) {
			ls = seanceRepository.findByMatiereLikeAndGroupeLike(filterForm.getMatiere(), filterForm.getGroupe());
		} else if (filterForm.getGroupe() != null) {
			ls = seanceRepository.findByGroupeLike(filterForm.getGroupe());
		} else if (filterForm.getMatiere() != null) {
			ls = seanceRepository.findByMatiereLike(filterForm.getMatiere());
		} else {
			ls = seanceRepository.findAll();
		}

		List<Groupe> lg = groupeRepository.findAll();
		List<Matiere> lm = matiereRepository.findAll();
		model.addAttribute("seances", ls);
		model.addAttribute("groupes", lg);
		model.addAttribute("matieres", lm);
		model.addAttribute("ff", filterForm);
		return "seances/index"; // retourner le nom de la vue WEB à afficher
	}

	@RequestMapping(value = "/seances/add", method = RequestMethod.GET)
	public String add_seance(Model model) {
		Seance s = new Seance();
		List<Groupe> lg = groupeRepository.findAll();
		List<Matiere> lm = matiereRepository.findAll();
		List<Formateur> lf = formateurRepository.findAll();
		List<Student> lst = studentRepository.findAll();

		System.out.print(model.toString());
		model.addAttribute("groupes", lg);
		model.addAttribute("matieres", lm);
		model.addAttribute("formateurs", lf);
		model.addAttribute("seance", s);
		model.addAttribute("students", lst);
		return "seances/new_seance";
	}

	@RequestMapping(value = "/seances/add", method = RequestMethod.POST)
	public String add_Post_Request(Model model, @Valid Seance seance, BindingResult bindingResult,
			@RequestParam(value = "cers", required = false) long[] list) {

		if (bindingResult.hasErrors())
			// en cas d'erreurs de validation
			return "seances/new_seance";
		List<Student> lst = new ArrayList<Student>();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				lst.add(studentRepository.getById(list[i]));
				System.out.println(i + " " + studentRepository.getById(list[i]));
			}

		}
		seance.setList_students(lst);
		seance.setId((long) 555);
		System.out.print(seance);
		seanceRepository.save(seance);
		return "redirect:/formateur/seances";
	}

	@RequestMapping(value = "/seances/details", method = RequestMethod.GET)
	public String details(Model model, Long id) {
		model.addAttribute("seance", seanceRepository.getById(id));
		return "seances/seance_details";
	}

	@RequestMapping(value = "/seances/delete", method = RequestMethod.GET)
	public String delete(Model model, Long id) {
		// seanceRepository.getById(id);
		seanceRepository.deleteById(id);
		return "redirect:/formateur/seances";
	}

}