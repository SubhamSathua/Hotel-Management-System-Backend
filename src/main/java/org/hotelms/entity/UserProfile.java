package org.hotelms.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profile_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String full_name;
    private String phone;
    private String address;
    private String gender;
    private LocalDate date_of_birth;
    private String photo_url;
    private String id_proof_type;
    private String id_proof_number;
    private String id_proof_url;
    private LocalDateTime created_at;

    public UserProfile() {}

    public UserProfile(User user, String full_name, String phone, String address) {
        this.user = user;
        this.full_name = full_name;
        this.phone = phone;
        this.address = address;
        this.created_at = LocalDateTime.now();
    }

    public int getProfile_id() { return profile_id; }
    public void setProfile_id(int profile_id) { this.profile_id = profile_id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getFull_name() { return full_name; }
    public void setFull_name(String full_name) { this.full_name = full_name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDate_of_birth() { return date_of_birth; }
    public void setDate_of_birth(LocalDate date_of_birth) { this.date_of_birth = date_of_birth; }

    public String getPhoto_url() { return photo_url; }
    public void setPhoto_url(String photo_url) { this.photo_url = photo_url; }

    public String getId_proof_type() { return id_proof_type; }
    public void setId_proof_type(String id_proof_type) { this.id_proof_type = id_proof_type; }

    public String getId_proof_number() { return id_proof_number; }
    public void setId_proof_number(String id_proof_number) { this.id_proof_number = id_proof_number; }

    public String getId_proof_url() { return id_proof_url; }
    public void setId_proof_url(String id_proof_url) { this.id_proof_url = id_proof_url; }

    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }
}
