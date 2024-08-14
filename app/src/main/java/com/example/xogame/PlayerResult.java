package com.example.xogame;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class PlayerResult extends AppCompatActivity {

    SQLiteDatabase db;
    TableLayout tableLayout;

    TableRow tableRow;

    Button makeRowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_player_result);
       tableLayout=(TableLayout) findViewById(R.id.tableLayout);
       tableRow=(TableRow)findViewById(R.id.tableRow);
       makeRowBtn= (Button) findViewById(R.id.makeRowBtn);
        makeRowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView playerIDTxt=new TextView(PlayerResult.this);
                playerIDTxt.setText("hello");
                TextView playerXTxt=new TextView(PlayerResult.this);
                TextView playerOTxt=new TextView(PlayerResult.this);
                TextView winnerTxt=new TextView(PlayerResult.this);

                tableRow=new TableRow(PlayerResult.this);
                tableRow.addView(playerIDTxt);
                tableRow.addView(playerXTxt);
                tableRow.addView(playerOTxt);
                tableRow.addView(winnerTxt);


                tableLayout.addView(tableRow);


            }
        });


/*

       db=openOrCreateDatabase("xoDatabase.sql",MODE_PRIVATE,null);
        Cursor c=db.rawQuery("SELECT * FROM playerRecord",null);

        while(c.moveToNext())
        {

            TableRow tableRow=(TableRow)findViewById(R.id.tableRow);
            Toast.makeText(PlayerResult.this,"Inside ",Toast.LENGTH_SHORT).show();
            int id =c.getInt(0);
           String playerX= c.getString(1);
           String playerO=c.getString(2);
           String result=c.getString(3);

         TextView   playerIDTxt=(TextView) findViewById(R.id.playerIDTxt);
           String idStr=Integer.toString(id);
          playerIDTxt.setText(idStr);

          TextView  playerXTxt=(TextView) findViewById(R.id.playerXTxt);
           playerXTxt.setText(playerX);

         TextView  playerOTxt=(TextView) findViewById(R.id.playerOTxt);
            playerOTxt.setText(playerO);

        TextView winnerTxt=(TextView) findViewById(R.id.winnerTxt);
            winnerTxt.setText(result);



          //  tableRow.addView(playerIDTxt);
         //   tableRow.addView(playerXTxt);
       //     tableRow.addView(playerOTxt);
     //       tableRow.addView(winnerTxt);
        //  tableLayout.removeView(tableRow);
      //    tableLayout.addView(tableRow);
        }
        c.close();*/





    }
}