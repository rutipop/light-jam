package com.example.lightjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signUpActivity extends AppCompatActivity {
    TextView sign;
    EditText user ;
    EditText pass ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sign = (TextView) findViewById(R.id.signupbtn);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO now you check with server if username is valid , if so, save the user+password
                // when finshed -> close this activity

                String userName = user.getText().toString();
                String password = pass.getText().toString();


                if ((! userName.isEmpty()) && (! password.isEmpty())){
                    finish();
                }



            }
        });
    }
}
