package shah.jeevan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String[] board;
    public static List<Integer> used;

    public static void main(String[] args) {
        // write your code here
        board = new String[10];
        used = new ArrayList<>(10);
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            board[i] = Integer.toString(i);
        }
        drawBoard();
        // TODO: while true call x/oTurn then redraw the board
        for (int i = 0; i < 10; i++) {
            System.out.println("Turn:" + i);
            System.out.println("Where would you like to go? (0-8)");
            int place = sc.nextInt();
            drawX(place);
            used.add(place);
            if (i == 0) Algorithm.turn1(place, board, used);
            else if (i == 1 || i == 2 || i == 3) {
                Algorithm.turn3(board, used);
            } else if (i == 4 && !(checkWinner())) {
                Algorithm.lastTurn(board, used);
                drawBoard();
                System.out.println("Tie!");
                break;
            } else {
                Algorithm.lastTurn(board, used);
            }
            drawBoard();
            if (checkWinner()) break;
        }
    }

    // TODO: implement 'unbeatable' algo
    static void drawBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    static void drawX(int idx) {
        board[idx] = "X";
    }

    static boolean winnerCheck(int x, int y, int z, String[] board) {
        return (board[x] + board[y] + board[z]).equals("XXX") || (board[x] + board[y] + board[z]).equals("OOO");
    }

    static boolean checkWinner() {
        if (winnerCheck(0, 1, 2, board)) { // First Row Horizontal
            System.out.println("Winner!");
            return true;
        } else if (winnerCheck(3, 4, 5, board)) { // Second Row Horizontal
            System.out.println("Winner!");
            return true;
        } else if (winnerCheck(6, 7, 8, board)) { // Third Row Horizontal
            System.out.println("Winner!");
            return true;
        } else if (winnerCheck(0, 3, 6, board)) { // First Row Vertical
            System.out.println("Winner!");
            return true;
        } else if (winnerCheck(1, 4, 7, board)) { // Second Row Vertical
            System.out.println("Winner!");
            return true;
        } else if (winnerCheck(2, 5, 8, board)) { // Third Row Vertical
            System.out.println("Winner!");
            return true;
        } else if (winnerCheck(0, 4, 8, board)) { // First Diagonal
            System.out.println("Winner!");
            return true;
        } else if (winnerCheck(6, 4, 2, board)) { // Second Diagonal
            System.out.println("Winner!");
            return true;
        } else {
            return false;
        }
    }
}
