package com.drug.drugapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugDTO {
	
//fields is there
	private String name;
	private double price;
	private String dosage;

//generate setters and getters method
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public String getDosage() {
//		return dosage;
//	}
//
//	public void setDosage(String dosage) {
//		this.dosage = dosage;
//	}

}
