package cn.edu.fjzzit.echomusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import cn.edu.fjzzit.echomusic.R;

public class LoginActivity extends AppCompatActivity {

    private EditText userNameEdt,pwdEdt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}