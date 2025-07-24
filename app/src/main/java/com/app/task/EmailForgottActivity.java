package com.app.task;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EmailForgottActivity extends AppCompatActivity {

    EditText email;
    Button send;

    @Override
   protected void  onCreate(Bundle saBundle ){
        super.onCreate(saBundle);

        setContentView(R.layout.activity_email);

        email=findViewById(R.id.email);
        send=findViewById(R.id.btn_send);

        send.setOnClickListener(v->{
            String email_for=email.getText().toString();
            String send_for=send.getText().toString();

            if(TextUtils.isEmpty(email_for)){
                Toast.makeText(this, "Email is Required", Toast.LENGTH_SHORT).show();
            }
            else{

            }
        });


    }

}
