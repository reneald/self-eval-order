package be.reneald.api.config;


import be.reneald.domain.orders.Order;
import be.reneald.service.exceptions.ExistingEmailException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = "be.reneald")
public class ControllerAdvice {
    private final static Logger LOGGER = Logger.getLogger(Order.class.getName());

    @ExceptionHandler
    public ResponseEntity<String> convertIllegalArgumentException(final IllegalArgumentException exception) {
        LOGGER.error(exception.getMessage());
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> convertExistingEmailException(final ExistingEmailException exception) {
        LOGGER.error(exception.getMessage());
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

}
