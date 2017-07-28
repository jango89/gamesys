package com.gamesys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamesys.entity.SpaceTravelResponse;
import com.gamesys.exception.SpaceTravelException;
import com.gamesys.service.SpaceTravelInterface;
import com.gamesys.service.SpaceTravelService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class SpaceTravelController extends HttpServlet {

    private static final SpaceTravelInterface SPACE_TRAVEL_INTERFACE = SpaceTravelService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        ObjectMapper objectMapper = new ObjectMapper();

        PrintWriter out = resp.getWriter();

        resp.setHeader("Access-Control-Allow-Origin", "*");

        final String request = IOUtils.toString(req.getReader());

        final Map<String, String> convertedValue = new ObjectMapper().readValue(request, Map.class);

        try {

            final SpaceTravelResponse spaceTravelResponse = SPACE_TRAVEL_INTERFACE.confirmFlight(convertedValue);

            out.print(objectMapper.writeValueAsString(spaceTravelResponse));

        } catch (SpaceTravelException spaceTravelException) {

            resp.setStatus(500);
        	
            out.print(objectMapper.writeValueAsString(spaceTravelException.getError()));

        }

    }
}
