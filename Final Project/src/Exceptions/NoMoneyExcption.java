package Exceptions;

import Interface.Incidence;

import java.time.LocalDate;

public class NoMoneyExcption extends Exception implements Incidence {
    private int idMachine;
    private int idProduct;
    private LocalDate date;
    public NoMoneyExcption() {
        super("No tienes dinero suficiente");
        this.idMachine= idMachine;
        this.idProduct= idProduct;
        setDate();
    }
    @Override
    public void setDate() {
        this.date=LocalDate.now();
    }
}
