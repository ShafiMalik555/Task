package com.app.task;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText S_username,S_email,S_password,S_repassword,S_phone;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_profile);

        S_username=findViewById(R.id.signup_username);
        S_email=findViewById(R.id.signup_email);
        S_password=findViewById(R.id.signup_password);
        S_repassword=findViewById(R.id.signup_confirm_password);
        S_phone=findViewById(R.id.signup_phone);
        register=findViewById(R.id.btn_register);

        register.setOnClickListener(v->{
            String username=S_username.getText().toString();
            String email=S_email.getText().toString();
            String password=S_password.getText().toString();
            String repassword=S_repassword.getText().toString();
            String Phone=S_phone.getText().toString();

            if(TextUtils.isEmpty(username)||TextUtils.isEmpty(email)||TextUtils.isEmpty(password)
                    ||TextUtils.isEmpty(repassword)||TextUtils.isEmpty(Phone)){
                Toast.makeText(this, "Fields are required", Toast.LENGTH_SHORT).show();
            }
            else if(!password.equals(repassword)){
                Toast.makeText(this, "Password are Mismatch", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Register Sucessfull", Toast.LENGTH_SHORT).show();
                Intent in=new Intent(this, LoginActivity.class);
                startActivity(in);
                finish();
            }
        });

    }

}
