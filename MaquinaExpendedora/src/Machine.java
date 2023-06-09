import Exceptions.FaultException;
import Exceptions.JamException;
import Interface.Salable;

import java.util.ArrayList;
import java.util.Random;

public class Machine implements Salable {
    private int id;
    private ArrayList<Product> products;
    private Money money;
    private State state;

    public Machine(int id) {
        this.id = id;
        this.products = new ArrayList<Product>();
        this.state = State.NORMAL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void listProducts() {
        for (Product product : this.products) {
            System.out.println(product.toString());
        }
    }

    public void machineInformation() {
        System.out.println("Dinero disponible:");
        this.money.information();
        System.out.println("Productos disponibles:");
        listProducts();
    }

    public Money buyProduct(int productId, Money clientMoney) throws JamException, FaultException {
        if (this.possibleJam() == State.JAM) {
            setState(State.JAM);
            throw new JamException();
        }
        if (this.possibleFault() == State.FAULT) {
            setState(State.FAULT);
            throw new FaultException();
        }
        Money change = null;
        if (clientMoney.getTotal() >= this.products.get(productId).getPrice()) {
            change = this.ChangeManagement(clientMoney, getproductPrice(productId));
            this.money.add(clientMoney);
            this.products.remove(change);
        }
        return change;
    }

    public Money changeManagement(Money clientMoney, int productId) throws JamException, FaultException {
        Money back = new Money();
        float total = clientMoney.getTotal();
        int backAmount = 0;
        int rest = 0;
        if (total >= getproductPrice(productId)) {
            backAmount = (int) ((total - getproductPrice(productId)) * 100);
            for (float val : Salable.values) {
                int cents = (int) (val * 100);
                if (backAmount >= cents && money.getCoins(val) > 0) {
                    rest = backAmount % cents;
                    back.insert(val, backAmount / cents);
                    backAmount = rest;
                }
            }
        }
        if (rest > 0) {
            return null;
        } else {
            return back;
        }
    }

    @Override
    public Money ChangeManagement(Money clientMoney, float productPrice) {
        return null;
    }

    @Override
    public State possibleJam() {
        Random r = new Random();
        if (r.nextInt(100) <= 2) {
            return State.JAM;
        }
        return State.NORMAL;
    }

    @Override
    public State possibleFault() {
        Random r = new Random();
        if (r.nextInt(100) <= 3) {
            return State.JAM;
        }
        return State.NORMAL;
    }

    public float getproductPrice(int productId) {
        for (Product product : this.products) {
            if (product.getId() == productId) {
                return (float) product.getPrice();
            }
        }
        return -1;
    }
}
