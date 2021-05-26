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
import cn.edu.fjzzit.echomusic.adapter.ToturialAdapter;
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;
import cn.edu.fjzzit.echomusic.entity.ToturialInfo;

public class CreationFragment extends Fragment {

    private RecyclerView mToturialRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_creation, container, false);          //关联布局文件

        mToturialRecyclerView = view.findViewById(R.id.toturial_rlv);

        List<ToturialInfo> toturialInfoList = new ArrayList<ToturialInfo>();

        for (int i=0;i<3;i++){
            ToturialInfo toturialInfo = new ToturialInfo("","钢琴课"+i,String.valueOf(100*i),"");
            toturialInfoList.add(toturialInfo);
        }

        RecyclerView.LayoutManager toturialLayouManager = new LinearLayoutManager(view.getContext());
        mToturialRecyclerView.setLayoutManager(toturialLayouManager);
        ToturialAdapter toturialAdapter = new ToturialAdapter(toturialInfoList, view.getContext());
        mToturialRecyclerView.setAdapter(toturialAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
