package cn.edu.fjzzit.echomusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.ChosenAdapter;
import cn.edu.fjzzit.echomusic.adapter.ToturialAdapter;
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;
import cn.edu.fjzzit.echomusic.entity.ToturialInfo;

public class CreationFragment extends Fragment {

    private RecyclerView mToturialRecyclerView;
    private ImageView toturialImage;//教程图标
    private TextView toturialMore; //精选更多
    private TextView actMore; //精选更多

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_creation, container, false);          //关联布局文件

        mToturialRecyclerView = view.findViewById(R.id.toturial_rlv);
        toturialMore =view.findViewById(R.id.tutorial_more_tv);
        actMore =view.findViewById(R.id.activity_more_tv);
        toturialImage =view.findViewById(R.id.toturial_iv);

        List<ToturialInfo> toturialInfoList = new ArrayList<ToturialInfo>();

        for (int i=0;i<3;i++){
            ToturialInfo toturialInfo = new ToturialInfo("","钢琴课"+i,String.valueOf(100*i),"");
            toturialInfoList.add(toturialInfo);
        }

        RecyclerView.LayoutManager toturialLayouManager = new LinearLayoutManager(view.getContext());
        mToturialRecyclerView.setLayoutManager(toturialLayouManager);
        ToturialAdapter toturialAdapter = new ToturialAdapter(toturialInfoList, view.getContext());
        mToturialRecyclerView.setAdapter(toturialAdapter);


        //跳转到教程详情
        toturialImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getContext(),ToturialActivity.class);
                getContext().startActivity(intent);

            }
        });

        //跳转到推荐教程更多
        toturialMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getContext(),ToturialActivity.class);
                getContext().startActivity(intent);

            }
        });

        //跳转到活动更多
        actMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getContext(),ActActivity.class);
                getContext().startActivity(intent);


            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
