package org.hotelms.service;


import org.hotelms.entity.Booking;
import org.hotelms.repository.BookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repo;
    public BookingService(BookingRepository repo) { this.repo = repo; }

    public List<Booking> getAll() { return repo.findAll(); }
    public Booking save(Booking b) { return repo.save(b); }
    public void delete(Long id) { repo.deleteById(id); }
}
