package be.reneald.service.exceptions;

public class ExistingEmailException extends IllegalArgumentException {
    public ExistingEmailException(String errorMessage) {
        super(errorMessage);
    }
}
