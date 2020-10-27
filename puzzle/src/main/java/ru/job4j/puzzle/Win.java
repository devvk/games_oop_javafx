package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (checkColumn(board, i) || checkRow(board, j)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    public static boolean checkColumn(int[][] board, int column) {
        boolean rsl = true;
        for (int[] ints : board) {
            if (ints[column] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkRow(int[][] board, int row) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
