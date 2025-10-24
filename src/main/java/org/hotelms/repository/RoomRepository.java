package org.hotelms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.hotelms.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> { }
