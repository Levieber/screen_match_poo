package br.com.levieber.screenmatch.domain;

public class FutureYearLaunchException extends RuntimeException {
    private final String message;

    public FutureYearLaunchException() {
        this.message = "Ainda não suportamos prévias!";
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
