import java.util.ArrayList;

public class Management {
    private ArrayList<Product>products;
    private ArrayList<Money>money;

    public Management() {
        this.products = new ArrayList<Product>();
        this.money = new ArrayList<Money>();
        int [] capacity= {10,10,10};
        this.products.add(new GlutenFree("Biscuits ",1.5,capacity));
        this.products.add(new GlutenFree("Chocolates ",1.1,capacity));
        this.products.add(new Drinks("Coca Cola",1.05,capacity,false,200));
        this.products.add(new GlutenFree("Sandwich ",1.75,capacity));
        this.money.add(new Money(0.05f,new int[]{10,20,15}));
        this.money.add(new Money(0.1f,new int[]{20,30,10}));
        this.money.add(new Money(0.2f,new int[]{20,30,10}));
        this.money.add(new Money(0.5f,new int[]{20,25,30}));
        this.money.add(new Money(1.0f,new int[]{10,15,12}));
        this.money.add(new Money(2.0f,new int[]{5,7,5}));
        this.money.add(new Money(5.0f,new int[]{2,3,3}));
        this.money.add(new Money(10.0f,new int[]{1,2,1}));
        this.money.add(new Money(20.0f,new int[]{3,3,3}));
    }
    public int [] change (float value,float price,int machine){
        float[] values = {20.0f,10.0f,0.5f,0.2f,0.1f,0.05f,0.02f,0.01f};
        int [] currency= {0,0,0,0,0,0,0,0,0};
        float change=value-price;
        int pe=(int)price;
        float dec=price-pe;
        int decInteger=(int)dec;
        float decDecimal=dec-decInteger;
        int rest = -1;
        int i=0;

        do{
            if (decInteger >= values[i]){
                int v=(int)values[i];
                rest=decInteger%v;
                currency[i]=decInteger/v;
                decInteger=rest;
            }

        }while(rest==0);



        return null;
    }
    public int getMoney(int machine, float value){
        for (Money m: money){
            if(m.getValue()==value){
                return m.getValues()[machine];
            }
        }
        return 0;
    }
}
