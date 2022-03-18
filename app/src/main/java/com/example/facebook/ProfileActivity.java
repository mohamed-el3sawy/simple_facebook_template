package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.facebook.adapters.PostAdapter;
import com.example.facebook.models.Post;
import com.example.facebook.models.User;

public class ProfileActivity extends AppCompatActivity {
    static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle extras = getIntent().getExtras();
        String id = extras.getString("id");

        for (User u: MainActivity.users) {
            if (u.getId().equals(id)){
                user = u;
            }
        }

        //displayFirstName();
        //displayLastName();

        TextView onClickPost = findViewById(R.id.profile_btn_post);
        onClickPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setPost(new Post(getPostText()));

                ListView listView = findViewById(R.id.profile_posts);

                PostAdapter postAdapter = new PostAdapter(ProfileActivity.this, user.getPosts(), user);

                listView.setAdapter(postAdapter);
            }
        });

    }

    private void displayFirstName(){
        //TextView firstName = findViewById(R.id.profile_txtview_firstname);
        //firstName.setText(user.getFirstName());
    }

    private void displayLastName(){
        //TextView lastName = findViewById(R.id.profile_txtview_lastname);
        //lastName.setText(user.getLastName());
    }

    private String getPostText(){
        EditText text = findViewById(R.id.profile_edt_txt_text);
        return text.getText().toString();
    }
}