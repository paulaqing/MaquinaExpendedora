package Exceptions;

import Interface.Incidence;

import java.time.LocalDate;

public class NoMoneyException extends Exception implements Incidence {
    private int idMachine;
    private int idProduct;
    private LocalDate date;
    public NoMoneyException() {
        super("There is no money");
        this.idMachine= idMachine;
        this.idProduct= idProduct;
        setDate();
    }
    @Override
    public void setDate() {
        this.date=LocalDate.now();
    }
}
