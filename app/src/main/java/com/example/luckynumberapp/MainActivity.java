package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


     EditText edit;
     Button btn;
     TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit=findViewById(R.id.edit);
        btn=findViewById(R.id.btn);
        text=findViewById(R.id.textView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=edit.getText().toString();
                Intent intent=new Intent(getApplicationContext(), secondActivity.class);

                intent.putExtra("name",userName);

                startActivity(intent);


            }
        });
    }
}