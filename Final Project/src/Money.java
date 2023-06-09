import java.util.ArrayList;

public class Money {
    private float [] coins;
    private int [] amount;

    public Money() {
        coins= new float[]{20.0f,10.0f,5.0f,2.0f,1.0f,0.5f,0.2f,0.1f,0.05f,0.02f,0.01f};
        amount= new int[]{0,0,0,0,0,0,0,0,0,0,0};
    }
    private int getIndex(float worth){
        int index=-1;
        for(int i=0;i<coins.length;i++){
            if(coins[i]==worth){
                index= i;
            }
        }
        return index;
    }
    public void insert(float worth,int amount){
        int index= getIndex(worth);
        if(index!=-1){
            this.amount[index]+=amount;
        }
    }
    public void remove (float worth,int amount){
        int index= getIndex(worth);
        if(index!=-1){
            this.amount[index]-=amount;
        }
    }

    public float getTotal(){
        float total=0;
        for(int i=0;i<coins.length;i++){
            total+=coins[i]*amount[i];
        }
        return total;
    }

    public int getCoins(float val) {
        int pos=this.getIndex(val);
        if(pos!=-1){
            return this.amount[pos];
        }
        return 0;
    }
    public void add (Money money){
        for(float value:money.coins){
            this.insert(value,money.getCoins(value));
        }
    }
    public boolean sustract(Money money){
        for (float value:money.coins){
            if(this.getCoins(value)<money.getCoins(value)){
                return false;
            }
        }
        for (float value:money.coins){
            this.insert(value,money.getCoins(value));
        }
        return true;
    }
    public void information(){
        for(float val:this.coins){
            if (val >= 5){
                System.out.println("Bill of "+val+"€: "+this.getCoins(val));
            }
            else{
                System.out.println("Coin of "+val+"€: "+this.getCoins(val));
            }
        }
    }
}
