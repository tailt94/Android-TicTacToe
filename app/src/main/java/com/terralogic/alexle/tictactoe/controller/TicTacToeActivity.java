package com.terralogic.alexle.tictactoe.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.terralogic.alexle.tictactoe.R;

public class TicTacToeActivity extends AppCompatActivity {
    private GridLayout gridButtons;
    private TextView tvPlayerLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);
        bindViews();


    }

    public void onCellClicked(View view) {
        Button button = (Button) view;
    }

    private void bindViews() {
        gridButtons = (GridLayout) findViewById(R.id.grid_buttons);
        tvPlayerLabel = (TextView) findViewById(R.id.winnerPlayerLabel);
    }

    private void reset() {

    }
}
