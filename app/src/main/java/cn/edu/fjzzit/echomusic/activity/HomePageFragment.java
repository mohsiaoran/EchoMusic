package cn.edu.fjzzit.echomusic.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.ChosenAdapter;
import cn.edu.fjzzit.echomusic.adapter.PostAdapter;
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;
import cn.edu.fjzzit.echomusic.entity.PostInfo;

public class HomePageFragment extends Fragment {
    private RecyclerView mChosenRecyclerView;
    Button get_music;
    String TAG="";
    EditText editTextTextPersonName;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);          //关联布局文件

        get_music =  (Button) view.findViewById(R.id.get_music);
        mChosenRecyclerView = view.findViewById(R.id.chosen_rlv);

        // 当搜索框获得焦点和点击时时跳转到搜索页面
        editTextTextPersonName = (EditText) view.findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Intent intent = new Intent(getContext(),SearchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        editTextTextPersonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SearchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
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
