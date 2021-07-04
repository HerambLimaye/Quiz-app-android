package com.example.herambalimaye.androidadvance;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

              int[] answers={1,1,1,1};

              int correct=0,numberOfQ=0;

            int correctAnsLoc;

            TextView result;
           Button start;
            TextView scoreView;
            Button ansOne;
            Button ansTwo;
            Button ansThree;
            Button ansFour;
            TextView queView;
            TextView timerView;
            Button playAgain;
            ConstraintLayout game;

           public void ans(View view){

               if(Integer.toString(correctAnsLoc).equals(view.getTag().toString()))
               {
                   Log.i("answer is","correct");
                   String Correct="CORRECT!";
                   result.setText(Correct);
                   correct++;
               }
               else
               {
                   Log.i("wrong","sorry");
                   String Wrong="WRONG!:(";
                   result.setText(Wrong);
               }

               numberOfQ++;
               String scoreIs=Integer.toString(correct)+"/"+Integer.toString(numberOfQ);
               scoreView.setText(scoreIs);

               newQuestion();
           }

          public void start(View view){

             start.setVisibility(View.INVISIBLE);
              playAgain(findViewById(R.id.scoreView));
              game=findViewById(R.id.game);
              game.setVisibility(View.VISIBLE);



          }

          public void playAgain(View view){

              correct=0;
              numberOfQ=0;
              String newTime="30S";
              timerView.setText(newTime);
              newQuestion();
              String scoreIs=Integer.toString(correct)+"/"+Integer.toString(numberOfQ);
              scoreView.setText(scoreIs);
              playAgain.setVisibility(View.INVISIBLE);
              result.setText("");

              new CountDownTimer(30100,1000)
              {

                  @Override
                  public void onTick(long millisUntilFinished) {

                      String timeRemaining=String.valueOf(millisUntilFinished/1000)+"s";
                      timerView.setText(timeRemaining);
                  }

                  @Override
                  public void onFinish() {
                      String over="FINISHED!";
                      result.setText(over);
                      playAgain.setVisibility(View.VISIBLE);
                  }
              }.start();
          }

          public void newQuestion()
          {
              Random rand0=new Random();

              int a=rand0.nextInt(21);//rand0
              int b=rand0.nextInt(21);//rand0
              char c='+';
              String que=Integer.toString(a)+c+Integer.toString(b);

              queView.setText(que);


              correctAnsLoc=rand0.nextInt(4);//rand2



              for(int i=0;i<4;i++)
              {
                  answers[i]=30;
                  if(i==correctAnsLoc)
                  {
                      answers[i]=a+b;
                  }
                  else
                  {
                      int wrongAnswer=rand0.nextInt(41);//rand3

                      while(wrongAnswer==(a+b))
                      {
                          wrongAnswer=rand0.nextInt(41);//rand3
                      }
                      answers[i]=wrongAnswer;
                  }
              }

              String one=Integer.toString(answers[0]),two=Integer.toString(answers[1]),three=Integer.toString(answers[2]),four=Integer.toString(answers[3]);
              ansOne.setText(one);
              ansTwo.setText(two);
              ansThree.setText(three);
              ansFour.setText(four);

          }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queView= findViewById(R.id.queView);
        scoreView=findViewById(R.id.scoreView);
        result= findViewById(R.id.result);

         ansOne= findViewById(R.id.ansOne);
         ansTwo= findViewById(R.id.ansTwo);
         ansThree= findViewById(R.id.ansThree);
         ansFour= findViewById(R.id.ansFour);

          start= findViewById(R.id.start);

          timerView= findViewById(R.id.timeView);
          playAgain= findViewById(R.id.playAgain);





    }
}
