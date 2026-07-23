package ec.edu.ups.icc.labevaluation.supplies.exceptions;

import org.springframework.http.HttpStatus;
import ec.edu.ups.icc.labevaluation.core.exceptions.base.ApplicationException;

public class SupplyConflictException extends ApplicationException {

    public SupplyConflictException(String message) {
        super(HttpStatus.CONFLICT, "SUPPLY_CONFLICT", message);
    }
}