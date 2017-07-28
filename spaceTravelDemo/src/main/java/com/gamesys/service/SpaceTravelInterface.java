package com.gamesys.service;

import com.gamesys.entity.SpaceTravelResponse;

import java.util.Map;

public interface SpaceTravelInterface {
	
	SpaceTravelResponse confirmFlight(Map<String, String> convertedValue);
}
