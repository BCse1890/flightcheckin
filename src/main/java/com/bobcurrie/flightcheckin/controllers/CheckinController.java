package com.bobcurrie.flightcheckin.controllers;

import com.bobcurrie.flightcheckin.integration.ReservationRestClient;
import com.bobcurrie.flightcheckin.integration.dto.Reservation;
import com.bobcurrie.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckinController {

    @Autowired
    ReservationRestClient restClient;

    @RequestMapping("/showStartCheckin")
    public String showStartCheckin() {
        return "startCheckin";
    }

    @RequestMapping("/startCheckin")
    // @RequestParam used to map reservationId to what is coming in the request
    public String startCheckin(@RequestParam Long reservationId, ModelMap modelMap) {
        Reservation reservation = restClient.findReservation(reservationId);
        modelMap.addAttribute("reservation", reservation);
        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckin")
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
                                  @RequestParam("numberOfBags") int numberOfBags) {
        ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
        reservationUpdateRequest.setId(reservationId);
        reservationUpdateRequest.setCheckedIn(true);
        reservationUpdateRequest.setNumberOfBags(numberOfBags);
        restClient.updateReservation(reservationUpdateRequest);
        return "checkInConfirmation";
    }

    @RequestMapping("/showStartCheckIn")
    public String showStartCheckInPage() {
        return "startCheckin";
    }
}
