package com.capgemini.springmvc.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="employee_info")
public class EmplooyeeInfoBean implements Serializable {
	@Id
	@Column
	private int empId;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String designation;
	@Column
	private String password;
	@Column
	private double salary;
	
}
