package com.luiscastillo.pizzeria.service.exception;

public class EmailApiException extends RuntimeException {
    public EmailApiException() {
        super("Error sending e-mail: ");
    }
}
