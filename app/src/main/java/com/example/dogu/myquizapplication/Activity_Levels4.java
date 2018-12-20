package com.example.dogu.myquizapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class Activity_Levels4 extends AppCompatActivity {

    LinearLayout start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__levels1);
        setTitle("Mühendislik Sınavı");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        start =(LinearLayout)findViewById(R.id.begin);

        Intent iin= getIntent();
        Bundle b=iin.getExtras();
        final String tableName;
        if(b!=null){
            tableName=(String)b.get("table_name");
            Log.d("Table Name",tableName);
        }
        else
        {
            tableName="";
        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Main2ActivitySec4.class);
                i.putExtra("table_name",tableName);
                i.putExtra("level_name","B");
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
