import java.util.Scanner;

public class CorridaMotos {
    private Moto jogador;
    private MotoAdversaria[] adversarios;
    private String trajeto;
    private int distanciaTotal;
    private final int NUM_ADVERSARIOS = 4;

    public CorridaMotos(Moto jogador, MotoAdversaria[] adversarios, String trajeto) {
        this.jogador = jogador;
        this.adversarios = adversarios;
        this.trajeto = trajeto;
        definirDistancia();
    }

    private void definirDistancia() {
        switch (trajeto) {
            case "Circuito das Estrelas":
                distanciaTotal = 50;
                break;
            case "Estrada Cosmica":
                distanciaTotal = 100;
                break;
            case "Deserto do Atacama":
                distanciaTotal = 150;
                break;
            default:
                distanciaTotal = 50;
        }
    }

    public void iniciar() {
        System.out.println("\n--- Iniciando a Corrida no trajeto " + trajeto + "! ---");
        System.out.println("Distância total: " + distanciaTotal + " unidades");

        int turno = 1;
        boolean corridaFinalizada = false;
        Scanner scanner = new Scanner(System.in);

        while (!corridaFinalizada && turno <= 250) {
            System.out.println("\n\n--- Turno " + turno + " ---");

            jogador.mover();
            for (MotoAdversaria adversario : adversarios) {
                adversario.mover();
            }

            exibirPosicoes();

            boolean jogadorVenceu = jogador.getPosicao() >= distanciaTotal;
            boolean[] vitorias = new boolean[NUM_ADVERSARIOS];
            int vencedores = jogadorVenceu ? 1 : 0;

            for (int i = 0; i < NUM_ADVERSARIOS; i++) {
                if (adversarios[i].getPosicao() >= distanciaTotal) {
                    vitorias[i] = true;
                    vencedores++;
                }
            }

            if (vencedores > 0) {
                corridaFinalizada = true;
                System.out.println("\n--- Linha de chegada cruzada! ---\n");
                if (vencedores == 1) {
                    if (jogadorVenceu) {
                        System.out.println("*** " + jogador.getNome() + " venceu a corrida! ***");
                    } else {
                        for (int i = 0; i < NUM_ADVERSARIOS; i++) {
                            if (vitorias[i]) {
                                System.out.println("*** " + adversarios[i].getNome() + " venceu a corrida! ***");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("*** Empate! Vencedores: ***");
                    if (jogadorVenceu) System.out.println("- " + jogador.getNome());
                    for (int i = 0; i < NUM_ADVERSARIOS; i++) {
                        if (vitorias[i]) System.out.println("- " + adversarios[i].getNome());
                    }
                }
                break;
            }

            System.out.println("\nPressione Enter para avançar a corrida...");
            scanner.nextLine();
            turno++;
        }

        if (turno > 250) {
            System.out.println("\nCorrida muito longa! Empate técnico!!!");
        }
    }

    private void exibirPosicoes() {
        System.out.println("\n--- Posições Atuais ---");
        System.out.println(jogador.getNome() + ": " + jogador.getPosicao());
        for (Moto adversario : adversarios) {
            System.out.println(adversario.getNome() + ": " + adversario.getPosicao());
        }
    }
}
