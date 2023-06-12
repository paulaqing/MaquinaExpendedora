import Exceptions.FaultException;
import Exceptions.JamException;
import Interface.Incidence;
import Interface.State;
import Merchantable.Drinks;
import Merchantable.GlutenFree;
import Merchantable.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Management {
    private ArrayList<Machine>machines;
    private ArrayList<Incidence>incidences;


    public Management() {
        this.machines = new ArrayList<Machine>();
      Money dinero = new Money();
        int [] capacity= {10,10,10};
        ArrayList<Product>products= new ArrayList<Product>();
        ArrayList<Drinks>drinks= new ArrayList<Drinks>();
        products.add(new GlutenFree("Biscuits",1.05f,1,25,200));
        products.add(new GlutenFree("Chocolates ",1.1f,2,25,150));
        products.add(new GlutenFree("Sandwich ",1.75f,4,20,250));
        products.add(new Drinks("Coca cola",1.5f,3,20,false,200));
        dinero.insert(0.01f,10);
        dinero.insert(0.02f,10);
        dinero.insert(0.05f,20);
        dinero.insert(0.1f,30);
        dinero.insert(0.2f,25);
        dinero.insert(0.5f,15);
        dinero.insert(1.0f,12);
        dinero.insert(2.0f,5);
        dinero.insert(5.0f,3);
        dinero.insert(10.0f,2);
        dinero.insert(20.0f,1);




        Machine m1=new Machine(1);
        m1.setMoney(dinero);
        m1.setProducts(products);

        this.machines.add(m1);

        Machine m2=new Machine(2);
        m2.setMoney(dinero);
        m2.setProducts(products);

        this.machines.add(m2);

        Machine m3=new Machine(3);
        m3.setMoney(dinero);
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
    public int getMachineId(int id){
        for (int i=0;i<machines.size();i++){
            if (machines.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
    public void menu(int machines){
        this.machines.get(getMachineId(machines)).listProducts();
    }
    public void buyProduct(int machine, int productid, Money clientMoney) {
        Money back = null;
        DecimalFormat format = new DecimalFormat("#.00");
        if (this.getMachines().get(machine).getState() == State.NORMAL) {
            try {
                back = this.getMachines().get(machine).buyProduct(productid, clientMoney);
                System.out.println("Your change is " + format.format(back.getTotal()) + "€");
            } catch (JamException e) {
                this.incidences.add(e);
                System.out.println(e.getMessage());
            }catch (FaultException e){
                this.incidences.add(e);
                System.out.println(e.getMessage());
            }
        }else{
                System.out.println("Impossible to buy on " + machine);
        }

    }


    public void machineInformation(int id){
        for (Machine m : this.machines) {
            machineInformation(m.getId());
        }
    }




}
