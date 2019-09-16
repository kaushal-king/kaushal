package com.appsnipp.loginsamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.appsnipp.loginsamples.registration.Forgotpassword_form;
import com.appsnipp.loginsamples.registration.Registration;
import com.appsnipp.loginsamples.registration.password;

public class LoginActivity extends AppCompatActivity {
    TextView re;
    EditText no,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        re = (TextView) findViewById(R.id.regi);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, Registration.class);
                startActivity(i);

            }
        });
        no=(EditText) findViewById(R.id.mono);
        pass=(EditText) findViewById(R.id.password);

    }


    public void viewForgotPAssword(View view) {
        Intent i = new Intent(LoginActivity.this, Forgotpassword_form.class);
        startActivity(i);

    }

    public void login(View view) {
        String s1=no.getText().toString();
        String s2=pass.getText().toString();
        if (s1.isEmpty()){
            no.setError("enter mobile no");
        }
        if (s2.isEmpty()){
            pass.setError("enter pssword");
        }
    }
}
