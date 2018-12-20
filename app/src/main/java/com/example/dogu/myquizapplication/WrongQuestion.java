package com.example.dogu.myquizapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.dogu.myquizapplication.Adapter.ListAdapter;
import com.example.dogu.myquizapplication.Model.ListModel;

import java.util.ArrayList;

public class WrongQuestion extends AppCompatActivity {

    public ArrayList<String> wrongQuests = new ArrayList<String>();
    public ArrayList<String> selectedAnswers = new ArrayList<String>();
    public ArrayList<String> actualAnswers = new ArrayList<String>();

    private ArrayList<ListModel> m_parts = new ArrayList<>();

    ListView listView;

    ResultsActivity resultActivity = new ResultsActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_question);

        listView = (ListView) findViewById(R.id.listView1);

        wrongQuests = resultActivity.wrongQuests;
        selectedAnswers = resultActivity.selectedAnswers;
        actualAnswers = resultActivity.actualAnswers;


        wrongQuests = getIntent().getStringArrayListExtra("wrongQuestions");
        selectedAnswers = getIntent().getStringArrayListExtra("selectedAnswer");
        actualAnswers = getIntent().getStringArrayListExtra("actualAnswer");

        String[] strQstn = new String[wrongQuests.size()];
        String[] strsAns = new String[selectedAnswers.size()];
        String[] straAns = new String[actualAnswers.size()];

        strQstn = wrongQuests.toArray(strQstn);
        strsAns = selectedAnswers.toArray(strsAns);
        straAns = actualAnswers.toArray(straAns);

        //Toast.makeText(getApplicationContext(), "ArrayList Size is "+ wrongQuests.size(), Toast.LENGTH_LONG).show();

        for(int i=0; i<strQstn.length;i++) {
            m_parts.add(new ListModel(strQstn[i], strsAns[i],straAns[i]));
        }

        ListAdapter listAdapter = new ListAdapter(this, R.layout.list_row, m_parts);
        listView.setAdapter(listAdapter);
    }

}