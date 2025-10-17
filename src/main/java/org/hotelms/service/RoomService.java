package org.hotelms.service;


import org.hotelms.entity.Room;
import org.hotelms.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository repo;
    public RoomService(RoomRepository repo) { this.repo = repo; }

    public List<Room> getAll() { return repo.findAll(); }
    public Room save(Room r) { return repo.save(r); }
    public void delete(Long id) { repo.deleteById(id); }
}
