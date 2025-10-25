package org.hotelms.service;

import java.time.LocalDateTime;
import java.util.*;
import org.hotelms.entity.Room;
import org.hotelms.entity.RoomStatus;
import org.hotelms.entity.RoomType;
import org.hotelms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;



    public Map<String, String> addRoom(Room room) {
        Map<String, String> response = new HashMap<>();


        if (roomRepository.findByRoomNumber(room.getRoom_number()).isPresent()) {
            response.put("status", "error");
            response.put("message", "Room number already exists");
            return response;
        }


        room.setCreated_at(LocalDateTime.now());
        room.setUpdated_at(LocalDateTime.now());


        if (room.getStatus() == null) {
            room.setStatus(RoomStatus.AVAILABLE);
        }

        // save thr roomsz to the DB
        roomRepository.save(room);

        response.put("status", "success");
        response.put("message", "Room added successfully");
        response.put("room_id", String.valueOf(room.getRoom_id()));
        return response;
    }



    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }



    public List<Room> getAvailableRooms() {
        return roomRepository.findByStatus(RoomStatus.AVAILABLE);
    }



    public Map<String, Object> getRoomById(int roomId) {
        Map<String, Object> response = new HashMap<>();

        Optional<Room> roomOpt = roomRepository.findById(roomId);

        if (roomOpt.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Room not found");
            return response;
        }

        response.put("status", "success");
        response.put("room", roomOpt.get());
        return response;
    }



    public List<Room> getRoomsByType(RoomType roomType) {
        return roomRepository.findByRoomType(roomType);
    }



    public List<Room> getAvailableRoomsByType(RoomType roomType) {
        return roomRepository.findByStatusAndRoomType(RoomStatus.AVAILABLE, roomType);
    }



    public List<Room> filterRoomsByPrice(double minPrice, double maxPrice) {
        return roomRepository.findRoomsByPriceRange(minPrice, maxPrice, RoomStatus.AVAILABLE);
    }



    public Map<String, String> updateRoom(int roomId, Room updatedRoom) {
        Map<String, String> response = new HashMap<>();

        Optional<Room> roomOpt = roomRepository.findById(roomId);

        if (roomOpt.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Room not found");
            return response;
        }

        Room existingRoom = roomOpt.get();


        if (updatedRoom.getRoom_number() != null) {
            existingRoom.setRoom_number(updatedRoom.getRoom_number());
        }
        if (updatedRoom.getRoom_type() != null) {
            existingRoom.setRoom_type(updatedRoom.getRoom_type());
        }
        if (updatedRoom.getFloor() > 0) {
            existingRoom.setFloor(updatedRoom.getFloor());
        }
        if (updatedRoom.getPrice_per_night() > 0) {
            existingRoom.setPrice_per_night(updatedRoom.getPrice_per_night());
        }
        if (updatedRoom.getCapacity() > 0) {
            existingRoom.setCapacity(updatedRoom.getCapacity());
        }
        if (updatedRoom.getStatus() != null) {
            existingRoom.setStatus(updatedRoom.getStatus());
        }
        if (updatedRoom.getDescription() != null) {
            existingRoom.setDescription(updatedRoom.getDescription());
        }
        if (updatedRoom.getView_type() != null) {
            existingRoom.setView_type(updatedRoom.getView_type());
        }


        existingRoom.setHas_ac(updatedRoom.isHas_ac());
        existingRoom.setHas_wifi(updatedRoom.isHas_wifi());
        existingRoom.setHas_tv(updatedRoom.isHas_tv());
        existingRoom.setHas_mini_bar(updatedRoom.isHas_mini_bar());


        existingRoom.setUpdated_at(LocalDateTime.now());

        roomRepository.save(existingRoom);

        response.put("status", "success");
        response.put("message", "Room updated successfully");
        return response;
    }



    public Map<String, String> updateRoomStatus(int roomId, RoomStatus newStatus) {
        Map<String, String> response = new HashMap<>();

        Optional<Room> roomOpt = roomRepository.findById(roomId);

        if (roomOpt.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Room not found");
            return response;
        }

        Room room = roomOpt.get();
        room.setStatus(newStatus);
        room.setUpdated_at(LocalDateTime.now());

        roomRepository.save(room);

        response.put("status", "success");
        response.put("message", "Room status updated to " + newStatus);
        return response;
    }



    public Map<String, String> deleteRoom(int roomId) {
        Map<String, String> response = new HashMap<>();

        Optional<Room> roomOpt = roomRepository.findById(roomId);

        if (roomOpt.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Room not found");
            return response;
        }

        roomRepository.deleteById(roomId);

        response.put("status", "success");
        response.put("message", "Room deleted successfully");
        return response;
    }



    public boolean roomExists(int roomId) {
        return roomRepository.findById(roomId).isPresent();
    }
}
