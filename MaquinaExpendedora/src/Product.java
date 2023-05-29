public abstract class Product {

     protected String name;
     protected double price;
     protected int [] amount= new int[3];

     public Product(String name, double price) {

          this.name = name;
          this.price = price;
     }
     public Product(String name, double price,int [] amount) {

          this.name = name;
          this.price = price;
          this.amount=amount;
     }


     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }


     public int getAmount(int i){
          return this.amount[i];
     }
     public void setAmount (int i, int value){
          this.amount[i]=value;
     }
     public void sell(int i){
          this.amount[i]--;
     }
}
