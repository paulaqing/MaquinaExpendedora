import java.util.ArrayList;
import java.util.Random;

public class Machine implements Salable {
    private int id;
    private ArrayList<Product> products;
    private Money money;
    private State state;

    public Machine(int id) {
        this.id = id;
        this.state = State.NORMAL;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public Money getMoney() {
        return this.money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void listProducts() {
        for (Product p : this.products) {
            System.out.println(p.toString());
        }
    }

    public void machineInform() {
        System.out.println("Money aviailable:");
        this.money.information();
        System.out.println("Products available:");
        this.listProducts();
    }

    public Money buyProduct(Money clientMoney, int idProduct) throws JamException, FaultException {
        if (this.possibleJam() == State.JAM) {
            setState(State.JAM);
            throw new JamException();
        }
        if (this.possibleFault() == State.FAULT) {
            setState(State.FAULT);
            throw new FaultException();
        }
        Money change = null;
        if (clientMoney.getTotal() >= this.products.get(idProduct).getPrice()) {
            change = this.manageChange(clientMoney, getProductPrice(idProduct));
            this.money.plus(clientMoney);
            this.money.subtract(change);
        }

        return change;
    }

    public Money manageChange(Money clientMoney, float productPrice) {
        Money change = new Money();
        float impor = clientMoney.getTotal();
        int changeImport = 0;

        int rest = 1;
        if (impor >= productPrice) {
            changeImport = (int) (impor - productPrice) * 100;

            for (float val : Salable.values) {
                int cents = (int) (val * 100);
                if (changeImport >= cents && money.getAmount(val) > 0) {
                    rest = changeImport % cents;
                    change.insert(val, changeImport / cents);
                    changeImport = rest;
                }
            }
        }
        if (rest > 0) {
            return null;
        } else {
            return change;
        }
    }

    public State possibleJam() {
        Random r = new Random();
        if (r.nextInt(100) <= 2) {
            return State.JAM;
        }
        return State.NORMAL;
    }

    public State possibleFault() {
        Random r = new Random();
        if (r.nextInt(100) <= 3) {
            return State.FAULT;
        }
        return State.NORMAL;
    }

    public float getProductPrice(int id) {
        for (Product p : this.products) {
            if (p.getId() == id) {
                return (float) p.getPrice();
            }
        }
        return -1;
    }

}