package Exceptions;

import Interface.Incidence;

import java.time.LocalDate;

public class FaultException extends Exception implements Incidence {
    private int idMachine;
    private int idProduct;
    private LocalDate date;
    public FaultException() {
        super("There has been a fault");
        this.idMachine= idMachine;
        this.idProduct= idProduct;
        setDate();;
    }
    @Override
    public void setDate() {
        this.date=LocalDate.now();
    }
}
