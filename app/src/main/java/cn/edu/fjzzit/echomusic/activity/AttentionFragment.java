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
import cn.edu.fjzzit.echomusic.adapter.PostAdapter;
import cn.edu.fjzzit.echomusic.entity.PostInfo;

public class AttentionFragment extends Fragment {

    private RecyclerView mPostRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention, container, false);          //关联布局文件


        mPostRecyclerView = view.findViewById(R.id.atte_rlv);

        String oSt = "长文字动态效果测试";
        String content = "";
        List<PostInfo> postInfoList = new ArrayList<PostInfo>();
        for (int i =0;i<10;i++){
            content = content+oSt+i;
            PostInfo postInfo = new PostInfo("username"+i,"time",content,1);
            postInfoList.add(postInfo);
        }

        RecyclerView.LayoutManager postLayoutManager = new LinearLayoutManager(view.getContext());
        mPostRecyclerView.setLayoutManager(postLayoutManager);
        PostAdapter postAdapter = new PostAdapter(postInfoList, view.getContext());
        mPostRecyclerView.setAdapter(postAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}