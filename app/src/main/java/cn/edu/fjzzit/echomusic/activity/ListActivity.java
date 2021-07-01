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
import cn.edu.fjzzit.echomusic.entity.ListInfo;

public class ListActivity extends AppCompatActivity {
    private List<ListInfo> listInfos=new ArrayList<>();
    private Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        toLists();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_one);
        returnBtn = findViewById(R.id.return_btn);

       /* LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(layoutManager);
        ListAdapter adapter = new ListAdapter(listInfos);
        recyclerView.setAdapter(adapter);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toLists() {
        for (int i = 0; i < 18; i++) {
            ListInfo listInfo = new ListInfo(R.drawable.social_attention_shape_corner,"年轻人的曲子");
            listInfos.add(listInfo);
        }
    }
}
