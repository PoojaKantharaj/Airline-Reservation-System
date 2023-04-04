package com.Reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Reservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
