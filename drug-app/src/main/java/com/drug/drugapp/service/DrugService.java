package com.drug.drugapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.drugapp.dto.DrugDTO;
import com.drug.drugapp.entity.Drug;
import com.drug.drugapp.repositiory.DrugRepositroy;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class DrugService {// in service mainly we have to concentrating only business logic only.

	@Autowired
	DrugRepositroy repository;

	public List<DrugDTO> getAllDrugs() {// in this line entity is converted to the dto
		
		log.info("DrugService::getAllDrugs()");//its nothing but debugging point 

		List<Drug> druglist = repository.findAll(); // list of entity

		// list of entity to list of DTO (Conversion logic) - Adapater design patterns

		// Java 7 is nothing but impertive stayle 
//		List<DrugDTO> drugDTOList = new ArrayList<>();//
//		
//		for (Drug drug : druglist) {//enhanced forloop
//			
//			DrugDTO drugDTO = new DrugDTO();//object creation
//			drugDTO.setDosage(drug.getDosage());
//			drugDTO.setName(drug.getName());
//			drugDTO.setPrice(drug.getPrice());
//			
//			drugDTOList.add(drugDTO);
//		}

		// Java 8 Stream api - Declarative api stands for application programing interface

		List<DrugDTO> drugDTOList = druglist.stream().map(drug -> {
			DrugDTO drugDTO = new DrugDTO();
			drugDTO.setDosage(drug.getDosage());
			drugDTO.setName(drug.getName());
			drugDTO.setPrice(drug.getPrice());
			return drugDTO;
		}).collect(Collectors.toList());

		return drugDTOList;

	}

	public void addDrug(DrugDTO drugdto) {// add method is used for the purpose of the add the data

		//
		
		//DTO to Entity 
		
		Drug drug = new Drug();
		drug.setDosage(drugdto.getDosage());
		drug.setName(drugdto.getName());
		drug.setPrice(drugdto.getPrice());
		drug.setId((long)(Math.random()*1000));
		
		repository.save(drug);

	}

	public void updateDrug(Drug drug) {// update method is used for the purpose of the update the data
		DrugDTO drugdto = new DrugDTO();
		drugdto.setDosage(drug.getDosage());
		drugdto.setName(drug.getName());
		drugdto.setPrice(drug.getPrice());
		
		repository.save(drug);
	}

	public void deleteDrug(Long id) {// delete method is used for the purpose of the delete the data
		repository.deleteById(id);
	}

	public List<Drug> getDrugsByThreeChar(String threeChar) {
		List<Drug> allDrugsList = repository.findAll();

		List<Drug> filterDrugs = allDrugsList.stream().filter(d -> d.getName().startsWith(threeChar))
				.collect(Collectors.toList());
		return filterDrugs;
	}

	public DrugDTO getDrugById(Long id) {
		Drug drug = repository.findById(id).get(); // DrugEntity

		// Convert entity to dto
		DrugDTO drugDTO = new DrugDTO();

		drugDTO.setDosage(drug.getDosage());
		drugDTO.setName(drug.getName());
		drugDTO.setPrice(drug.getPrice());

		return drugDTO;
	}
}
