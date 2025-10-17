package org.hotelms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.hotelms.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> { }
