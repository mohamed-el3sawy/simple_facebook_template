package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.facebook.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<User> users = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(new User("ME","Mohamed", "Elesawy", "M@gmail.com", "hm"));

        TextView login = findViewById(R.id.login_btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User loginUser = new User(getUserPhoneOrEmail(), getUserPassword());
                for (User user: users) {
                    if (loginUser.getEmail().equals(user.getEmail()) && loginUser.getPassword().equals(user.getPassword())){
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        intent.putExtra("id", user.getId());
                        startActivity(intent);
                    }
                }
            }
        });

        TextView signin = findViewById(R.id.login_btn_create_new);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

    }

    private String getUserPhoneOrEmail(){
        EditText editText = findViewById(R.id.login_edt_txt_phone_or_email);
        return editText.getText().toString();
    }

    private String getUserPassword(){
        EditText editText = findViewById(R.id.login_edt_txt_password);
        return editText.getText().toString();
    }
}