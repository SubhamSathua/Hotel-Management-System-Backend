package org.hotelms.controller;


import org.hotelms.entity.Booking;
import org.hotelms.service.BookingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
    private final BookingService service;
    public BookingController(BookingService service) { this.service = service; }

    @GetMapping
    public List<Booking> getAll() { return service.getAll(); }

    @PostMapping
    public Booking add(@RequestBody Booking b) { return service.save(b); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
