package com.terralogic.alexle.tictactoe.model;

/**
 * Created by alex.le on 7/11/2017.
 */

public class Board {
    private Cell[][] cells;
    private GameState state;
    private Player currentTurn;
    private Player winner;

    public Board() {
        restart();
    }

    public void restart() {
        clearCells();
        winner = null;
        currentTurn = Player.X;
        state = GameState.IN_PROGRESS;
    }

    private void clearCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Player mark(int row, int col) {
        Player movedPlayer = null;

        if (isValid(row, col)) {
            cells[row][col].setValue(currentTurn);
            movedPlayer = currentTurn;

            if (isWinningMoveByPlayer(currentTurn, row, col)) {
                state = GameState.FINISHED;
                winner = currentTurn;
            } else {
                flipCurrentTurn();
            }
        }

        return movedPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    private boolean isValid(int row, int col) {
        if (isOutOfBounds(row, col)) {
            return false;
        }
        if (isCellChecked(row, col)) {
            return false;
        }
        if (state == GameState.FINISHED) {
            return false;
        }
        return true;
    }

    private boolean isOutOfBounds(int row, int col) {
        return (row < 0 || row > 2 || col < 0 || col > 2);
    }

    private boolean isCellChecked(int row, int col) {
        return cells[row][col] != null;
    }

    private boolean isWinningMoveByPlayer(Player player, int currentRow, int currentCol) {
        if (cells[currentRow][0].getValue() == player || cells[currentRow][1].getValue() == player
                || cells[currentRow][2].getValue() == player) {//Horizontal check
            return true;
        } else if (cells[0][currentCol].getValue() == player || cells[1][currentCol].getValue() == player
                || cells[2][currentCol].getValue() == player) {//Vertical check
            return true;
        } else if (cells[0][0].getValue() == player || cells[1][1].getValue() == player
                || cells[2][2].getValue() == player) {
            return true;
        } else if (cells[0][2].getValue() == player || cells[1][1].getValue() == player
                || cells[2][0].getValue() == player) {
            return true;
        }
        return false;
    }

    private void flipCurrentTurn() {
        currentTurn = (currentTurn == Player.X ? Player.O : Player.X);
    }

    private enum GameState {
        IN_PROGRESS,
        FINISHED
    }
}
