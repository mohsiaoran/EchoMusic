package cn.edu.fjzzit.echomusic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.ListAdapter;
import cn.edu.fjzzit.echomusic.adapter.SortAdapter;
import cn.edu.fjzzit.echomusic.entity.ListInfo;
import cn.edu.fjzzit.echomusic.entity.SortInfo;

public class SortActivity extends AppCompatActivity {
    private List<SortInfo> sortInfos=new ArrayList<>();
    private Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        toSorts();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sort_one);
        returnBtn = findViewById(R.id.return_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(layoutManager);
        SortAdapter adapter = new SortAdapter(sortInfos);
        recyclerView.setAdapter(adapter);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toSorts() {
        for (int i = 0; i < 8; i++) {
            SortInfo sortInfo = new SortInfo(R.drawable.social_attention_shape_corner,"钢琴曲");
            sortInfos.add(sortInfo);
        }
    }
}