package com.example.demo.entity;



import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_expenses")
public class Expense {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="expense_name")
	@NotBlank(message= "Expense name cannot be null")
	private String name;
	
	
	@NotBlank
	private String description;
	
	
	@Column(name="expense_amount")
	@NotNull
	private Double amount;
	
	
	@NotBlank
	private String category;
	
	
	@NotNull
	private Date date;
	
	
	@Column(name="created_At", nullable=false,updatable=false)
	@CreationTimestamp
	private Timestamp createdAt;
}
