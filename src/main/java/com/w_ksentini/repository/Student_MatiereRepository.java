package com.w_ksentini.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w_ksentini.model.Groupe;
import com.w_ksentini.model.Matiere;
import com.w_ksentini.model.Seance;
import com.w_ksentini.model.Student_Matiere;

public interface Student_MatiereRepository extends JpaRepository<Student_Matiere, Long>{
	List<Student_Matiere> findByMatiereLike(Matiere m);
	
}

