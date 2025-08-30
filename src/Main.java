import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final char [][] jogo = new char [3][3];
    public static void tabuleiro () {
        for (char[] linha : jogo) {
            for (char celula : linha) {
                if (celula == 0) {
                    System.out.print("[ ]");
                }else {
                    System.out.printf("[%c]", celula);
                }
            }
            System.out.println();
        }
    }
    public static void jogador1 (int l, int c) {
        jogo[l][c] = 'X';
        tabuleiro();
    }
    public static void jogador2 (int l, int c) {
        jogo[l][c] = 'O';
        tabuleiro();
    }
    public static boolean verificador(char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (jogo[i][0] == simbolo && jogo[i][1] == simbolo && jogo[i][2] == simbolo) return true;
            if (jogo[0][i] == simbolo && jogo[1][i] == simbolo && jogo[2][i] == simbolo) return true;
        }
        if (jogo[0][0] == simbolo && jogo[1][1] == simbolo && jogo[2][2] == simbolo) return true;
        if (jogo[0][2] == simbolo && jogo[1][1] == simbolo && jogo[2][0] == simbolo) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int player1L = 0;
        int player1C = 0;
        int player2L = 0;
        int player2C = 0;
        boolean entradaV;
        System.out.println("========JOGO DA VELHA========");
        tabuleiro();
        for (int i = 0; i < 5; i++) {
            do {
                entradaV = false;
                try {
                    System.out.print("\nJogador 1 onde voce vai colocar o X?\nLinha:");
                    player1L = in.nextInt();
                    System.out.print("Coluna:");
                    player1C = in.nextInt();
                    entradaV = true;
                    if (jogo[player1L - 1][player1C - 1] != 0) {
                        System.out.println("Posicao ja ocupada, escolha novamente!!!");
                        entradaV = false;
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Entrada invalida! Por favor, digite um numero.");
                    in.nextLine();
                }
            }while (!entradaV);
            jogador1((player1L - 1), (player1C - 1));

            if (verificador('X')) {
                System.out.println("JOGADOR 1 GANHOU!!!");
                System.exit(0);
            }

            if (i == 4) {
                System.out.println("Deu velha :(");
                System.exit(0);
            }
            do {
                entradaV = false;
                try {
                    System.out.print("\nJogador 2 onde voce vai colocar o O?\nLinha:");
                    player2L = in.nextInt();
                    System.out.print("Coluna:");
                    player2C = in.nextInt();
                    entradaV = true;
                    if (jogo[player2L - 1][player2C - 1] != 0) {
                        System.out.println("Posicao ja ocupada, escolha novamente!!!");
                        entradaV = false;
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Entrada invalida! Por favor, digite um numero.");
                    in.nextLine();
                }
            }while (!entradaV);
            jogador2((player2L - 1), (player2C - 1));

            if (verificador('O')) {
                System.out.println("JOGADOR 2 GANHOU!!!");
                System.exit(0);
            }
        }
    }
}