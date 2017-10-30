package com.jdkgroup.atomic.Activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

import com.jdkgroup.atom.Atom;
import com.jdkgroup.atomic.Validation.ErrorResponse;
import com.jdkgroup.atomic.Validation.Validation;
import com.jdkgroup.atomic.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.editText_username);
        final EditText passwordEditText = findViewById(R.id.editText_password);
        passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());

        Validation.with().validationType(Validation.PASSWORD).as(ErrorResponse.class).setCallback((e) -> {
            System.out.println("Tag" + e);
        });

        Validation.with().validationType(Validation.EMAIL).as(ErrorResponse.class).setCallback((e) -> {
            System.out.println("Tag" + e);
        });

        findViewById(R.id.button_login).setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            LoginRequest loginRequest = new LoginRequest(username, password);

            Atom.with(LoginActivity.this)
                    .load("https://reqres.in/api/login")
                    .setJsonPojoBody(loginRequest)
                    .as(LoginResponse.class)
                    .setCallback((e, result) -> {
                        if (e != null) {
                            e.printStackTrace();
                        } else if (result.token != null) {
                            Snackbar.make(v, "Pass : " + result.token, Snackbar.LENGTH_LONG).show();
                        } else if (result.error != null) {
                            Snackbar.make(v, "Fail : " + result.error, Snackbar.LENGTH_LONG).show();
                        }
                    });
            usernameEditText.setText(null);
            passwordEditText.setText(null);
        });
    }
}
