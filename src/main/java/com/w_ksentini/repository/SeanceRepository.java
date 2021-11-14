package com.w_ksentini.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w_ksentini.model.Groupe;
import com.w_ksentini.model.Matiere;
import com.w_ksentini.model.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Long>{
	
	List<Seance> findByMatiereLike(Matiere m);
	List<Seance> findByGroupeLike(Groupe g);
	List<Seance> findByMatiereLikeAndGroupeLike(Matiere m, Groupe g);

}

