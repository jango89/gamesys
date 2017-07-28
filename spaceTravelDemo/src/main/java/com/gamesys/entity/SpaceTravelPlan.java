package com.gamesys.entity;

import com.gamesys.service.EnvironmentReader;

public final class SpaceTravelPlan {

    public static final int MAXIMUM_FLIGHTS = Integer.parseInt(EnvironmentReader.INSTANCE.getValue("max.flights"));

    private long dateOfTravel;

    private int currentAccessibleFlight = 0;

    private int currentAccessibleSeat = 0;

    private SpaceTravelFlight[] spaceTravelFlights = new SpaceTravelFlight[MAXIMUM_FLIGHTS];

    public SpaceTravelPlan(long dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public long getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(long dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public SpaceTravelFlight[] getSpaceTravelFlights() {
        return spaceTravelFlights;
    }

    public void setSpaceTravelFlights(SpaceTravelFlight[] spaceTravelFlights) {
        this.spaceTravelFlights = spaceTravelFlights;
    }

    public boolean hasSpaceForAnotherCustomer() {

        return currentAccessibleFlight < MAXIMUM_FLIGHTS;
    }

    public synchronized void updateCurrentFlightsAndSeats() {

        currentAccessibleSeat = currentAccessibleSeat + 1;

        if (currentAccessibleSeat == SpaceTravelFlight.MAX_SEATS) {

            currentAccessibleFlight = currentAccessibleFlight + 1;
            currentAccessibleSeat = 0;

        }

    }

    public int getCurrentAccessibleFlight() {
        return currentAccessibleFlight;
    }

    public void setCurrentAccessibleFlight(int currentAccessibleFlight) {
        this.currentAccessibleFlight = currentAccessibleFlight;
    }

    public int getCurrentAccessibleSeat() {
        return currentAccessibleSeat;
    }

    public void setCurrentAccessibleSeat(int currentAccessibleSeat) {
        this.currentAccessibleSeat = currentAccessibleSeat;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (dateOfTravel ^ (dateOfTravel >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpaceTravelPlan other = (SpaceTravelPlan) obj;
        if (dateOfTravel != other.dateOfTravel)
            return false;
        return true;
    }


}
