package com.gamesys.entity;

import com.gamesys.service.EnvironmentReader;

import java.util.ArrayList;

public class SpaceTravelFlight {

	public static final int MAX_SEATS = Integer.parseInt(EnvironmentReader.INSTANCE.getValue("max.seats"));

	private ArrayList<SpaceTravel> spaceTravelItem = new ArrayList<>(MAX_SEATS);

	public ArrayList<SpaceTravel> getSpaceTravelItem() {
		return spaceTravelItem;
	}

	public void setSpaceTravelItem(ArrayList<SpaceTravel> spaceTravelItem) {
		this.spaceTravelItem = spaceTravelItem;
	}

}
