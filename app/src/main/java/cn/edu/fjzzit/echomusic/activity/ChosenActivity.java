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
import cn.edu.fjzzit.echomusic.adapter.SortAdapter;
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;
import cn.edu.fjzzit.echomusic.entity.SortInfo;

public class ChosenActivity extends AppCompatActivity {
    private List<ChosenInfo> chosenInfoList = new ArrayList<>();
    private Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiyt_chosen);
        toChosens();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chosen_one);
        returnBtn = findViewById(R.id.return_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(layoutManager);
        ChosenAdapter adapter = new ChosenAdapter(chosenInfoList,this);
        recyclerView.setAdapter(adapter);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toChosens() {

        for (int i=0;i<10;i++){
            ChosenInfo chosenInfo = new ChosenInfo(R.drawable.a14,"Piano Concerto","朗朗","C大调第三钢琴协奏曲");
            chosenInfoList.add(chosenInfo);
        }
    }
}
