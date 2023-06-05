public class FaultException extends Exception{
    public FaultException(){
        super("Se ha producido una AVERIA. Pongase en contacto con el servicio tecnico");
    }
}