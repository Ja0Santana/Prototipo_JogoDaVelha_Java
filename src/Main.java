import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final char [][] jogo = new char [3][3];
    public static void tabuleiro () {
        for (int i = 0; i < jogo.length; i++) {
            for (int j = 0; j < jogo[i].length; j++) {
                if (jogo[i][j] == 0) {
                    System.out.print("[ ]");
                }else {
                    System.out.printf("[%c]", jogo[i][j]);
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
    public static void vencedor (int  l, int c) {
        if (jogo[l][c] == 'X') {
            System.out.println("JOGADOR 1 GANHOU!!!");
            System.exit(0);
        }else if (jogo[l][c] == 'O')  {
            System.out.println("JOGADOR 2 GANHOU!!!");
            System.exit(0);
        }
    }
    public static void verificador() {
        for (int i = 0; i < 3; i++) {
            if (jogo[i][0] == jogo[i][1] && jogo[i][1] == jogo[i][2] && jogo[i][0] != 0) {
                vencedor(i, 0);
            }
        }
        for (int j = 0; j < 3; j++) {
            if (jogo[0][j] == jogo[1][j] && jogo[1][j] == jogo[2][j] && jogo[0][j] != 0) {
                vencedor(0, j);
            }
        }
        if (jogo[0][0] == jogo[1][1] && jogo[1][1] == jogo[2][2] && jogo[0][0] != 0) {
            vencedor(0, 0);
        }else if (jogo[2][0] == jogo[1][1] && jogo[1][1] == jogo[0][2] && jogo[2][0] != 0) {
            vencedor(1, 1);
        }
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

            verificador();

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

            verificador();
        }
    }
}