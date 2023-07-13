package com.example.splashscreen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.splashscreen.DbHelper;
import com.example.splashscreen.R;

public class LoginActivity extends AppCompatActivity {

    EditText uName, uPassword;
    Button signInBtn;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uName = (EditText) findViewById(R.id.userName1);
        uPassword = (EditText) findViewById(R.id.password1);
        signInBtn=(Button) findViewById(R.id.signBtn1);

        db= new DbHelper(this);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= uName.getText().toString();
                String pass=uPassword.getText().toString();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this,"Enter again",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkUserPass= db.checkUserPassword(user,pass);
                    if (checkUserPass==true){
                        Toast.makeText(LoginActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                        Intent inIntent= new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(inIntent);
                    }else{
                        Toast.makeText(LoginActivity.this,"Invalid",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}