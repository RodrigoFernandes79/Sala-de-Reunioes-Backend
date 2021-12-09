package com.digital.crud.saladereuniao.saladereuniao.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.digital.crud.saladereuniao.saladereuniao.models.Room;
import com.digital.crud.saladereuniao.saladereuniao.repositories.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository repository;

	public Room inserirReuniao(@Valid Room room) {
		Room obj = repository.save(room);
		return obj;
	}

	public List<Room> listarCliente() {
		List<Room> obj = repository.findAll();
		return obj;
	}

	public Room listarPorId(Long id) {
		Optional<Room> obj = repository.findById(id);
		return obj.orElseThrow(() ->
		new ResponseStatusException(HttpStatus.NOT_FOUND, "Id: "+id+ " não encontrado!" ));
	}

	public void deletar(Long id) {
		repository.findById(id).orElseThrow(()->
		new ResponseStatusException(HttpStatus.NOT_FOUND, "Id: "+id+ " não encontrado!"));
		repository.deleteById(id);
		
	}

	public Room atualizarCliente(@Valid Room room, Long id) {
		
		return repository.findById(id)
				.map(record -> {
					record.setName(room.getName());
					record.setDate(room.getDate());
					record.setStartHour(room.getStartHour());
					record.setEndHour(room.getEndHour());				
					Room obj = repository.save(record);
					
					return obj;
				
				}).orElseThrow(()->
				new ResponseStatusException(HttpStatus.NOT_FOUND, "Id: "+id+ " não encontrado!"));
	}

}
