package com.Reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Reservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);
}
