package ec.edu.ups.icc.labevaluation.core.exceptions.domain;

import org.springframework.http.HttpStatus;
import ec.edu.ups.icc.labevaluation.core.exceptions.base.ApplicationException;

public class ConflictException extends ApplicationException {
    public ConflictException(String code, String message) {
        super(HttpStatus.CONFLICT, code, message);
    }
    public ConflictException(String message) {
        this("CONFLICT", message);
    }
}
