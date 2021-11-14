package com.w_ksentini.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w_ksentini.model.Groupe;
import com.w_ksentini.model.Matiere;
import com.w_ksentini.model.Student;
import com.w_ksentini.model.Student_Matiere;

public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByGroupeLike(Groupe g);
	List<Student> findByGroupeIsNull();
}

