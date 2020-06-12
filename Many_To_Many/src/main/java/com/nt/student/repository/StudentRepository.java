package com.nt.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.many.Student;

/**
*Firoj Khan
*
*@Since
*/

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	void deleteById(Long id);
}
