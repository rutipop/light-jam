package com.example.lightjam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.Query;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.UUID;




import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView signUpBtn;
    TextView loginBtn;
    String logged_user_name;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUpBtn =  findViewById(R.id.signupbtn);

        sp = getSharedPreferences("saved_username", Context.MODE_PRIVATE);
        loadNameFromSP();
        if (logged_user_name != null){
            //already logged in
            Intent intent = new Intent(this, my_groups.class);
            intent.putExtra("logged name", logged_user_name);
            startActivity(intent);

        }



        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), signUpActivity.class);
                startActivity(intent);


            }
        });


        loginBtn = findViewById(R.id.loginbtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO check with server if username + password are valid, if so, go to groups activity
                EditText writtenUser = findViewById(R.id.username);
                logged_user_name = (writtenUser.getText()).toString();
                saveUserNameToSP();
                Intent intent = new Intent(v.getContext(), my_groups.class);
                intent.putExtra("logged name", logged_user_name);
                startActivity(intent);


            }
        });

    }



    public  void  loadNameFromSP(){
        String result =sp.getString("saved_username",null);
        logged_user_name =result;

    }

    public void saveUserNameToSP(){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("saved_username", logged_user_name);
        editor.apply();

    }


}
