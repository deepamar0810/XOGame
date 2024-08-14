package com.example.xogame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WinnerActivity extends Dialog {
    String message;
    MainActivity mainActivity;
    TextView winnerPlayer;
    Button startAgainBtn;

    public WinnerActivity(@NonNull Context context,String message,MainActivity mainActivity) {
        super(context);
        this.mainActivity=mainActivity;
        this.message=message;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        winnerPlayer=(TextView) findViewById(R.id.winnerPlayer);
        startAgainBtn=(Button) findViewById(R.id.startAgainBtn);

        winnerPlayer.setText(message);

        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.newGame();
                dismiss();
            }
        });

    }
}