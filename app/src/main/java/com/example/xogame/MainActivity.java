package com.example.xogame;

import static android.app.ProgressDialog.show;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
    ImageView xBtn,oBtn;

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int count=0;
    int flag=0;

    MediaPlayer mp;
    RelativeLayout relativeLayoutBackground;
    WinnerActivity winnerActivity;
    int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

       mp=MediaPlayer.create(MainActivity.this,R.raw.xo_game_sound_effect);

        idFind();

        xBtn.setImageResource(R.drawable.x_dark);
        oBtn.setImageResource(R.drawable.o_light);
        }//end of onCreate

        private void idFind()
        {
            btn1=findViewById(R.id.btn1);
            btn2=findViewById(R.id.btn2);
            btn3=findViewById(R.id.btn3);
            btn4=findViewById(R.id.btn4);
            btn5=findViewById(R.id.btn5);
            btn6=findViewById(R.id.btn6);
            btn7=findViewById(R.id.btn7);
            btn8=findViewById(R.id.btn8);
            btn9=findViewById(R.id.btn9);

            xBtn=(ImageView) findViewById(R.id.xBtn);
            oBtn=(ImageView) findViewById(R.id.oBtn);

            relativeLayoutBackground=(RelativeLayout) findViewById(R.id.relativeLayoutBackground);

        }
        //Button onClick method
        public void check(View view) {

            mp.start();

            if(flag==0) {
                xBtn.setImageResource(R.drawable.x_light);
                oBtn.setImageResource(R.drawable.o_dark);
            }else {

                oBtn.setImageResource(R.drawable.o_light);
                xBtn.setImageResource(R.drawable.x_dark);
            }

        Button btnCurrent = (Button) view;
            if (btnCurrent.getText().toString().equals("")) {
                count++;
                if (flag == 0) {
                    btnCurrent.setText("X");
                    flag = 1;
                } else {
                    btnCurrent.setText("O");
                    flag = 0;
                }
                if (count > 4) {
                    b1 = btn1.getText().toString();
                    b2 = btn2.getText().toString();
                    b3 = btn3.getText().toString();
                    b4 = btn4.getText().toString();
                    b5 = btn5.getText().toString();
                    b6 = btn6.getText().toString();
                    b7 = btn7.getText().toString();
                    b8 = btn8.getText().toString();
                    b9 = btn9.getText().toString();

                    //conditions
                    if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                        //1
                        winnerActivity=new WinnerActivity(MainActivity.this,"Winner is : "+b1,MainActivity.this);

                        winnerActivity.setCancelable(false);
                        winnerActivity.show();
                    } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                        //2
                        winnerActivity=new WinnerActivity(MainActivity.this,"Winner is : "+b4,MainActivity.this);

                        winnerActivity.setCancelable(false);
                        winnerActivity.show();
                    } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                       //3
                        winnerActivity=new WinnerActivity(MainActivity.this,"Winner is : "+b7,MainActivity.this);

                        winnerActivity.setCancelable(false);
                        winnerActivity.show();
                    } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                        //4
                        winnerActivity=new WinnerActivity(MainActivity.this,"Winner is : "+b1,MainActivity.this);

                        winnerActivity.setCancelable(false);
                        winnerActivity.show();
                    } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                        //5
                        winnerActivity=new WinnerActivity(MainActivity.this,"Winner is : "+b2,MainActivity.this);

                        winnerActivity.setCancelable(false);
                        winnerActivity.show();
                    } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                        //6
                        winnerActivity=new WinnerActivity(MainActivity.this,"Winner is : "+b3,MainActivity.this);

                        winnerActivity.setCancelable(false);
                        winnerActivity.show();
                    } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                        //7
                        winnerActivity=new WinnerActivity(MainActivity.this,"Winner is : "+b1,MainActivity.this);

                        winnerActivity.setCancelable(false);
                        winnerActivity.show();
                    } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                     //8
                        winnerActivity=new WinnerActivity(MainActivity.this,"Winner is : "+b3,MainActivity.this);

                        winnerActivity.setCancelable(false);
                        winnerActivity.show();
                    }
                    else if(count==9)
                    {

                        if(!btn1.equals(""))
                        {
                            winnerActivity=new WinnerActivity(MainActivity.this,"Draw",MainActivity.this);

                            winnerActivity.setCancelable(false);
                            winnerActivity.show();
                        }

                    }

                }

            }
        }


        public void newGame() {
            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
            btn5.setText("");
            btn6.setText("");
            btn7.setText("");
            btn8.setText("");
            btn9.setText("");
            count = 0;
            flag = 0;
            xBtn.setImageResource(R.drawable.x_dark);
            oBtn.setImageResource(R.drawable.o_light);

        }

       public void changeBackground(View view)
       {

           if(cnt==0) {
               relativeLayoutBackground.setBackgroundResource(R.drawable.back_one);
               cnt++;
           }
          else if (cnt==1) {
               relativeLayoutBackground.setBackgroundResource(R.drawable.back_two);
               cnt++;
           }
           else if (cnt==2) {
               relativeLayoutBackground.setBackgroundResource(R.drawable.back_three);
               cnt++;
           }
           else if (cnt==3) {
               relativeLayoutBackground.setBackgroundResource(R.drawable.back_four);
               cnt++;
           }
           else if (cnt==4) {
               relativeLayoutBackground.setBackgroundResource(R.drawable.back_five);
               cnt=0;
           }


       }

    Long onBackPressTime= 0L;
    @Override
    public  void onBackPressed() {
        if ( onBackPressTime+3000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(this, "Press back again to exit the game.", Toast.LENGTH_LONG).show();
        }
        onBackPressTime=System.currentTimeMillis();
    }


}



