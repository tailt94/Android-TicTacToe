package com.terralogic.alexle.tictactoe.view;

/**
 * Created by alex.le on 7/11/2017.
 */

public interface TicTacToeView {
    void showWinner(String winningPlayerDisplayLabel);
    void clearWinnerDisplay();
    void clearButtons();
    void setButtonLabel(int row, int col, String text);
}
