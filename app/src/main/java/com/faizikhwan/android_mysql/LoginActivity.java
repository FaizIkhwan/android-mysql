package com.faizikhwan.android_mysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    //Log
    private static String TAG = "LoginActivity";

    //UI
    private TextView usernameTV, passwordTV;
    private EditText usernameET, passwordET;
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d(TAG, "onCreate: LoginActivity");

        initComponent(); //Initialize components
        initOnClickListener(); //Initialize onClickListener
    }

    public void OnLogin(View view) {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }

    /**
     * Define the UI.
     */
    private void initComponent()
    {
        Log.d(TAG, "initComponent");
        //Creating all object components
        usernameTV = findViewById(R.id.usernameTV);
        passwordTV = findViewById(R.id.passwordTV);
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
    }

    /**
     * Implementing OnClickListener for each button.
     */
    private void initOnClickListener()
    {
        Log.d(TAG, "initOnClickListener");
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    /**
     * OnClick method for each button.
     * @param v
     */
    public void onClick(View v)
    {
        Log.d(TAG, "onClick");
        switch (v.getId())
        {
            case R.id.loginButton:
                Log.d(TAG, "loginButton");
                OnLogin(v);
                break;
            case R.id.registerButton:
                Log.d(TAG, "registerButton");
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }
}
