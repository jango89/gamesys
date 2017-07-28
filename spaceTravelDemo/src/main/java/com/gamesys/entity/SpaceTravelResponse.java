package com.gamesys.entity;

public class SpaceTravelResponse {

    private String dateOfTravel;
    private String place;
    private String galacticalId;
    private Integer flightId;
    private Integer seatNumber;

    public SpaceTravelResponse(String dateOfTravel, String place, String galacticalId, Integer flightId, Integer seatNumber) {
        this.dateOfTravel = dateOfTravel;
        this.place = place;
        this.galacticalId = galacticalId;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(String dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGalacticalId() {
        return galacticalId;
    }

    public void setGalacticalId(String galacticalId) {
        this.galacticalId = galacticalId;
    }

    @Override
    public String toString() {
        return "SpaceTravelResponse{" +
                "dateOfTravel='" + dateOfTravel + '\'' +
                ", place='" + place + '\'' +
                ", galacticalId='" + galacticalId + '\'' +
                ", flightId=" + flightId +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
