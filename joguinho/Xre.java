public class Xre extends Moto {
    public Xre() {
        super("Moto XRE", new java.util.Random().nextInt(10) + 5, 60);
    }

    public int getConsumo() {
        return 5;
    }

    public void abastecer() {
        combustivel = 20;
        posicao -= 5;
    }
}
