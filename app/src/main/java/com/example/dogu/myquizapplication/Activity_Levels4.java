package com.example.dogu.myquizapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dogu.myquizapplication.DbHelper.DbHelper;

public class Activity_Levels4 extends AppCompatActivity {


    LinearLayout start;
    String userID;
    TextView txtLimit;
    ImageView imgLock_Unlock;
    ImageView imgLock_Unlock1;
    ImageView imgLock_Unlock2;
    ImageView imgLock_Unlock3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__levels1);
        setTitle("Mühendislik Sınavı");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        start =(LinearLayout)findViewById(R.id.begin);

        imgLock_Unlock = findViewById(R.id.unlock1);
        txtLimit = (TextView)findViewById(R.id.txtLimit);
        imgLock_Unlock1 = findViewById(R.id.unlock2);
        imgLock_Unlock2 = findViewById(R.id.unlock3);
        imgLock_Unlock3 = findViewById(R.id.unlock4);
        imgLock_Unlock.setImageDrawable(getResources().getDrawable(R.drawable.ic_unlock));
        imgLock_Unlock1.setImageDrawable(getResources().getDrawable(R.drawable.ic_unlock));
        imgLock_Unlock2.setImageDrawable(getResources().getDrawable(R.drawable.ic_unlock));
        imgLock_Unlock3.setImageDrawable(getResources().getDrawable(R.drawable.ic_unlock));


        Intent iin= getIntent();
        Bundle b=iin.getExtras();
        final String tableName;
        if(b!=null){
            tableName=(String)b.get("table_name");
            userID=(String)b.get("user_id");
            Log.d("Table Name",tableName);

        }
        else
        {
            tableName="";
            userID="";

        }




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Main2ActivitySec4.class);
                i.putExtra("table_name",tableName);
                i.putExtra("user_id",userID);
                i.putExtra("level_name","B");
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        DbHelper db = new DbHelper(this);
        Log.e("OnResume","çalıştı");
        int ScoreCount = db.getMuhendislikScoreCount(userID);
        if (ScoreCount == 1){


            imgLock_Unlock.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));




        }else if(ScoreCount==2){

            imgLock_Unlock.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));



            imgLock_Unlock1.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));
        }
        else if (ScoreCount == 3){

            imgLock_Unlock.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));



            imgLock_Unlock1.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));



            imgLock_Unlock2.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));

        }
        if(ScoreCount > 3) {

            imgLock_Unlock1.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));


            imgLock_Unlock2.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));


            imgLock_Unlock3.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));


            imgLock_Unlock.setImageDrawable(getResources().getDrawable(R.drawable.ic_locked));

            txtLimit.setVisibility(View.VISIBLE);
            start.setEnabled(false);

        }

    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
