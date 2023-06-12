import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Management management=new Management();
        management.machineInformation(2);
        int purchasesNumber=3;
        Random r=new Random();
        for(int i=0;i<purchasesNumber;i++){
            Money client=new Money();
            client.insert(Coin.values[r.nextInt(Coin.values.length)],1);  //Dinero introducido al azar
            int productoAzar=r.nextInt(4);
            int idMaquina=r.nextInt(3);
            System.out.println("Cliente intenta compra del producto "+productoAzar+" en maquina "+idMaquina+" con "+client.getTotal()+" euros");
            management.buyProduct(idMaquina,productoAzar,client);

            management.machineInformation(2);
        }
    }
}