package com.example.makeupkit.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.makeupkit.R;

public class Registration extends AppCompatActivity {
    EditText enterUserName, enterPassword, enterName;
    Button RegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        enterName = (EditText) findViewById(R.id.Name);
        enterUserName = (EditText) findViewById(R.id.userName);
        enterPassword = (EditText) findViewById(R.id.password);
        RegisterBtn = (Button) findViewById(R.id.RegisterBtn);
    }

    private boolean validateName() {
        String enteredName;
        enteredName = enterName.getText().toString().trim();
        if (enteredName.isEmpty()) {
            enterName.setError(getString(R.string.fieldEmpty));
            return false;
        } else if (!enteredName.matches(getString(R.string.namePattern))) {
            Toast.makeText(Registration.this, getString(R.string.validName), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            enterName.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String enteredEmail;
        enteredEmail = enterUserName.getText().toString().trim();
        if (enteredEmail.isEmpty()) {
            enterUserName.setError(getString(R.string.fieldEmpty));
            return false;
        } else if (!enteredEmail.matches(getString(R.string.emailPattern))) {
            Toast.makeText(Registration.this, getString(R.string.validEmail), Toast.LENGTH_SHORT).show();
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
            Toast.makeText(Registration.this, getString(R.string.validPassword), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            enterPassword.setError(null);
            return true;
        }
    }

    public void registerUser(View v) {
        if (!validateName() | !validateEmail() | !validatePassword()) {
            return;
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("emailToLogin", enterUserName.getText().toString());
            editor.putString("passwordToLogin", enterPassword.getText().toString());
            editor.commit();
            Toast.makeText(Registration.this, getString(R.string.registerScuess), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Registration.this, MainActivity.class);
            startActivity(intent);
        }
    }
}