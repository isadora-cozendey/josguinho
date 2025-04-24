public class Kawasaki extends Moto {
    public Kawasaki() {
        super("Moto Kawasaki", new java.util.Random().nextInt(15) + 10, 50);
    }

    public int getConsumo() {
        return 5;
    }

    public void abastecer() {
        combustivel = 20;
        posicao -= 5;
    }
}
