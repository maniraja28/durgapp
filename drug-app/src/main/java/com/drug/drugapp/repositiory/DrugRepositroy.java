package com.drug.drugapp.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.drug.drugapp.entity.Drug;

@Repository
public interface DrugRepositroy extends JpaRepository<Drug, Long>{
	

}
