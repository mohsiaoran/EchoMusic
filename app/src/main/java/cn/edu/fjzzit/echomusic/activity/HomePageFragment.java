package cn.edu.fjzzit.echomusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.ChosenAdapter;
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;

public class HomePageFragment extends Fragment {
    private RecyclerView mChosenRecyclerView;
    Button get_music;
    String TAG="";
    EditText editTextTextPersonName;
    private ImageView topImage;//排行榜图标
    private ImageView planIv;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);          //关联布局文件

        get_music =  (Button) view.findViewById(R.id.get_music);
        mChosenRecyclerView = view.findViewById(R.id.chosen_rlv);
        topImage = view.findViewById(R.id.top_iv);
        planIv = view.findViewById(R.id.plan_iv);
        topImage = view.findViewById(R.id.top_iv);

        // 当搜索框获得焦点和点击时时跳转到搜索页面
        editTextTextPersonName = (EditText) view.findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName.setFocusable(false);
        editTextTextPersonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextTextPersonName.clearFocus();
                Intent intent = new Intent();
                intent.setClass(getContext(),SearchActivity.class);
                startActivity(intent);
            }

        });

        List<ChosenInfo> chosenInfoList = new ArrayList<ChosenInfo>();

        for (int i=0;i<3;i++){
            ChosenInfo chosenInfo = new ChosenInfo("","Piano Concerto","Author","C大调第三钢琴协奏曲");
            chosenInfoList.add(chosenInfo);
        }

        RecyclerView.LayoutManager chosenLayouManager = new LinearLayoutManager(view.getContext());
        mChosenRecyclerView.setLayoutManager(chosenLayouManager);
        ChosenAdapter chosenAdapter = new ChosenAdapter(chosenInfoList, view.getContext());
        mChosenRecyclerView.setAdapter(chosenAdapter);


        //跳转排行榜
        topImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getContext(), TopDetailActivity.class);
                getContext().startActivity(intent);

            }
        });

        //跳转到学习计划
        planIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), PlanActivity.class);
                getContext().startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        get_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), SpeechActivity.class);
                startActivity(intent);

            }
        });

    }

}
