package com.app.task;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    EditText emailInput, nameInput, phoneInput, addressInput;
    Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        emailInput = view.findViewById(R.id.input_email);
        nameInput = view.findViewById(R.id.input_name);
        phoneInput = view.findViewById(R.id.input_phone);
        addressInput = view.findViewById(R.id.input_address);
        submitButton = view.findViewById(R.id.btn_submit);

        submitButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            String name = nameInput.getText().toString();
            String phone = phoneInput.getText().toString();
            String address = addressInput.getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(name)) {
                Toast.makeText(getActivity(), "Email and Name are required", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Form Submitted Successfully", Toast.LENGTH_SHORT).show();
                // Optionally: Save to SharedPreferences or send to server
            }
        });

        return view;
    }
}


