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

public class PostFragment extends Fragment {

    private RecyclerView mPostRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);          //关联布局文件

        mPostRecyclerView = view.findViewById(R.id.post_rlv);

        List<PostInfo> postInfoList = new ArrayList<PostInfo>();
        for (int i =0;i<10;i++){
            PostInfo postInfo = new PostInfo("username"+i,"time","测试");
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