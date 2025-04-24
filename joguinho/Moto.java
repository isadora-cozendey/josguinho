public abstract class Moto {
    protected String nome;
    protected int velocidade;
    protected int combustivel;
    protected int posicao;

    public Moto(String nome, int velocidade, int combustivel) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.combustivel = combustivel;
        this.posicao = 0;
    }

    public void mover() {
        posicao += velocidade;
        combustivel -= getConsumo();

        if (combustivel <= 0) {
            System.out.println(nome + " precisa abastecer! Perde tempo...");
            abastecer();
        }

        System.out.println(nome + " avançou " + velocidade + " unidades. Posição: " + posicao + ", Combustível: " + combustivel);
    }

    // 👇 Esses dois aqui são abstratos:
    protected abstract int getConsumo();
    protected abstract void abastecer();

    public String getNome() { return nome; }
    public int getPosicao() { return posicao; }
}
