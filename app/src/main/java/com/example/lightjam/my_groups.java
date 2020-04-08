package com.example.lightjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class my_groups extends AppCompatActivity  implements GroupRecyclerUtils.GroupClickCallback {
    private GroupRecyclerUtils.GroupAddapter addapter = new GroupRecyclerUtils.GroupAddapter();
    private TextView hello_message ;
    private TextView my_profile ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_groups);


        hello_message = findViewById(R.id.hello_msg);
        String meaage_to_show = "hello " + getIntent().getStringExtra("logged name");
        hello_message.setText(meaage_to_show);



        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(addapter);
        addapter.callback =this;





        List<Group> allMessagessss = new ArrayList<Group>();
        allMessagessss.add(new Group("the zebras","https://image.shutterstock.com/z/stock-vector-seamless-watermelons-pattern-vector-background-with-watercolor-watermelon-slices-599860784.jpg"));
        allMessagessss.add(new Group("kickass","https://image.shutterstock.com/image-vector/music-notes-song-melody-tune-600w-701307613.jpg"));
        allMessagessss.add(new Group("yo yo yo","https://image.shutterstock.com/image-vector/vector-engraving-illustration-honey-bee-600w-705234577.jpg"));
        allMessagessss.add(new Group("darlings","https://image.shutterstock.com/z/stock-vector-seamless-watermelons-pattern-vector-background-with-watercolor-watermelon-slices-599860784.jpg"));
        allMessagessss.add(new Group("beatels","https://image.shutterstock.com/image-vector/vector-engraving-illustration-honey-bee-600w-705234577.jpg"));
        allMessagessss.add(new Group("whoa","https://image.shutterstock.com/image-vector/vector-engraving-illustration-honey-bee-600w-705234577.jpg"));
        allMessagessss.add(new Group("la la land","https://image.shutterstock.com/image-vector/music-notes-song-melody-tune-600w-701307613.jpg"));
        allMessagessss.add(new Group("jazz","https://image.shutterstock.com/z/stock-vector-seamless-watermelons-pattern-vector-background-with-watercolor-watermelon-slices-599860784.jpg"));

        addapter.submitList(allMessagessss);


        my_profile = findViewById(R.id.my_profile_btn);
        my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), profile.class);
                intent.putExtra("profile url", "https://cdn2.iconfinder.com/data/icons/avatar-2/512/carla_girl-512.png");
                startActivity(intent);


            }
        });

    }

    @Override
    public void onGroupClick(Group message) {

    }
}
