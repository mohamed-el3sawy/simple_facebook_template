package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.facebook.models.User;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        TextView login = findViewById(R.id.signin_btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView signin = findViewById(R.id.signin_btn_signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstName = findViewById(R.id.signin_edt_txt_firstname);
                String first = firstName.getText().toString();

                EditText lastName = findViewById(R.id.signin_edt_txt_lastname);
                String last = lastName.getText().toString();

                EditText emailTV = findViewById(R.id.signin_edt_txt_phone_or_email);
                String email = emailTV.getText().toString();

                EditText passwordTV = findViewById(R.id.signin_edt_txt_password);
                String password = passwordTV.getText().toString();

                boolean isUsed = false;

                for (User u: MainActivity.users){
                    if (u.getEmail().equals(email)) {
                        Toast.makeText(SigninActivity.this, "The Email has been used", Toast.LENGTH_LONG).show();
                        isUsed = true;
                        break;
                    }
                }

                if (!isUsed){
                    User user = new User(last+first, first, last, email, password);
                    MainActivity.users.add(user);
                    Intent intent = new Intent(SigninActivity.this, ProfileActivity.class);
                    intent.putExtra("id", user.getId());
                    startActivity(intent);
                }

            }
        });

    }
}