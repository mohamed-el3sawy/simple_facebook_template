package com.example.facebook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.facebook.R;
import com.example.facebook.models.Post;
import com.example.facebook.models.User;

import java.util.ArrayList;

public class PostAdapter extends BaseAdapter {
    Context context;
    ArrayList<Post> posts;
    User user;

    public PostAdapter(Context context, ArrayList<Post> posts, User user) {
        this.context = context;
        this.posts = posts;
        this.user = user;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Post getItem(int i) {
        return posts.get(getCount()-i-1);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View post = view;
        if (post == null){
            post = LayoutInflater.from(context).inflate(R.layout.post_layout, viewGroup, false);
        }

        Post p = getItem(i);

        TextView name = post.findViewById(R.id.postLayout_name);
        name.setText(user.getFirstName().concat(" ").concat(user.getLastName()));

        TextView date = post.findViewById(R.id.postLayout_date);
        date.setText(p.getDate());

        TextView text = post.findViewById(R.id.postLayout_text);
        text.setText(p.getText());

        return post;
    }
}
