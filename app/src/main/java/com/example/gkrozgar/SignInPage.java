package com.example.gkrozgar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
        if(sp.contains("userName")) {
            Intent intent = new Intent(SignInPage.this, dashBoard.class);
            startActivity(intent);
        }
        setContentView(R.layout.activity_sign_in_page);

        TextView textView;
        Button button;
        textView=findViewById(R.id.login_register_btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RigisterPage.class);
                startActivity(intent);

            }
        });
        button=findViewById(R.id.login_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dashBoard.class);
                startActivity(intent);
            }
        });
    }

    public void profile(View v){
        EditText name = findViewById(R.id.login_mail);
        Intent intent = new Intent(SignInPage.this , dashBoard.class);
        intent.putExtra("name", name.getText().toString());
        startActivity(intent);
    }
}