package com.example.gkrozgar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RigisterPage extends AppCompatActivity {

    private String name, city, email, phone, password , referral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigister_page);
        TextView textView;
        textView=findViewById(R.id.register_login_btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignInPage.class);
                startActivity(intent);

            }
        });
        Button button;
        button=findViewById(R.id.register_btn);
        EditText first_name = findViewById(R.id.register_main_label);
        EditText last_name = findViewById(R.id.register_UserName);
        EditText City = findViewById(R.id.register_City);
        EditText _email = findViewById(R.id.email);
        EditText _phone = findViewById(R.id.phoneNumber);
        EditText _password = findViewById(R.id.register_Password);
        EditText confirm_password = findViewById(R.id.register_Password_again);
        EditText Referral = findViewById(R.id.register_Referral);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = (first_name.getText() + "" + last_name.getText());
                email = _email.getText().toString().trim();
                password = _password.getText().toString().trim();
                city = City.getText() + " ".trim();
                phone = _phone.getText().toString().trim();
                referral = Referral.getText().toString().trim();
                if (password.equals(confirm_password.getText().toString().trim())) {
                    if (first_name.getText().toString().equals("")) {
                        first_name.setError("Required");
                        first_name.setFocusable(true);
                    } else if (last_name.getText().toString().equals("")) {
                        last_name.setError("Required");
                        last_name.setFocusable(true);

                    } else if ((email.indexOf("@") == -1)) {
                        _email.setError("Invalid Format");
                        _email.setFocusable(true);

                    } else if (password.length() < 8) {
                        _password.setError("Atleast 8 Character Required");
                        _password.setFocusable(true);
                    } else if (city.equals("")) {
                        City.setError("Required");
                        City.setFocusable(true);

                    } else if (phone.equals("")) {
                        _phone.setError("Required");
                        _phone.setFocusable(true);

                    } else if (referral.equals("")) {
                        Referral.setError("Required");
                        Referral.setFocusable(true);

                    } else {
                        Intent intent = new Intent(getApplicationContext(), SignInPage.class);
                        startActivity(intent);
                        SharedPreferences sp = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("name", name);
                        editor.putString("userName", city);
                        editor.putString("email", email);
                        editor.putString("phoneNumber", phone);
                        editor.putString("password", password);
                        editor.commit();

                    }
                } else {
                    confirm_password.setError("Not Match");
                    confirm_password.setFocusable(true);
                }
            }
        });
    }
}