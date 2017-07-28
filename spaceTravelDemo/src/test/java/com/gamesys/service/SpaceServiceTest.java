package com.gamesys.service;

import com.gamesys.entity.SpaceTravelResponse;
import com.gamesys.exception.ErrorCodes;
import com.gamesys.exception.SpaceTravelException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

@RunWith(JUnit4.class)
public class SpaceServiceTest {

    @Test
    public void runTestWithSuccessCreation() {

        Map<String, String> httpParams = new HashMap<>();

        httpParams.put("date", "2017-10-19");
        httpParams.put("galacticalId", "adsa67");
        httpParams.put("place", "1");

        final SpaceTravelResponse spaceTravelResponse = SpaceTravelService.getInstance().confirmFlight(httpParams);
        Assert.assertNotNull(spaceTravelResponse);
    }

    @Test(expected = SpaceTravelException.class)
    public void runTestWithSameTravellerErrorCreation() {

        Map<String, String> httpParams = new HashMap<>();

        httpParams.put("date", "2017-10-19");
        httpParams.put("galacticalId", "asd68");
        httpParams.put("place", "2");

        SpaceTravelService.getInstance().confirmFlight(httpParams);

        SpaceTravelService.getInstance().confirmFlight(httpParams);
    }

    @Test()
    public void runTestWithErroInId() {

        Map<String, String> httpParams = new HashMap<>();

        httpParams.put("date", "2017-10-19");
        httpParams.put("galacticalId", "68");
        httpParams.put("place", "2");

        try {

            SpaceTravelService.getInstance().confirmFlight(httpParams);

            Assert.assertNull("");

        } catch (SpaceTravelException exp) {
            Assert.assertEquals(exp.getError().getErrorCode(), ErrorCodes.IDENTIFICATION_ERROR.getErrorCode());
        }

    }

    @Test(expected = SpaceTravelException.class)
    public void errorWithNoMoreSeats() {

        for (int i = 1; i < 12; i++) {

            Map<String, String> httpParams = new HashMap<>();

            httpParams.put("date", "2017-10-19");
            httpParams.put("galacticalId", "aa" + String.valueOf(i));
            httpParams.put("place", "2");

            SpaceTravelService.getInstance().confirmFlight(httpParams);
        }

    }
}
