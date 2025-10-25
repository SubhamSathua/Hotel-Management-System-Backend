package org.hotelms.controller;

import java.util.*;
import org.hotelms.entity.Room;
import org.hotelms.entity.RoomStatus;
import org.hotelms.entity.RoomType;
import org.hotelms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping
    public Map<String, String> addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }


    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }


    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getRoomById(@PathVariable int id) {
        return roomService.getRoomById(id);
    }


    @GetMapping("/type/{roomType}")
    public List<Room> getRoomsByType(@PathVariable RoomType roomType) {
        return roomService.getRoomsByType(roomType);
    }

    @GetMapping("/available/type/{roomType}")
    public List<Room> getAvailableRoomsByType(@PathVariable RoomType roomType) {
        return roomService.getAvailableRoomsByType(roomType);
    }

    @GetMapping("/filter")
    public List<Room> filterRoomsByPrice(
            @RequestParam double minPrice,
            @RequestParam double maxPrice
    ) {
        return roomService.filterRoomsByPrice(minPrice, maxPrice);
    }

    @PutMapping("/{id}")
    public Map<String, String> updateRoom(
            @PathVariable int id,
            @RequestBody Room room
    ) {
        return roomService.updateRoom(id, room);
    }

    @PatchMapping("/{id}/status")
    public Map<String, String> updateRoomStatus(
            @PathVariable int id,
            @RequestBody Map<String, String> body
    ) {
        RoomStatus newStatus = RoomStatus.valueOf(body.get("status"));
        return roomService.updateRoomStatus(id, newStatus);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteRoom(@PathVariable int id) {
        return roomService.deleteRoom(id);
    }
}
