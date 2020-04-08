package com.example.lightjam;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.squareup.picasso.Picasso;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



//        String img_url ="https://cdn2.iconfinder.com/data/icons/avatar-2/512/carla_girl-512.png";

        ImageView profilPicture = findViewById(R.id.profile_pic);
//        Picasso.get().load(getIntent().getStringExtra("profile url")).into(profilPicture);
//        Picasso.get().load("https://image.shutterstock.com/z/stock-vector-seamless-watermelons-pattern-vector-background-with-watercolor-watermelon-slices-599860784.jpg").into(profilPicture);
//        profilPicture.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.lightjamicon2));

        Picasso.get().setLoggingEnabled(true);
        Picasso.get().load("https://image.shutterstock.com/z/stock-vector-seamless-watermelons-pattern-vector-background-with-watercolor-watermelon-slices-599860784.jpg")
                .resize(500,500)
                .into(profilPicture);

//glide option:

//        // Create glide request manager
//        RequestManager requestManager = Glide.with(this);
//        // Create request builder and load image.
//        RequestBuilder requestBuilder = requestManager.load("https://image.shutterstock.com/z/stock-vector-seamless-watermelons-pattern-vector-background-with-watercolor-watermelon-slices-599860784.jpg");
//        // Show image into target imageview.
//        requestBuilder.into(profilPicture);


        TextView goBack = findViewById(R.id.go_back_from_profile);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });

    }
}
