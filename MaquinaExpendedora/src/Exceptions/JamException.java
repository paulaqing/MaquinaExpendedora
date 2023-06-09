package Exceptions;

import Interface.Incidence;

import java.time.LocalDate;
public class JamException extends Exception implements Incidence {
    private int machineId;
    private int productId;
    private LocalDate date;
    public JamException(int machineId, int productId) {
        super("There is a jam in the machine");
        this.machineId = machineId;
        this.productId = productId;
        setDate();
    }

    @Override
    public void setDate() {
        this.date = LocalDate.now();
    }
}
