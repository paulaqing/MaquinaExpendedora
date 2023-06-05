public class Money {
    private float[] coins;
    private int[] amount;

    public Money(float[] coins) {
        this.coins = coins;
        coins = new float[]{20.0f,10.0f,5.0f,2.0f,1.0f,0.5f,0.2f,0.1f,0.05f,0.02f,0.01f};
        amount = new int[]{0,0,0,0,0,0,0,0};
    }
    private int getIndex(float worth){
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == worth) {
                return i;
            }
        }
        return -1;
    }
    public void insert(float worth, int amount){
        int index = getIndex(worth);
        if (index != -1) {
            this.amount[index] += amount;
        }
    }
    public void remove(float worth, int amount){
        int index = getIndex(worth);
        if (index != -1) {
            this.amount[index] -= amount;
        }
    }
    public float getTotal(){
        float total = 0;
        for (int i = 0; i < coins.length; i++) {
            total += coins[i] * amount[i];
        }
        return total;
    }
}
