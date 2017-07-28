package com.gamesys.exception;

public class SpaceTravelException extends RuntimeException {

    private GameSysError error;

    public SpaceTravelException(GameSysError error) {
        super();
        this.error = error;
    }

    public GameSysError getError() {
        return error;
    }

    public void setError(GameSysError error) {
        this.error = error;
    }
}
