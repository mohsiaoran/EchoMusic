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
import cn.edu.fjzzit.echomusic.adapter.ActAdapter;
import cn.edu.fjzzit.echomusic.adapter.SortAdapter;
import cn.edu.fjzzit.echomusic.entity.ActInfo;
import cn.edu.fjzzit.echomusic.entity.SortInfo;

public class ActActivity extends AppCompatActivity {
    private List<ActInfo> actInfos=new ArrayList<>();
    private Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);
        toActs();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.act_one);
        returnBtn = findViewById(R.id.return_btn);

       // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
      // layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(layoutManager);
        ActAdapter adapter = new ActAdapter(actInfos);
        recyclerView.setAdapter(adapter);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toActs() {

            ActInfo actInfo1 = new ActInfo(R.drawable.a4);
            actInfos.add(actInfo1);
            ActInfo actInfo2 = new ActInfo(R.drawable.a7);
            actInfos.add(actInfo2);
            ActInfo actInfo3 = new ActInfo(R.drawable.a35);
            actInfos.add(actInfo3);
            ActInfo actInfo4 = new ActInfo(R.drawable.a41);
            actInfos.add(actInfo4);


    }
}
