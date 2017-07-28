package com.gamesys.exception;

public class ErrorCodes {

    public static final GameSysError IDENTIFICATION_ERROR = new GameSysError(1, "Valid Galactical Number Needed");

    public static final GameSysError PLACE_ERROR = new GameSysError(2, "Valid Space Travel Place Needed");

    public static final GameSysError DATE_ERROR = new GameSysError(3, "Date is not present");

    public static final GameSysError DATE_GREATER_THAN_TODAY = new GameSysError(4, "Date should be greater than today");

    public static final GameSysError ALREADY_TRAVELLING = new GameSysError(5, "Already travelling on this date to the same place");

    public static final GameSysError NO_FLIGHTS_FOR_THIS_DATE = new GameSysError(6, "Flights are full. Try any other dates");

    public static final GameSysError GENERAL_ERROR = new GameSysError(7, "Internal error occured, Please try after some time");


}
