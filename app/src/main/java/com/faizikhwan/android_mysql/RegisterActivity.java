package com.faizikhwan.android_mysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    //Log
    private static String TAG = "RegisterActivity";

    //UI
    private TextView firstNameTV, lastNameTV, usernameTV, passwordTV, confirmPasswordTV;
    private EditText firstNameET, lastNameET, usernameET, passwordET, confirmPasswordET;
    private Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Log.d(TAG, "onCreate: RegisterActivity");

        initComponent(); //Initialize components
        initOnClickListener(); //Initialize onClickListener
    }

    public void OnRegister(View view) {
        String firstName = firstNameET.getText().toString();
        String lastName = lastNameET.getText().toString();
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String confirmPassword = confirmPasswordET.getText().toString();
        String type = "register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, firstName, lastName, username, password);
    }

    /**
     * Define the UI.
     */
    private void initComponent()
    {
        Log.d(TAG, "initComponent");
        //Creating all object components
        firstNameTV = findViewById(R.id.firstNameTV);
        lastNameTV = findViewById(R.id.lastNameTV);
        usernameTV = findViewById(R.id.usernameTV);
        passwordTV = findViewById(R.id.passwordTV);
        confirmPasswordTV = findViewById(R.id.confirmPasswordTV);
        firstNameET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        confirmPasswordET = findViewById(R.id.confirmPasswordET);
        doneButton = findViewById(R.id.doneButton);
    }

    /**
     * Implementing OnClickListener for each button.
     */
    private void initOnClickListener()
    {
        Log.d(TAG, "initOnClickListener");
        doneButton.setOnClickListener(this);
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
            case R.id.doneButton:
                Log.d(TAG, "doneButton");
                OnRegister(v);
                break;
        }
    }
}
