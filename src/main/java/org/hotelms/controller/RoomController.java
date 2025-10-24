package org.hotelms.controller;


import org.hotelms.entity.Room;
import org.hotelms.service.RoomService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    private final RoomService service;
    public RoomController(RoomService service) { this.service = service; }

    @GetMapping
    public List<Room> getAll() { return service.getAll(); }

    @PostMapping
    public Room add(@RequestBody Room r) { return service.save(r); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
