package com.gamesys.validator;


import com.gamesys.exception.ErrorCodes;
import com.gamesys.exception.GameSysError;
import com.gamesys.exception.SpaceTravelException;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SpaceTravelValidator {

    private static final SpaceTravelValidator INSTANCE = new SpaceTravelValidator();

    private static final String dateFormat = "yyyy-MM-dd";

    private SpaceTravelValidator() {
    }

    public static SpaceTravelValidator getINSTANCE() {
        return INSTANCE;
    }

    public void validateString(String galacticalId, GameSysError identificationError) {
        if (StringUtils.isBlank(galacticalId)) {

            throw new SpaceTravelException(identificationError);
        }
    }

    public Long getDateInMillis(String date) {

        validateString(date, ErrorCodes.DATE_ERROR);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        try {

            final Calendar calendar = Calendar.getInstance();

            calendar.setTimeInMillis(simpleDateFormat.parse(date).getTime());

            int year = calendar.get(Calendar.YEAR);

            int month = calendar.get(Calendar.MONTH);

            int day = calendar.get(Calendar.DATE);

            calendar.set(year, month, day, 0, 0, 0);

            return calendar.getTimeInMillis();

        } catch (ParseException e) {

            throw new SpaceTravelException(ErrorCodes.DATE_ERROR);
        }
    }

    public boolean isDateGreaterThanToday(Long dateInMillis) {

        final Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);

        int month = calendar.get(Calendar.MONTH);

        int day = calendar.get(Calendar.DATE);

        calendar.set(year, month, day, 59, 59, 59);

        return dateInMillis > calendar.getTimeInMillis();
    }

    public void validateGalacticalId(String galacticalId, GameSysError identificationError) {

        if (!galacticalId.toLowerCase().matches("([a-z])\\w+([\\d])\\w+")) {

            throw new SpaceTravelException(identificationError);
        }
    }
}
