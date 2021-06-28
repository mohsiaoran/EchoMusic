package cn.edu.fjzzit.echomusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.dbtext.UserDao;
import cn.edu.fjzzit.echomusic.entity.MyInfo;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private RadioButton agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.username_edit);
        password = findViewById(R.id.userpsd_edit);
        agree = findViewById(R.id.agreement_rbtn);

    }

    //用户根据点击事件来登录
    public void clicklogin(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String n = name.getText().toString().trim();
                String psw = password.getText().toString().trim();

                if (!agree.isChecked()){
                    Looper.prepare();
                    Toast agreeT = Toast.makeText(LoginActivity.this, "请同意用户协议！", Toast.LENGTH_SHORT);
                    agreeT.show();
                    Looper.loop();
                }

                if (n.equals("") || psw.equals("")) {
                    Looper.prepare();
                    Toast toast = Toast.makeText(LoginActivity.this, "输入不能为空！", Toast.LENGTH_SHORT);
                    toast.show();
                    Looper.loop();
                }
                UserDao ud = new UserDao();
                Boolean result = ud.login(n, psw);
                if (!result) {
                    Looper.prepare();
                    Toast toast = Toast.makeText(LoginActivity.this, "用户名不存在或密码错误！", Toast.LENGTH_SHORT);
                    toast.show();
                    Looper.loop();
                } else {
                    Looper.prepare();
                    Toast toast = Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent=new Intent(LoginActivity.this,EchoActivity.class);

                    UserDao userDao = new UserDao();
                    MyInfo myInfo = new MyInfo();
                    myInfo = userDao.getMyInfo(n);
                    //用Bundle携带数据
                    Bundle bundle=new Bundle();
                    //传递name参数
                    bundle.putSerializable("myInfo", myInfo);
                    intent.putExtras(bundle);

                    startActivity(intent);
                    Looper.loop();

                }

                //以上为jdbc登录
            }
        }).start();
    }

}