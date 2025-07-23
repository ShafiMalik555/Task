package com.app.task;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.task.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText S_username,S_email,S_password,S_repassword,S_phone;
    Button register;
    FirebaseAuth mAuth;
    DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_profile);

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();
        databaseRef = FirebaseDatabase.getInstance().getReference("Users");

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
            String phone=S_phone.getText().toString();

            if(TextUtils.isEmpty(username)||TextUtils.isEmpty(email)||TextUtils.isEmpty(password)
                    ||TextUtils.isEmpty(repassword)||TextUtils.isEmpty(phone)){
                Toast.makeText(this, "Fields are required", Toast.LENGTH_SHORT).show();
            }
            else if(!password.equals(repassword)){
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
            else{
                registerUser(username,email,password,phone);
            }
        });
    }

    private void registerUser(String username, String email, String password, String phone) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        String userId = mAuth.getCurrentUser().getUid();

                        User newUser = new User(username,email,phone);

                        // Store in Realtime Database
                        databaseRef.child(userId).setValue(newUser)
                                .addOnCompleteListener(dbTask -> {
                                    if(dbTask.isSuccessful()){
                                        Toast.makeText(SignupActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(SignupActivity.this, "Database Error: "+dbTask.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        Toast.makeText(SignupActivity.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
