package com.sensedia.tictac.exception.exceptions;

import com.sensedia.tictac.exception.model.InvalidDetailDTO;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


public class UnProcessableEntityException extends RuntimeException {
    private static final String MESSAGE = HttpStatus.UNPROCESSABLE_ENTITY.toString();
    private List<InvalidDetailDTO> details = new ArrayList<>();

    public UnProcessableEntityException(InvalidDetailDTO... details) {
        super(MESSAGE);
        if (details != null)
            this.details = Arrays.asList(details);
    }

    public UnProcessableEntityException(List<InvalidDetailDTO> details) {
        super(MESSAGE);
        this.details = details;
    }

    public UnProcessableEntityException(Set<InvalidDetailDTO> details) {
        super(MESSAGE);
        this.details = new ArrayList<>(details);
    }

    public List<InvalidDetailDTO> getDetails() {
        return details;
    }
}
