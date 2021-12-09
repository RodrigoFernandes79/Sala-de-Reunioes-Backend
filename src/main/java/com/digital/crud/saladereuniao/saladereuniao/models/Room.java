package com.digital.crud.saladereuniao.saladereuniao.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@Column(nullable=false)
	@JsonFormat(pattern ="dd/MM/yyyy")
	@NotNull(message="Campo Data não informado")
	private LocalDate date;
	
	
	@NotBlank(message="Campo Horário Inicial não informado")
	@Column(nullable=false,length=30)
	private String startHour;
	
	@NotBlank(message="Campo Horário Final não informado")
	@Column(nullable=false,length=30)
	private String endHour;
	
	
	
	
	

}
