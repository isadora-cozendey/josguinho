public class Biz extends Moto {
    public Biz() {
        super("Moto BIZ", new java.util.Random().nextInt(8) + 2, 100);
    }

    public int getConsumo() {
        return 5;
    }

    public void abastecer() {
        combustivel = 20;
        posicao -= 5;
    }
}
