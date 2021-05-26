package cn.edu.fjzzit.echomusic.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.fjzzit.echomusic.R;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn,regBtn,visitorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        loginBtn = findViewById(R.id.login_btn);
        regBtn = findViewById(R.id.reg_btn);
        visitorBtn = findViewById(R.id.visitor_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        visitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, EchoActivity.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });
    }
}