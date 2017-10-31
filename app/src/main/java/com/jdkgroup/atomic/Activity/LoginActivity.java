package com.jdkgroup.atomic.Activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jdkgroup.atom.Atom;
import com.jdkgroup.atomic.CountryCode.CountryCode;
import com.jdkgroup.atomic.R;
import com.jdkgroup.atomic.CountryCode.ModelCountry;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.editText_username);
        final EditText passwordEditText = findViewById(R.id.editText_password);
        passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());

        CountryCode.with().countryCodeTypeType(CountryCode.COUNTRY).as().setCallback((result) -> {
            Gson gson = new Gson();
            List<ModelCountry> list = gson.fromJson(result, new TypeToken<List<ModelCountry>>(){}.getType());
            System.out.println("Tag" + list.size());
        });

        CountryCode.with().countryCodeTypeType(CountryCode.COUNTRY_CODE).as().setCallback((result) -> {
            System.out.println("Tag" + result);

        });

        com.jdkgroup.atomic.CountryCodeNew.Atom.with().type(1).as(ModelCountry.class).setCallback((List<ModelCountry> result) -> {
            System.out.println("Tag" +result.get(0).getCode());
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
