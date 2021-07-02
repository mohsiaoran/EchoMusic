package cn.edu.fjzzit.echomusic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.ChosenAdapter;
import cn.edu.fjzzit.echomusic.adapter.HallAdapter;
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;
import cn.edu.fjzzit.echomusic.entity.HallInfo;

public class HallActivity extends AppCompatActivity {
    private List<HallInfo> hallInfoList = new ArrayList<>();
    private Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        toHalls();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.hall_rlv);
        returnBtn = findViewById(R.id.return_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        HallAdapter adapter = new HallAdapter(hallInfoList,this);
        recyclerView.setAdapter(adapter);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toHalls() {

        for (int i=0;i<10;i++){
            HallInfo hallInfo = new HallInfo("音乐奇才","2021-7-3",1,"Author","","Piano Concerto","C大调第三钢琴协奏曲");
            hallInfoList.add(hallInfo);
        }
    }
}
