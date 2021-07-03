package cn.edu.fjzzit.echomusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.fjzzit.echomusic.R;

public class CompositionActivity extends AppCompatActivity {
    private Button returnBtn;
    private TextView toToturial;
    private TextView toHall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composition);

        returnBtn = findViewById(R.id.return_btn);
        toToturial=findViewById(R.id.composition_toturial_tv);
        toHall = findViewById(R.id.composition_hall_tv);

        toToturial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CompositionActivity.this, ToturialActivity.class);
                CompositionActivity.this.startActivity(intent);
            }
        });

        toHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CompositionActivity.this,HallActivity.class);
                CompositionActivity.this.startActivity(intent);
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
