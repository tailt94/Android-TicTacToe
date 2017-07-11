package com.terralogic.alexle.tictactoe.presenter;

import com.terralogic.alexle.tictactoe.model.Board;
import com.terralogic.alexle.tictactoe.model.Player;
import com.terralogic.alexle.tictactoe.view.TicTacToeView;

/**
 * Created by alex.le on 7/11/2017.
 */

public class TicTacToePresenter implements Presenter {
    private TicTacToeView view;
    private Board model;

    public TicTacToePresenter(TicTacToeView view) {
        this.view = view;
        this.model = new Board();
    }

    @Override
    public void onCreate() {
        this.model = new Board();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onButtonSelected(int row, int col) {
        Player movedPlayer = model.mark(row, col);

        if (movedPlayer != null) {
            view.setButtonLabel(row, col, movedPlayer.toString());

            if (model.getWinner() != null) {
                view.showWinner(movedPlayer.toString());
            }
        }
    }

    public void onResetSelected() {
        view.clearWinnerDisplay();
        view.clearButtons();
        model.restart();
    }
}
