package com.Reservation.service;

import com.Reservation.dto.ReservationRequest;
import com.Reservation.entities.Reservation;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest request);
}
