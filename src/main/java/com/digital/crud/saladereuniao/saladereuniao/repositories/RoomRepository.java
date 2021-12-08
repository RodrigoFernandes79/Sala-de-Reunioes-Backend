package com.digital.crud.saladereuniao.saladereuniao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.crud.saladereuniao.saladereuniao.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
