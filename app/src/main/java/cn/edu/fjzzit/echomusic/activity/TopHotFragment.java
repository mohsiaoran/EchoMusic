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
import cn.edu.fjzzit.echomusic.adapter.TopHotAdapter;
import cn.edu.fjzzit.echomusic.entity.TopInfo;

public class TopHotFragment extends Fragment {
    private RecyclerView mTopRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_top_hot, container, false);
        mTopRecyclerView = inflate.findViewById(R.id.top_hot_rlv);
        List<TopInfo> topInfoList = new ArrayList<TopInfo>();

        for (int i=0;i<4;i++){
            TopInfo topInfo = new TopInfo("","Piano Concerto","Author","C大调第三钢琴协奏曲");
            topInfoList.add(topInfo);
        }

        RecyclerView.LayoutManager topLayoutManager = new LinearLayoutManager(inflate.getContext());
        mTopRecyclerView.setLayoutManager(topLayoutManager);
        TopHotAdapter topHotAdapter = new TopHotAdapter(topInfoList, inflate.getContext());
        mTopRecyclerView.setAdapter(topHotAdapter);

        return inflate;
    }
}
