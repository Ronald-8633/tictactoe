package com.sensedia.tictac.exception;

import com.sensedia.tictac.exception.exceptions.BadRequestException;
import com.sensedia.tictac.exception.exceptions.UnProcessableEntityException;
import com.sensedia.tictac.exception.model.InvalidDTO;
import javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(UnProcessableEntityException.class)
    public @ResponseBody
    InvalidDTO handleUnProcessableEntity(Exception ex) {
        final var unProcessableEntityException = (UnProcessableEntityException) ex;
        return new InvalidDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage(), unProcessableEntityException.getDetails());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class, BadHttpRequest.class})
    public @ResponseBody
    InvalidDTO handleBadRequestEntity(Exception ex) {
        final var badRequestException = (BadRequestException) ex;
        return new InvalidDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), badRequestException.getDetails());
    }

}
