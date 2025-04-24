import java.util.Scanner;
/*Em caso de empate seria legal a gente mudar as posições dos jogadores que ganharam pro tamanho da distância. 
Porque eles podem ter posições diferentes e mesmo assim empatarem e fica confuso.b */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomesAdversarios = {"Moto LAMBRETA", "Moto SUZUKI", "Moto TWISTER", "Moto NINJA"};
        MotoAdversaria[] adversarios = new MotoAdversaria[nomesAdversarios.length];

        System.out.println("\n* Corrida de Motos *");
        System.out.println("-------------------------");
        System.out.print("Digite seu nome: ");
        String nomeJogador = sc.nextLine();

        Moto jogador = escolherMoto(sc);

        System.out.println("Escolha o trajeto:");
        System.out.println("1 - Circuito das Estrelas");
        System.out.println("2 - Estrada Cosmica");
        System.out.println("3 - Deserto do Atacama");
        System.out.print("Digite o número: ");
        int opcao = sc.nextInt();
        sc.nextLine(); // limpa buffer

        String trajeto;
        switch (opcao) {
            case 2:
                trajeto = "Estrada Cosmica";
                break;
            case 3:
                trajeto = "Deserto do Atacama";
                break;
            case 1:
            default:
                trajeto = "Circuito das Estrelas";
        }

        for (int i = 0; i < adversarios.length; i++) {
            adversarios[i] = new MotoAdversaria(nomesAdversarios[i]);
        }

        CorridaMotos corrida = new CorridaMotos(jogador, adversarios, trajeto);
        corrida.iniciar();
    }

    private static Moto escolherMoto(Scanner sc) {
        System.out.println("\nEscolha sua moto:");
        System.out.println("1 - Moto Kawasaki (Velocidade alta, Combustível baixo)");
        System.out.println("2 - Moto XRE (Velocidade média, Combustível médio)");
        System.out.println("3 - Moto BIZ (Velocidade baixa, Combustível alto)");
        System.out.print("Digite o número: ");
        int escolha = sc.nextInt();
        sc.nextLine(); // limpa buffer

        switch (escolha) {
            case 2:
                return new Xre();
            case 3:
                return new Biz();
            case 1:
            default:
                return new Kawasaki();
        }
    }
}
