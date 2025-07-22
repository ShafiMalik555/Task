package com.app.task;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class LoginActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText emailInput;
    EditText passwordInput;
    Button loginButton;
    TextView signup;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.username);
        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        loginButton = findViewById(R.id.btn_login);
        signup=findViewById(R.id.signup);

        loginButton.setOnClickListener(v -> {
            String username = usernameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter above all fields", Toast.LENGTH_SHORT).show();
            } else {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                Intent in=new Intent(this,MainActivity.class);
                in.putExtra("username",username);
                in.putExtra("email",email);
                startActivity(in);
                finish();
            }
        });

        signup.setOnClickListener(v->{
            startActivity(new Intent(this, SignupActivity.class));
        });

    }
}
