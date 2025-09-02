import java.util.Scanner;
import java.util.Random;

public class Par_ou_Impar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int vitorias = 0;
        int derrotas = 0;

        System.out.println("=== Jogo do Par ou Ímpar ===");

        while (true) {
            System.out.println("\nEscolha uma opção: Par ou Impar (ou 'sair' para terminar):");
            String escolhaJogador = scanner.nextLine();

            if (escolhaJogador.equalsIgnoreCase("sair")) {
                System.out.println("\n--- Placar Final ---");
                System.out.println("Vitórias: " + vitorias);
                System.out.println("Derrotas: " + derrotas);
                System.out.println("Obrigado por jogar!");
                break;
            }

            if (!escolhaJogador.equalsIgnoreCase("Par") && !escolhaJogador.equalsIgnoreCase("Impar")) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            System.out.println("Escolha um número de 0 a 10:");
            int numeroJogador;
            try {
                numeroJogador = Integer.parseInt(scanner.nextLine());
                if (numeroJogador < 0 || numeroJogador > 10) {
                    System.out.println("Número fora do intervalo! Tente novamente.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Número inválido! Tente novamente.");
                continue;
            }

            int numeroComputador = random.nextInt(11);
            int soma = numeroJogador + numeroComputador;

            System.out.println("Você escolheu: " + numeroJogador + " (" + escolhaJogador + ")");
            System.out.println("Computador escolheu: " + numeroComputador);
            System.out.println("Soma = " + soma + " → " + ((soma % 2 == 0) ? "Par" : "Impar"));

            boolean resultadoPar = soma % 2 == 0;
            boolean jogadorPar = escolhaJogador.equalsIgnoreCase("Par");

            if ((resultadoPar && jogadorPar) || (!resultadoPar && !jogadorPar)) {
                System.out.println("🎉 Você venceu esta rodada!");
                vitorias++;
            } else {
                System.out.println("💻 O computador venceu esta rodada!");
                derrotas++;
            }

            // Mostrar placar parcial
            System.out.println("\nPlacar Atual:");
            System.out.println("Vitórias: " + vitorias + " | Derrotas: " + derrotas);

            // Vitória de melhor de 3
            if (vitorias >= 3) {
                System.out.println("\nJogador venceu o jogo!");
                break;
            } else if (derrotas >= 3) {
                System.out.println("\nComputador venceu o jogo!");
                break;
            }
        }

        scanner.close();
    }
}
