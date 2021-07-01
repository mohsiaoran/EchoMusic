package cn.edu.fjzzit.echomusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.edu.fjzzit.echomusic.R;

//import com.haibin.calendarview.Calendar;
//import com.haibin.calendarview.CalendarLayout;
//import com.haibin.calendarview.CalendarView;

public class PlanActivity extends AppCompatActivity{
    private ImageView returnImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        returnImg = findViewById(R.id.return_img);


        returnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
