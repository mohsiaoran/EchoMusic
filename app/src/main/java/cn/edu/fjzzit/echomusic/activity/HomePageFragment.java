package cn.edu.fjzzit.echomusic.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.ChosenAdapter;
import cn.edu.fjzzit.echomusic.adapter.PostAdapter;
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;
import cn.edu.fjzzit.echomusic.entity.PostInfo;

public class HomePageFragment extends Fragment {

    private RecyclerView mChosenRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);          //关联布局文件

        mChosenRecyclerView = view.findViewById(R.id.chosen_rlv);

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
}
