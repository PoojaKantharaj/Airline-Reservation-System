package com.Reservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Reservation.dto.ReservationRequest;
import com.Reservation.entities.Flight;
import com.Reservation.entities.Passenger;
import com.Reservation.entities.Reservation;
import com.Reservation.repository.FlightRepository;
import com.Reservation.repository.PassengerRepository;
import com.Reservation.repository.ReservationRepository;
import com.Reservation.utility.Emailutil;
import com.Reservation.utility.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	 
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo; 
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	
	  @Autowired 
	  private Emailutil emailUtil;
	 
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {

		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservationRepo.save(reservation);
		
		String filePath = "C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\FlightReservation\\sampleTicket\\resevationTicket" + reservation.getId() + ".pdf";
		pdfGenerator.generatePDF(filePath, reservation);
		emailUtil.sendItineary(passenger.getEmail(), filePath); 
		
		 
		return reservation;
	}

}
