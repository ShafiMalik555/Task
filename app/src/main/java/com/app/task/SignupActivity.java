package com.app.task;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.task.Data.User;
import com.app.task.network.ApiClient;
import com.app.task.network.ApiService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            else {
                User user = new User(username, email, password, repassword, Phone);
                ApiService apiService = ApiClient.getClient().create(ApiService.class);
                Call<ResponseBody> call = apiService.signup(user);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                String result = response.body().string();
                                Toast.makeText(SignupActivity.this, result, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                String error=response.errorBody().string();
                                Toast.makeText(SignupActivity.this, error, Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                               Log.e("Error","Failed");

                            }
//                            Toast.makeText(SignupActivity.this,"Bad request",Toast.LENGTH_SHORT).show();
                       }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(SignupActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("LoginFragment", "Network error: " + t.getMessage());
                    }
                });

            }
        });
    }
}

