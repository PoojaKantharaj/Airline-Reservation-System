package com.Reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Reservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
