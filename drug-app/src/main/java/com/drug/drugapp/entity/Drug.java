package com.drug.drugapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // particular annotation is used for directly mapping to the database table
@Data//particalar annotation is used for getters and tostring and hashcode and equals method and conostructor also 
@NoArgsConstructor//particular annotation is used for no args conostructor
@AllArgsConstructor//particular annotation is used for args conostructor
public class Drug {

	@Id // unique that means different
	private long id;// state or field
	private String name;// state or field
	private double price;// state or field
	private String dosage;// state or field

}//i can remove the setters and getters and tostring method and defaultconostructor and parameterised conostructor in entity class we can override this problem with the help of lombok depencys we can add the particular annotation that annotation will take care
