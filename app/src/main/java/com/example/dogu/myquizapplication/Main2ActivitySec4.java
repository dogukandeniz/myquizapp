package com.example.dogu.myquizapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dogu.myquizapplication.DbHelper.DbHelper;
import com.example.dogu.myquizapplication.Model.QuestionMuhendislik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main2ActivitySec4 extends AppCompatActivity {

    List<QuestionMuhendislik> quesList1;
    public int score=0;
    int ctr1=0;
    QuestionMuhendislik currentQ1;
    TextView txtQuestion1;
    RadioGroup grp;
    RadioButton rda1, rdb1, rdc1, rdd1;
    Button butNext1;
    Random random1 = new Random();
    ArrayList<Integer> list = new ArrayList<Integer>();
    TextView textViewTime1;
    public ArrayList<String> wrongQuestListCompFunda = new ArrayList<String>();
    public ArrayList<String> selectedAnsCompFunda = new ArrayList<String>();
    public ArrayList<String> actualAnswerCompFunda = new ArrayList<String>();
    int number;
    ProgressBar progressBar;
    int progress = 1;
    String tableName="",catName="",userID="";
    TextView qstnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_sec3);
        qstnNo = (TextView)findViewById(R.id.qstnNo);

        Intent iin=getIntent();
        Bundle b=iin.getExtras();

        if(b!=null){
            tableName=(String)b.get("table_name");
            catName=(String)b.get("level_name");
            userID=(String)b.get("user_id");

            Log.d("Table Name",tableName);
            Log.d("Level Name",catName);
        }
        number=0;
        DbHelper db= new DbHelper(this);
        textViewTime1 = (TextView)findViewById(R.id.textViewTime);
        final Main2ActivitySec4.CounterClass timer = new Main2ActivitySec4.CounterClass(180000, 1000);
        timer.start();
        quesList1=db.getAllQuestions3(tableName,catName);
        for(int i=0;i<10;i++){
            while(true){
                int next = random1.nextInt(10);
                if(!list.contains(next))
                {
                    list.add(next);
                    break;
                }
            }
        }
        currentQ1=quesList1.get(list.get(ctr1));
        txtQuestion1=(TextView)findViewById(R.id.textView1);
        rda1=(RadioButton)findViewById(R.id.radio0);
        rdb1=(RadioButton)findViewById(R.id.radio1);
        rdc1=(RadioButton)findViewById(R.id.radio2);
        rdd1=(RadioButton)findViewById(R.id.radio3);
        butNext1=(Button)findViewById(R.id.Sign_In);
        setQuestionView();
        grp = (RadioGroup) findViewById(R.id.radioGroup1);
        butNext1.setEnabled(false);
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i== R.id.radio0 || i == R.id.radio1 || i==R.id.radio2 || i == R.id.radio3)
                    butNext1.setEnabled(true);
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(10);
        progressBar.setProgress(1);
        butNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper db = new DbHelper(getApplicationContext());
                db.deleteQuestionMuhendislik(currentQ1.getID3());
                progress = progress+1;
                progressBar.setProgress(progress);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                //Log.d("yourans", currentQ1.getANSWER1() + " " + answer.getText());
                if (currentQ1.getANSWER3().equals(answer.getText())) {
                    score++;
                    //Log.d("score", "Your score" + score1);
                }
                else
                {
                    wrongQuestListCompFunda.add(number, currentQ1.getQUESTION3());
                    selectedAnsCompFunda.add(number, answer.getText().toString());
                    actualAnswerCompFunda.add(number, currentQ1.getANSWER3());
                    number++;
                }
                grp.clearCheck();
                butNext1.setEnabled(false);
                if (ctr1 < 10) {
                    if (ctr1 == 10) {
                        butNext1.setText("End Test");
                    }
                    currentQ1 = quesList1.get(list.get(ctr1));

                    setQuestionView();
                } else {
                    timer.onFinish();
                    timer.cancel();
                }
            }
        });

    }

    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            textViewTime1.setText(hms);
        }

        @Override
        public void onFinish() {
            showResult();
        }
    }

    public void showResult(){
        Intent intent = new Intent(Main2ActivitySec4.this, ResultsActivity.class);
        Bundle b = new Bundle();
        b.putInt("scoreMuhendislik", score);//Your score
        b.putString("section",tableName);//Your table name
        b.putString("user_id",userID);//Your table name

        b.putString("category",catName);//Your category name
        intent.putStringArrayListExtra("wrongQuestions", wrongQuestListCompFunda);
        intent.putStringArrayListExtra("selectedAnswer", selectedAnsCompFunda);
        intent.putStringArrayListExtra("actualAnswer", actualAnswerCompFunda);
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
    }

    private void setQuestionView(){
        txtQuestion1.setText(currentQ1.getQUESTION3());
        rda1.setText(currentQ1.getOPTA3());
        rdb1.setText(currentQ1.getOPTB3());
        rdc1.setText(currentQ1.getOPTC3());
        rdd1.setText(currentQ1.getOPTD3());
        if(ctr1<10)
            qstnNo.setText("0" + ctr1 + "/10");
        else
            qstnNo.setText("" + ctr1+ "/10");
        ctr1++;

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        //Setting message manually and performing action on button click
        builder.setMessage("If you close all your progress would not be saved... Do you wish to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        //Creating dialog box
        AlertDialog alert = builder.create();

        alert.show();
    }
}
