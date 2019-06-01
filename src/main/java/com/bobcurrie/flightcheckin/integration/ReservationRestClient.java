package com.bobcurrie.flightcheckin.integration;

import com.bobcurrie.flightcheckin.integration.dto.Reservation;
import com.bobcurrie.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    public Reservation findReservation(Long id);
    public Reservation updateReservation(ReservationUpdateRequest request);
}
