package Interface;

public interface Salable {
    final float[] values = {20.0f, 10.0f, 5.0f, 2.0f, 1.0f, 0.5f, 0.2f, 0.1f, 0.05f, 0.02f, 0.01f};

    public Money ChangeManagement(Money clientMoney, float productPrice);

    public State possibleJam();

    public State possibleFault();
}
