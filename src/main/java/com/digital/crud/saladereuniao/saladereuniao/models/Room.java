package com.digital.crud.saladereuniao.saladereuniao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="meeting_room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Campo nome não informado")
	@Column(nullable=false,length=150)
	private String name;
	
	@Column(nullable=false,length=30)
	private String startHour;
	
	@Column(nullable=false,length=30)
	private String endHour;
	
	
	
	
	

}
