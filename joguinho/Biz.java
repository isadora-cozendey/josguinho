public class Biz extends Moto {
    public Biz() {
        super("Moto BIZ", new java.util.Random().nextInt(8) + 2, 70);
    }

    public int getConsumo() {
        return 4;
    }

    public void abastecer() {
        combustivel = 20;
        posicao -= 4;
    }
}
