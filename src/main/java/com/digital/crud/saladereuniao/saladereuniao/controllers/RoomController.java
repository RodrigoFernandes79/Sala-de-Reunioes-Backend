package com.digital.crud.saladereuniao.saladereuniao.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digital.crud.saladereuniao.saladereuniao.models.Room;
import com.digital.crud.saladereuniao.saladereuniao.services.RoomService;

@RestController
@RequestMapping("/rooms")
@CrossOrigin("http://localhost:4200")
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	@PostMapping
	public ResponseEntity<Room> inserirReuniao(@Valid @RequestBody Room room){
		Room obj = service.inserirReuniao(room);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		
	}
	@GetMapping
	public ResponseEntity<List<Room>> listarCliente(){
		List<Room> obj = service.listarCliente();
		return ResponseEntity.ok().body(obj);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Room> listarPorId(@PathVariable Long id){
		Room obj = service.listarPorId(id);
		return ResponseEntity.ok().body(obj) ;
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Room> atualizarCliente(@Valid @RequestBody Room room, @PathVariable Long id){
		Room obj = service.atualizarCliente(room,id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(obj) ;
		
	}
}
