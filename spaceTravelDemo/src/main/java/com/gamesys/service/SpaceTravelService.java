package com.gamesys.service;

import com.gamesys.entity.SpaceTravel;
import com.gamesys.entity.SpaceTravelResponse;
import com.gamesys.exception.ErrorCodes;
import com.gamesys.exception.SpaceTravelException;
import com.gamesys.validator.SpaceTravelValidator;
import org.apache.log4j.Logger;

import java.util.Map;

public class SpaceTravelService implements SpaceTravelInterface {

    private static final Logger LOGGER = Logger.getLogger("SpaceTravelService");

    private final SpaceTravelValidator validator = SpaceTravelValidator.getINSTANCE();

    private final SpaceTravelPlanService spaceTravelPlanService = SpaceTravelPlanService.getInstance();

    private static final SpaceTravelInterface INSTANCE = new SpaceTravelService();

    public static SpaceTravelInterface getInstance() {
        return INSTANCE;
    }

    private SpaceTravelService() {
    }

    @Override
    public SpaceTravelResponse confirmFlight(Map<String, String> convertedValue) {

        try {

            final SpaceTravel spaceTravelObject = getSpaceTravelObject(convertedValue);

            SpaceTravelResponse spaceTravelResponse = getResponseObject(convertedValue.get("date"), spaceTravelObject);

            return spaceTravelResponse;

        } catch (SpaceTravelException spaceTravelException) {

            throw spaceTravelException;

        } catch (Exception exception) {

            exception.printStackTrace();
            LOGGER.error(exception.getMessage());

            throw new SpaceTravelException(ErrorCodes.GENERAL_ERROR);
        }
    }

    private SpaceTravelResponse getResponseObject(String date, SpaceTravel spaceTravelObject) {

        Long dateInMillis = validator.getDateInMillis(date);

        validatePlanIsForFuture(dateInMillis);

        return spaceTravelPlanService.prepareResponseObject(spaceTravelObject, dateInMillis);

    }

    private void validatePlanIsForFuture(Long dateInMillis) {
        if (!validator.isDateGreaterThanToday(dateInMillis)) {

            throw new SpaceTravelException(ErrorCodes.DATE_GREATER_THAN_TODAY);
        }
    }

    private SpaceTravel getSpaceTravelObject(Map<String, String> convertedValue) {

        String galacticalId = convertedValue.get("galacticalId");

        String galacticalPlace = convertedValue.get("place");

        validator.validateString(galacticalId, ErrorCodes.IDENTIFICATION_ERROR);

        validator.validateString(galacticalPlace, ErrorCodes.PLACE_ERROR);

        validator.validateGalacticalId(galacticalId, ErrorCodes.IDENTIFICATION_ERROR);

        return new SpaceTravel(galacticalId, galacticalPlace);
    }

}
