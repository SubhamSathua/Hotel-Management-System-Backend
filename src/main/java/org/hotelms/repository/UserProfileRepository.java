package org.hotelms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.hotelms.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
