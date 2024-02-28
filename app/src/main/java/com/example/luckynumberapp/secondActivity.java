package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class secondActivity extends AppCompatActivity {


    TextView welcometext,lucky_number_text;
    Button share_btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        welcometext=findViewById(R.id.textView2);
        lucky_number_text=findViewById(R.id.luckynumbertext);
        share_btn=findViewById(R.id.share_btn);

        Intent i=getIntent();
        String user=i.getStringExtra("name");

        int randomnum=randomnumbers();
        lucky_number_text.setText(""+randomnum);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedata(user,randomnum);
            }
        });



    }

    public int randomnumbers(){
        Random random=new Random();
        int upper_limit=1000;

        int randomnumbergenerated=random.nextInt(upper_limit);
        return randomnumbergenerated;
    }

    public void sharedata(String username,int random){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,username+"got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"his lucky number is "+random);

        startActivity(Intent.createChooser(i,"choose a platform"));

    }
}