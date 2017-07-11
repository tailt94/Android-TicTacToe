package com.terralogic.alexle.tictactoe.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.terralogic.alexle.tictactoe.R;
import com.terralogic.alexle.tictactoe.model.Board;
import com.terralogic.alexle.tictactoe.model.Player;

public class TicTacToeActivity extends AppCompatActivity {
    private static final String TAG = TicTacToeActivity.class.getName();

    private GridLayout gridButtons;
    private ViewGroup winnerViewGroup;
    private TextView winnerLabel;
    private Button buttonReset;
    Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);
        bindViews();

        board = new Board();
    }

    public void onCellClicked(View view) {
        Button button = (Button) view;

        String tag = button.getTag().toString();
        int row = Integer.parseInt(tag.substring(0, 1));
        int col = Integer.parseInt(tag.substring(1, 2));

        Log.i(TAG, "Check: row " + row + " - col " + col);

        Player movedPlayer = board.mark(row, col);

        if (movedPlayer != null) {
            button.setText(movedPlayer.toString());
            if (board.getWinner() != null) {
                winnerLabel.setText(movedPlayer.toString());
                winnerViewGroup.setVisibility(View.VISIBLE);
            }
        }
    }

    public void onButtonResetClicked(View view) {
        winnerViewGroup.setVisibility(View.INVISIBLE);
        winnerLabel.setText("");

        board.restart();

        for (int i = 0; i < gridButtons.getChildCount(); i++) {
            ((Button) gridButtons.getChildAt(i)).setText("");
        }
    }

    private void bindViews() {
        gridButtons = (GridLayout) findViewById(R.id.grid_buttons);
        winnerViewGroup = (ViewGroup) findViewById(R.id.viewgroup_winner_viewer);
        winnerLabel = (TextView) findViewById(R.id.winnerPlayerLabel);
        buttonReset = (Button) findViewById(R.id.btn_reset);
    }

}
