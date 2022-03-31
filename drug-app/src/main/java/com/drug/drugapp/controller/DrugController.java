package com.drug.drugapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.drug.drugapp.dto.DrugDTO;
import com.drug.drugapp.entity.Drug;
import com.drug.drugapp.service.DrugService;

import lombok.extern.log4j.Log4j2;

@RestController // with the help of this annotation we will call the restful apis like
				// post,put,get,delete
@Log4j2 // this annotation is used for the purpose of checking the debuging points we
		// can add the depencys in pom.xml file
public class DrugController {// in controller Delegations only possible that means we will call restful api
								// only

	@Autowired
	DrugService service;// dependency injection is a technique in which an object receive other object
						// that is depends on called dependencies typically the received object is
						// called as a client and the passed injected object is called has a service.

	@GetMapping("/drugs") // get mapping is used for the purpose of get the data
	public List<DrugDTO> getAllDrugs() {
		// logs
		log.info("INFO:DrugController::: in getAllDrugs() ......");

//        log.warn("warn:DrugController::: in getAllDrugs() ......");
//        log.error("error:DrugController::: in getAllDrugs() ......");
		List<DrugDTO> drugDTOList = service.getAllDrugs();
		return drugDTOList;
	}

	@PostMapping("/drugs") // it is used for the purpose of add the data
	public void addDrug(@RequestBody DrugDTO drugdto) {
		log.info(" DrugController::: in addDrug() ......" + drugdto);
		service.addDrug(drugdto);

	}

	@PutMapping("/drugs") // it is used for the purpose of the update the data
	public void updateDrug(@RequestBody Drug drug)// method creation
	{
		service.updateDrug(drug);
	}

	@DeleteMapping("/drugs/{id}") // delete the data or remove the data
	public void deleteDrugById(@PathVariable Long id) {
		service.deleteDrug(id);
	}

	// LIST of drugs <--- GET BY Three char /drugs/par - Done
//	@GetMapping("/drugs/{threeChar}")
//	public List<Drug> getDrugsByThreeChar(@PathVariable String threeChar) {
//		
//		List<Drug> filterDrugs = service.getDrugsByThreeChar(threeChar);
//		return filterDrugs;
//	}

	@GetMapping("/drugs/{id}")
	public DrugDTO getAllDrugsById(@PathVariable Long id) {
		DrugDTO drugDTO = service.getDrugById(id);

		return drugDTO;

	}
	// Drug <---- GET BY ID /drugs/343

}
