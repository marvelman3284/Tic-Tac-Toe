package shah.jeevan;

import java.util.List;
import java.util.Random;


public class Algorithm {

    static void turn1(int idx, String[] board, List<Integer> used) {
        Random rand = new Random();
        int randomNum = rand.nextInt(9);
        switch (idx) {
            case 0 -> {
                board[8] = "O";
                used.add(8);
            }
            case 2 -> {
                board[6] = "O";
                used.add(6);
            }
            case 6 -> {
                board[2] = "O";
                used.add(2);
            }
            case 8 ->  {
                board[0] = "O";
                used.add(0);
            }
            default -> {
                board[randomNum] = "O";
                used.add(randomNum);
            }
        }
    }

    static void turn3(String[] board, List<Integer> used) {
        // Top Row
        if ((board[0] + board[1]).equals("XX") && !used.contains(2)) {
            board[2] = "O";
            used.add(2);
        } else if ((board[0] + board[2]).equals("XX") && !used.contains(1)) {
            board[1] = "O";
            used.add(1);
        } else if ((board[1] + board[2]).equals("XX") && !used.contains(0)) {
            board[0] = "O";
            used.add(0);
        }

        // Middle Row
        else if ((board[3] + board[4]).equals("XX") && !used.contains(5)) {
            board[5] = "O";
            used.add(5);
        } else if ((board[4] + board[5]).equals("XX") && !used.contains(3)) {
            board[3] = "O";
            used.add(3);
        } else if ((board[3] + board[5]).equals("XX") && !used.contains(4)) {
            board[4] = "O";
            used.add(4);
        }

        // Bottom Row
        else if ((board[6] + board[7]).equals("XX") && !used.contains(8)) {
            board[8] = "O";
            used.add(8);
        } else if ((board[6] + board[8]).equals("XX") && !used.contains(7)) {
            board[7] = "O";
            used.add(7);
        } else if ((board[7] + board[8]).equals("XX") && !used.contains(6)) {
            board[6] = "O";
            used.add(6);
        }

        // Left Vertical Row
        else if ((board[0] + board[3]).equals("XX") && !used.contains(6)) {
            board[6] = "O";
            used.add(6);
        } else if ((board[0] + board[6]).equals("XX") && !used.contains(3)) {
            board[3] = "O";
            used.add(3);
        } else if ((board[3] + board[6]).equals("XX") && !used.contains(0)) {
            board[0] = "O";
            used.add(0);
        }

        // Middle Vertical Row
        else if ((board[1] + board[4]).equals("XX") && !used.contains(7)) {
            board[7] = "O";
            used.add(7);
        } else if ((board[1] + board[7]).equals("XX") && !used.contains(4)) {
            board[4] = "O";
            used.add(4);
        } else if ((board[4] + board[7]).equals("XX") && !used.contains(1)) {
            board[1] = "O";
            used.add(1);
        }

        // Right Vertical Row
        else if ((board[2] + board[5]).equals("XX") && !used.contains(8)) {
            board[8] = "O";
            used.add(8);
        } else if ((board[2] + board[8]).equals("XX") && !used.contains(5)) {
            board[5] = "O";
            used.add(5);
        } else if ((board[5] + board[8]).equals("XX") && !used.contains(2)) {
            board[2] = "O";
            used.add(2);
        }

        // Left Right Up Diagonals
        else if ((board[0] + board[4]).equals("XX") && !used.contains(8)) {
            board[8] = "O";
            used.add(8);
        } else if ((board[0] + board[8]).equals("XX") && !used.contains(4)) {
            board[4] = "O";
            used.add(4);
        } else if ((board[4] + board[8]).equals("XX") && !used.contains(0)) {
            board[0] = "O";
            used.add(4);
        }

        // Left Right Down Diagonals
        else if ((board[2] + board[4]).equals("XX") && !used.contains(6)) {
            board[6] = "O";
            used.add(6);
        } else if ((board[2] + board[6]).equals("XX") && !used.contains(4)) {
            board[4] = "O";
            used.add(4);
        } else if ((board[4] + board[6]).equals("XX") && !used.contains(2)) board[2] = "O";
        else {
            if (!used.contains(0)) {
                board[0] = "O";
                used.add(0);
            }
            else if (!used.contains(2)) {
                board[2] = "O";
                used.add(2);
            }
            else if (!used.contains(4)) {
                board[4] = "O";
                used.add(4);
            }
            else if (!used.contains(8)) {
                board[8] = "O";
                used.add(8);
            }
            else {
                Random rand = new Random();
                int randomNum = rand.nextInt(9);
                if (used.contains(randomNum)) {
                    do {
                        randomNum = rand.nextInt(9);
                    } while (used.contains(randomNum));
                    board[randomNum] = "O";
                    used.add(randomNum);
                }
            }
        }
    }

    static void lastTurn(String[] board, List<Integer> used) {
        for (int i = 0; i<8; i++) {
            if (!used.contains(i)) {
                board[i] = "O";
                break;
            }
        }
    }
}
