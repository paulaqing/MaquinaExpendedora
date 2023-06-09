package Exceptions;

import Interface.Incidence;

import java.time.LocalDate;

public class FaultException extends Exception implements Incidence {
    private int idMachine;
    private int idProduct;
    private LocalDate date;
    public FaultException() {
        super("Se ha producido una AVERIA. Pongase en contacto con el servicio tecnico");
        this.idMachine= idMachine;
        this.idProduct= idProduct;
        setDate();;
    }
    @Override
    public void setDate() {
        this.date=LocalDate.now();
    }
}
