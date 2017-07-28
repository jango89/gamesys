package com.gamesys.service;

import com.gamesys.entity.SpaceTravel;
import com.gamesys.entity.SpaceTravelFlight;
import com.gamesys.entity.SpaceTravelPlan;
import com.gamesys.entity.SpaceTravelResponse;
import com.gamesys.exception.ErrorCodes;
import com.gamesys.exception.SpaceTravelException;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SpaceTravelPlanSaveService {

    private static final Logger LOGGER = Logger.getLogger("SpaceTravelPlanSaveService");

    public SpaceTravelResponse updateFlightPlan(final SpaceTravelPlan spaceTravelPlan, final SpaceTravel spaceTravel) {

        if (!spaceTravelPlan.hasSpaceForAnotherCustomer()) {

            throw new SpaceTravelException(ErrorCodes.NO_FLIGHTS_FOR_THIS_DATE);

        } else {

            final int currentAccessibleFlight = spaceTravelPlan.getCurrentAccessibleFlight();

            final int currentAccessibleSeat = spaceTravelPlan.getCurrentAccessibleSeat();

            SpaceTravelFlight flight = setFlightDetailIfNotPresent(spaceTravelPlan, currentAccessibleFlight);

            flight.getSpaceTravelItem()
                    .add(spaceTravel);

            spaceTravelPlan.updateCurrentFlightsAndSeats();

            final String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date(spaceTravelPlan.getDateOfTravel()));

            final SpaceTravelResponse spaceTravelResponse = new SpaceTravelResponse(date, spaceTravel.getPlace(), spaceTravel.getPersonalGalaticalNumber(), currentAccessibleFlight, currentAccessibleSeat);

            LOGGER.info("Search travel response created " + spaceTravelResponse.toString());

            return spaceTravelResponse;

        }
    }

    private SpaceTravelFlight setFlightDetailIfNotPresent(SpaceTravelPlan spaceTravelPlan, int currentAccessibleFlight) {
        SpaceTravelFlight flight = spaceTravelPlan.getSpaceTravelFlights()[currentAccessibleFlight];

        if (flight == null) {

            flight = new SpaceTravelFlight();

            spaceTravelPlan.getSpaceTravelFlights()[currentAccessibleFlight] = flight;
        }

        return flight;
    }
}
