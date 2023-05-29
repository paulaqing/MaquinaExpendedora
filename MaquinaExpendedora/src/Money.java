import java.util.ArrayList;

public class Money {
    float value;
    private int [] values= new int[3];

    public Money(float value, int[] values) {
        this.value = value;
        this.values = values;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }
    public int getWorth(int i){
        return this.values[i];
    }
    public void setWorth(int i,int wrth){
        this.values[i]=wrth;
    }
    public void change(int i){
        this.values[i]--;
    }

}
