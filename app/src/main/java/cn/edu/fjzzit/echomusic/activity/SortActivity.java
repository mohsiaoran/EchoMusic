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

            SortInfo sortInfo = new SortInfo(R.drawable.a5,"吉他");
            sortInfos.add(sortInfo);

            SortInfo sortInfo1 = new SortInfo(R.drawable.a6,"流行曲");
            sortInfos.add(sortInfo1);

            SortInfo sortInfo2 = new SortInfo(R.drawable.a21,"古筝");
            sortInfos.add(sortInfo2);

            SortInfo sortInfo3 = new SortInfo(R.drawable.a47,"钢琴");
            sortInfos.add(sortInfo3);

            SortInfo sortInfo4 = new SortInfo(R.drawable.a49,"小提琴");
            sortInfos.add(sortInfo4);

    }
}