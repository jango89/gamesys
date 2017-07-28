package com.gamesys.service;

import com.gamesys.entity.SpaceTravel;
import com.gamesys.entity.SpaceTravelFlight;
import com.gamesys.entity.SpaceTravelPlan;
import com.gamesys.entity.SpaceTravelResponse;
import com.gamesys.exception.ErrorCodes;
import com.gamesys.exception.SpaceTravelException;

import java.util.LinkedList;

public class SpaceTravelPlanService {

    private static final LinkedList<SpaceTravelPlan> SPACE_TRAVEL_PLANS = new LinkedList<>();

    private static SpaceTravelPlanSaveService spaceTravelPlanSaveService = new SpaceTravelPlanSaveService();

    private SpaceTravelPlanService() {
    }

    private static final SpaceTravelPlanService INSTANCE = new SpaceTravelPlanService();

    public static SpaceTravelPlanService getInstance() {

        return INSTANCE;
    }


    public SpaceTravelResponse prepareResponseObject(final SpaceTravel spaceTravelObject, Long dateInMillis) {

        SpaceTravelPlan spaceTravelPlan = new SpaceTravelPlan(dateInMillis);

        Integer indexElementPresent = SPACE_TRAVEL_PLANS.indexOf(spaceTravelPlan);

        SpaceTravelResponse spaceTravelResponse = null;

        if (indexElementPresent < 0) {

            spaceTravelResponse = spaceTravelPlanSaveService.updateFlightPlan(spaceTravelPlan, spaceTravelObject);

            indexElementPresent = 0;

        } else {

            spaceTravelPlan = SPACE_TRAVEL_PLANS.get(indexElementPresent);

            validateAlreadyTravelling(spaceTravelObject, spaceTravelPlan);

            spaceTravelResponse = spaceTravelPlanSaveService.updateFlightPlan(spaceTravelPlan, spaceTravelObject);

        }

        SPACE_TRAVEL_PLANS.add(indexElementPresent, spaceTravelPlan);

        return spaceTravelResponse;
    }

    private void validateAlreadyTravelling(SpaceTravel spaceTravelObject, SpaceTravelPlan spaceTravelPlan) {
        for (SpaceTravelFlight flight : spaceTravelPlan.getSpaceTravelFlights()) {

            if (null != flight && flight.getSpaceTravelItem().contains(spaceTravelObject)) {

                throw new SpaceTravelException(ErrorCodes.ALREADY_TRAVELLING);

            }
        }
    }

}
