import java.util.Random;

public class MotoAdversaria extends Moto {
    public MotoAdversaria(String nome) {
        super(nome, new Random().nextInt(12) + 3, 100);
    }

    public int getConsumo() {
        return 4;
    }

    public void abastecer() {
        combustivel = 15;
        posicao -= 3;
    }
}
