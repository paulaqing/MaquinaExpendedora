import Exceptions.FaultException;
import Exceptions.JamException;
import Exceptions.NoMoneyException;
import Interface.Incidence;
import Merchantable.Drinks;
import Merchantable.GlutenFree;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Management {
    private ArrayList<Machine> machines;
    private ArrayList<Incidence> incidences;

    public Management() {
        this.machines = new ArrayList<Machine>();
        Money money = new Money();
        int[] capacity = {10, 10, 10};
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new GlutenFree("Biscuits", 1.05f, 1, 25, 200));
        products.add(new GlutenFree("Chocolates ", 1.1f, 2, 25, 150));
        products.add(new Drinks("Coca Cola", 1, 3, 20, false, 200));
        products.add(new GlutenFree("Sandwich ", 1.75f, 4, 20, 250));
        money.insert(0.01f, 10);
        money.insert(0.02f, 10);
        money.insert(0.05f, 20);
        money.insert(0.1f, 30);
        money.insert(0.2f, 25);
        money.insert(0.5f, 15);
        money.insert(1.0f, 12);
        money.insert(2.0f, 5);
        money.insert(5.0f, 3);
        money.insert(10.0f, 2);
        money.insert(20.0f, 1);


        Machine m1 = new Machine(1);
        m1.setMoney(money);
        m1.setProducts(products);

        this.machines.add(m1);

        Machine m2 = new Machine(2);
        m2.setMoney(money);
        m2.setProducts(products);

        this.machines.add(m2);

        Machine m3 = new Machine(3);
        m3.setMoney(money);
        m3.setProducts(products);

        this.machines.add(m3);


       /* this.money.add(new Money(0.01f,new int[]{10,10,10}));
        this.money.add(new Money(0.02f,new int[]{10,10,10}));
        this.money.add(new Money(0.05f,new int[]{10,20,15}));
        this.money.add(new Money(0.1f,new int[]{20,30,10}));
        this.money.add(new Money(0.2f,new int[]{20,30,10}));
        this.money.add(new Money(0.5f,new int[]{20,25,30}));
        this.money.add(new Money(1.0f,new int[]{10,15,12}));
        this.money.add(new Money(2.0f,new int[]{5,7,5}));
        this.money.add(new Money(5.0f,new int[]{2,3,3}));
        this.money.add(new Money(10.0f,new int[]{1,2,1}));
        this.money.add(new Money(20.0f,new int[]{1,1,1}));*/
    }

    public ArrayList<Machine> getMachines() {
        return machines;
    }

    public int getMachineByID(int id) {
        for (int i = 0; i > machines.size(); i++) {
            if (this.machines.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void buyProduct(int machine, int productId, Money clientMoney) {
        Money back = null;
        DecimalFormat format = new DecimalFormat("#.00");
        if (this.getMachines().get(machine).getState() == State.NORMAL) {
            try {
                back = this.machines.get(machine).buyProduct(productId, clientMoney);
                System.out.println("Thank you for your purchase, your change is: " + format.format(back.getTotal()));
            } catch (JamException e) {
                this.incidences.add(e);
                System.out.println(e.getMessage());
            } catch (FaultException e) {
                this.incidences.add(e);
                System.out.println(e.getMessage());
            } catch (NoMoneyException e) {
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Impossible to buy in machine "+machine);
        }

    }

    public void menu(int machines) {
        this.machines.get(getMachineByID(machines)).listProducts();
    }


}
