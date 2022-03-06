package com.example.brain_trained;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    int[] answers= {-1,-1,-1,-1};
    TextView result;
    TextView scoreView;
    TextView timerTextView;
    int correct_location=-1;
    TextView textView;
    int score=0;
    int NofQues=0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgain;
  //  Button goButton;
    public void  playAgain(View view){
        result.setVisibility(View.VISIBLE);
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        newQuestions();
        score=0;
        NofQues=0;
        timerTextView.setText(Integer.toString(30) + "s");
        scoreView.setText(Integer.toString(score) + "/" + Integer.toString(NofQues));
        playAgain.setVisibility(View.INVISIBLE);
        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                result.setText("DONE !!!!");
                result.setBackgroundColor(Color.parseColor("white"));
                playAgain.setVisibility(View.VISIBLE);
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);

            }
        }.start();

    }
    public void  newQuestions(){
        result.setVisibility(View.VISIBLE);
        textView = (TextView) findViewById(R.id.sumTextView);
        Random rand= new Random();
        int num1 = rand.nextInt(21);
        int num2= rand.nextInt(22);
        textView.setText(Integer.toString(num1)+"+"+Integer.toString(num2));
        correct_location = rand.nextInt(4);
        answers[0]=-1;
        answers[1]=-1;
        answers[2]=-1;
        answers[3]=-1;
        for(int i=0;i<4;i++){
            if(i==correct_location){
                answers[i]=(num1+num2);
            }
            else{
                int wrong=rand.nextInt(44);
                while(wrong==(num1+num2)) {
                    wrong=rand.nextInt(44);
                }
                answers[i]=(wrong);
            }
        }
        button0.setText(Integer.toString(answers[0]));
        button1.setText(Integer.toString(answers[1]));
        button2.setText(Integer.toString(answers[2]));
        button3.setText(Integer.toString(answers[3]));
    }
    public void chooseAnswers(View view){
        result.setVisibility(View.VISIBLE);
       if(view.getTag().toString().equals(Integer.toString(correct_location))){
           result.setText("CORRECT  :)");
           result.setBackgroundColor(Color.parseColor("green"));
           score++;
           NofQues++;
       }
       else{
           result.setText(" INCORRECT :( ");
           result.setBackgroundColor(Color.parseColor("red"));
           NofQues++;
       }
       scoreView.setText(Integer.toString(score) + "/" + Integer.toString(NofQues));
        correct_location=-1;
        newQuestions();

    }
    public void goButton(View view)
    {
        button.setVisibility(View.INVISIBLE);
    }

//Override meaning onCreate already exist in AppCombatActivity and we are just using it further.Not creating onCreate just adding
// to it
//you can save the state of the application by using Bundle savedInstanceState
//super here refer to function that already exist
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button=(Button) findViewById(R.id.Gobutton);

        button0=(Button) findViewById(R.id.button0);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);

        scoreView = (TextView) findViewById(R.id.scoreTextView);
        result=(TextView) findViewById(R.id.textView4);
        timerTextView=(TextView) findViewById(R.id.timerTextView);

        playAgain=(Button) findViewById(R.id.button);
        //goButton=playAgain=(Button) findViewById(R.id.Gobutton);
        //goButton.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.timerTextView));
        result.setVisibility(View.INVISIBLE);

    }
}

//this main() method is involved in setting up the Android app environment. As far as a developer is concerned, the starting
// point is the onCreate() method of the Launcher activity.

//A PACKAGE- is basically the directory (folder) in which the source code resides.

//Here we take all the code and variable in AppCompactActivity and allow us to use it in MainActivity