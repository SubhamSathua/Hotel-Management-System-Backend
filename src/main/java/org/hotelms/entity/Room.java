package org.hotelms.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int room_id;


    @Column(nullable = false, unique = true, length = 10)
    private String room_number;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType room_type;


//    floor
    @Column(nullable = false)
    private int floor;  // Which floor (1, 2, 3...)

    @Column(nullable = false)
    private double price_per_night;

    @Column(nullable = false)
    private int capacity;

    // Room status
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomStatus status;


    private boolean has_ac;
    private boolean has_wifi;
    private boolean has_tv;
    private boolean has_mini_bar;


    @Column(length = 50)
    private String view_type;

    @Column(length = 500)
    private String description;

    @Column(length = 255)
    private String image_url;


    private LocalDateTime created_at;
    private LocalDateTime updated_at;




    public Room() {}


    public Room(String room_number, RoomType room_type, int floor,
                double price_per_night, int capacity, RoomStatus status) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.floor = floor;
        this.price_per_night = price_per_night;
        this.capacity = capacity;
        this.status = status;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }


    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public RoomType getRoom_type() {
        return room_type;
    }

    public void setRoom_type(RoomType room_type) {
        this.room_type = room_type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(double price_per_night) {
        this.price_per_night = price_per_night;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public boolean isHas_ac() {
        return has_ac;
    }

    public void setHas_ac(boolean has_ac) {
        this.has_ac = has_ac;
    }

    public boolean isHas_wifi() {
        return has_wifi;
    }

    public void setHas_wifi(boolean has_wifi) {
        this.has_wifi = has_wifi;
    }

    public boolean isHas_tv() {
        return has_tv;
    }

    public void setHas_tv(boolean has_tv) {
        this.has_tv = has_tv;
    }

    public boolean isHas_mini_bar() {
        return has_mini_bar;
    }

    public void setHas_mini_bar(boolean has_mini_bar) {
        this.has_mini_bar = has_mini_bar;
    }

    public String getView_type() {
        return view_type;
    }

    public void setView_type(String view_type) {
        this.view_type = view_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
