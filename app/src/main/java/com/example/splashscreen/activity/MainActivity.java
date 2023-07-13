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

public class MainActivity extends AppCompatActivity {

    EditText uName, uPassword, rePassword;
    Button signup,signin;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uName=(EditText) findViewById(R.id.userName);
        uPassword= (EditText) findViewById(R.id.password);
        rePassword=(EditText)findViewById(R.id.rePassword);
        signup= (Button) findViewById(R.id.registerBtn);
        signin=findViewById(R.id.signBtn);
        db=new DbHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= uName.getText().toString();
                String pass=uPassword.getText().toString();
                String repass=rePassword.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this,"Enter again",Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)){
                        Boolean checkUser= db.checkUserName(user);
                        if(checkUser==false){
                            Boolean insert= db.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this,"Register Successfully",Toast.LENGTH_SHORT).show();
                                Intent homeIntent= new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(homeIntent);}else{
                                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Already Exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Not Matched",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upIntent= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(upIntent);
            }
        });


    }
}