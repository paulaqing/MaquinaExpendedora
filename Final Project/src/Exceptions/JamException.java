package Exceptions;

import Interface.Incidence;

import java.time.LocalDate;

public class JamException extends Exception implements Incidence {
    private int idMachine;
    private int idProduct;
    private LocalDate date;
    public JamException(int idMachine,int idProduct){
        super("Se ha producido un ATASCO");
        this.idMachine= idMachine;
        this.idProduct= idProduct;
        setDate();
    }
    @Override
    public void setDate() {
        this.date=LocalDate.now();
    }
}
