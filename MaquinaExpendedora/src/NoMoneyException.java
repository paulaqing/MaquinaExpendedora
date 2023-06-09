import java.time.LocalDate;

public class NoMoneyException extends Exception implements Incidence {
    private int machineId;
    private int productId;
    private LocalDate date;
    public NoMoneyException(int machineId, int productId) {
        super("There is no money in the machine");
        this.machineId = machineId;
        this.productId = productId;
        setDate();
    }

    @Override
    public void setDate() {
        this.date = LocalDate.now();
    }
}
