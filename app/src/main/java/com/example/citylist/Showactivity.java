package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showactivity);
        Intent intent= getIntent();
        String a=intent.getStringExtra("jami");
        TextView textView= findViewById(R.id.ShowActivityTextView);
        textView.setText(a);
        Button button= findViewById(R.id.ShowActivityButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(Showactivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}