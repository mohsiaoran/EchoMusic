package cn.edu.fjzzit.echomusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.dbtext.UserDao;

import static android.content.ContentValues.TAG;

public class RegisterActivity extends AppCompatActivity {
    private static  final  String TAG="RegisterActivity";
    private EditText name;
    private EditText password;
    private EditText confirmPassword;
    private RadioButton agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.register_username_text);
        password = findViewById(R.id.register_psd_text);
        confirmPassword = findViewById(R.id.register_psd_confirm);
        agree = findViewById(R.id.register_agreement);

        View logintext = findViewById(R.id.register_turn_login);
        logintext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        View hastext = findViewById(R.id.has_user);
        hastext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    //
/*    public void checkR(View v) {
        Log.i(TAG,agree.isChecked()+"****************");
        agree.setChecked(!agree.isChecked());
        Log.i(TAG,agree.isChecked()+"****************");
    *//*    if (agree.isChecked()){
            agree.setChecked(false);
            Log.i(TAG,agree.isChecked()+"****************");
        }else {
            agree.setChecked(true);
        }*//*

    }*/

    //用户根据点击事件来注册
    public void fun(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String n = name.getText().toString().trim();
                        String psw = password.getText().toString().trim();
                        String cf_psw = confirmPassword.getText().toString().trim();
                        if (n.equals("") || psw.equals("")) {
                            Looper.prepare();
                            Toast toast = Toast.makeText(RegisterActivity.this, "输入不能为空！", Toast.LENGTH_SHORT);
                            toast.show();
                            Looper.loop();
                        }

                        if (!psw.equals(cf_psw)){
                            Looper.prepare();
                            Toast cf = Toast.makeText(RegisterActivity.this, "密码不一样！", Toast.LENGTH_SHORT);
                            cf.show();
                            Looper.loop();
                        }

                        if (!agree.isChecked()){
                            Looper.prepare();
                            Toast agreeT = Toast.makeText(RegisterActivity.this, "请同意用户协议！", Toast.LENGTH_SHORT);
                            agreeT.show();
                            Looper.loop();
                        }

                        UserDao ud = new UserDao();
                        boolean result = ud.register(n, psw);
                        if (!result) {
                            Looper.prepare();
                            Toast toast = Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT);
                            toast.show();
                            Looper.loop();
                        }else {
                            Looper.prepare();
                            Toast toast2 = Toast.makeText(RegisterActivity.this, "注册失败！", Toast.LENGTH_SHORT);
                            toast2.show();
                            Looper.loop();
                        }
                        Log.i(TAG, "fun" + result);

                        //以上为jdbc注册
                    }
                }).start();

        }

}