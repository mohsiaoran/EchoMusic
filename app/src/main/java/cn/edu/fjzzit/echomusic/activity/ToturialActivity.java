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
import cn.edu.fjzzit.echomusic.adapter.SortAdapter;
import cn.edu.fjzzit.echomusic.adapter.ToturialAdapter;
import cn.edu.fjzzit.echomusic.entity.SortInfo;
import cn.edu.fjzzit.echomusic.entity.ToturialInfo;

public class ToturialActivity extends AppCompatActivity {
    private List<ToturialInfo> toturialInfos=new ArrayList<>();
    private Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toturial);
        toToturials();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.toturial_one);
        returnBtn = findViewById(R.id.return_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(layoutManager);
        ToturialAdapter adapter = new ToturialAdapter(toturialInfos,this);
        recyclerView.setAdapter(adapter);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toToturials() {
        for (int i = 0; i < 8; i++) {
            ToturialInfo toturialInfo = new ToturialInfo("","钢琴课"+i,String.valueOf(100*i),"");
            toturialInfos.add(toturialInfo);
        }
    }
}
