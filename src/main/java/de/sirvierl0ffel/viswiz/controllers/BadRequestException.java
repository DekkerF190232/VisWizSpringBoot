package de.sirvierl0ffel.viswiz.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad request")
public class BadRequestException extends RuntimeException {
}
