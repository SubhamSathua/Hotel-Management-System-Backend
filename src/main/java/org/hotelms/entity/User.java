package org.hotelms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int user_id;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 20)
    private String role;   // ADMIN, MANAGER, RECEPTION, CUSTOMER

    @Column(nullable = false, length = 20)
    private String status; // ACTIVE, INACTIVE

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public User() {}

    public User(String email, String password, String role, String status) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    // --- Getters & Setters ---
    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }

    public LocalDateTime getUpdated_at() { return updated_at; }
    public void setUpdated_at(LocalDateTime updated_at) { this.updated_at = updated_at; }
}
