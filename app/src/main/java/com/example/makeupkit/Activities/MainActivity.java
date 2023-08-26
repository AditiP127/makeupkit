package com.example.makeupkit.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.makeupkit.R;

public class MainActivity extends AppCompatActivity {
    public static final String DEFAULT = "N/A";
    EditText enterUserName, enterPassword;
    Button signUp;
    TextView newUser;
    CheckBox rememberMeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterUserName = (EditText) findViewById(R.id.userName);
        enterPassword = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.signUpBtn);
        newUser = (TextView) findViewById(R.id.registerButton);
        rememberMeBtn = (CheckBox) findViewById(R.id.rememberMeBtn);
        storedData();
    }

    public void storedData() {
        SharedPreferences sharedPreferences = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("emailToLogin", DEFAULT);
        String password = sharedPreferences.getString("passwordToLogin", DEFAULT);
        Boolean checked = sharedPreferences.getBoolean("isChecked", false);
        if (email.equals(DEFAULT) || password.equals(DEFAULT)) {
        } else {
            enterUserName.setText(email);
            enterPassword.setText(password);
            rememberMeBtn.setChecked(checked);
        }
    }

    private boolean validateEmail() {
        String enteredEmail;
        enteredEmail = enterUserName.getText().toString().trim();
        if (enteredEmail.isEmpty()) {
            enterUserName.setError(getString(R.string.fieldEmpty));
            return false;
        } else if (!enteredEmail.matches(getString(R.string.emailPattern))) {
            Toast.makeText(MainActivity.this, getString(R.string.validEmail), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            enterUserName.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String enteredPassword;
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        enteredPassword = enterPassword.getText().toString().trim();
        if (enteredPassword.isEmpty()) {
            enterPassword.setError(getString(R.string.fieldEmpty));
            return false;
        } else if (!enteredPassword.matches(passwordPattern)) {
            Toast.makeText(MainActivity.this, getString(R.string.validPassword), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            enterPassword.setError(null);
            return true;
        }
    }

    public void loginUser(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        if (!validateEmail() | !validatePassword()) {
            return;
        } else {
            if (rememberMeBtn.isChecked()) {
                Boolean remeberMe = rememberMeBtn.isChecked();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("emailToLogin", enterUserName.getText().toString());
                editor.putString("passwordToLogin", enterPassword.getText().toString());
                editor.putBoolean("isChecked", remeberMe);
                editor.commit();
            } else {
                sharedPreferences.edit().clear().apply();
            }
            Toast.makeText(MainActivity.this, getString(R.string.loginscuess), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, CategoriesOfProducts.class);
            startActivity(intent);
        }
    }

    public void goToRegistrationPage(View v) {
        Intent intent = new Intent(MainActivity.this, Registration.class);
        startActivity(intent);
    }
}