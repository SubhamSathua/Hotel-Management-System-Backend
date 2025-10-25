package org.hotelms.repository;

import java.util.List;
import java.util.Optional;
import org.hotelms.entity.Room;
import org.hotelms.entity.RoomStatus;
import org.hotelms.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Integer> {


    Optional<Room> findByRoomNumber(String roomNumber);


    List<Room> findByStatus(RoomStatus status);


    List<Room> findByRoomType(RoomType roomType);


    List<Room> findByStatusAndRoomType(RoomStatus status, RoomType roomType);


    List<Room> findByFloor(int floor);


    @Query("SELECT r FROM Room r WHERE r.price_per_night BETWEEN :minPrice AND :maxPrice AND r.status = :status")
    List<Room> findRoomsByPriceRange(
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice,
            @Param("status") RoomStatus status
    );


    List<Room> findByCapacityAndStatus(int capacity, RoomStatus status);
}
