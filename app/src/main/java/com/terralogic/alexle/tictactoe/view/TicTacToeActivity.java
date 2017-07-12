package com.terralogic.alexle.tictactoe.view;

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
import com.terralogic.alexle.tictactoe.presenter.TicTacToePresenter;

public class TicTacToeActivity extends AppCompatActivity implements TicTacToeView {
    private static final String TAG = TicTacToeActivity.class.getName();

    private GridLayout gridButtons;
    private ViewGroup winnerViewGroup;
    private TextView winnerLabel;
    private Button buttonReset;

    TicTacToePresenter presenter = new TicTacToePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);
        bindViews();

        presenter.onCreate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void onCellClicked(View view) {
        Button button = (Button) view;

        String tag = button.getTag().toString();
        int row = Integer.parseInt(tag.substring(0, 1));
        int col = Integer.parseInt(tag.substring(1, 2));

        Log.i(TAG, "Check: row " + row + " - col " + col);

        presenter.onButtonSelected(row, col);
    }

    public void onButtonResetClicked(View view) {
        presenter.onResetSelected();
    }

    private void bindViews() {
        gridButtons = (GridLayout) findViewById(R.id.grid_buttons);
        winnerViewGroup = (ViewGroup) findViewById(R.id.viewgroup_winner_viewer);
        winnerLabel = (TextView) findViewById(R.id.winnerPlayerLabel);
        buttonReset = (Button) findViewById(R.id.btn_reset);
    }

    @Override
    public void showWinner(String winningPlayerDisplayLabel) {
        winnerLabel.setText(winningPlayerDisplayLabel);
        winnerViewGroup.setVisibility(View.VISIBLE);
    }

    @Override
    public void clearWinnerDisplay() {
        winnerViewGroup.setVisibility(View.INVISIBLE);
        winnerLabel.setText("");
    }

    @Override
    public void clearButtons() {
        for (int i = 0; i < gridButtons.getChildCount(); i++) {
            ((Button) gridButtons.getChildAt(i)).setText("");
        }
    }

    @Override
    public void setButtonLabel(int row, int col, String text) {
        Button btn = (Button) gridButtons.findViewWithTag("" + row + col);
        if (btn != null) {
            btn.setText(text);
        }
    }
}
