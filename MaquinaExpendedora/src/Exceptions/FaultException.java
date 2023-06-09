package Exceptions;

public class FaultException extends Exception {
    public FaultException() {
        super("There is a fault in the machine");
    }
}
