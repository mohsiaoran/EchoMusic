package cn.edu.fjzzit.echomusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView;

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
    private ImageView insImage;//作曲图标
    private ImageView compositionImage;//谱曲图标
    private ImageView hallImage;//创作广场图标
    private ImageView toturialImage;//教程图标
    private TextView toturialMore; //精选更多
    private TextView actMore; //精选更多
    private ImageView repay_iv;
    private ImageView collect_manager_iv;
    private View browse_iv;
    private View my_manager_iv;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_creation, container, false);          //关联布局文件

        mToturialRecyclerView = view.findViewById(R.id.toturial_rlv);
        toturialMore =view.findViewById(R.id.tutorial_more_tv);
        actMore =view.findViewById(R.id.activity_more_tv);

        insImage=view.findViewById(R.id.ins_iv);
        compositionImage=view.findViewById(R.id.composition_iv);
        hallImage=view.findViewById(R.id.hall_iv);
        toturialImage =view.findViewById(R.id.toturial_iv);

        List<ToturialInfo> toturialInfoList = new ArrayList<ToturialInfo>();
        // 点击进入收藏页面
        collect_manager_iv = (ImageView) view.findViewById(R.id.collect_manager_iv);
        collect_manager_iv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WorkManagementActivity.class);
                startActivity(intent);
            }
        });
        // 点击进入创作激励
        repay_iv = (ImageView) view.findViewById(R.id.repay_iv);
        repay_iv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), IncentivesActivity.class);
                startActivity(intent);
            }
        });
        // 点击进入浏览历史页面
        browse_iv = (ImageView) view.findViewById(R.id.browse_iv);
        browse_iv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), historyActivity.class);
                startActivity(intent);
            }
        });

        // 点击进入作品管理页面
        my_manager_iv = (ImageView) view.findViewById(R.id.my_manager_iv);
        my_manager_iv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OpusManagmentActivity.class);
                startActivity(intent);
            }
        });


            ToturialInfo toturialInfo1 = new ToturialInfo(R.drawable.a47,"余老师钢琴课",String.valueOf(5233),"");
            toturialInfoList.add(toturialInfo1);
            ToturialInfo toturialInfo2 = new ToturialInfo(R.drawable.a49,"林老师提琴课",String.valueOf(2416),"");
            toturialInfoList.add(toturialInfo2);
            ToturialInfo toturialInfo3 = new ToturialInfo(R.drawable.a15,"王老师吉他课",String.valueOf(4324),"");
            toturialInfoList.add(toturialInfo3);

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

        //跳转到作曲详情
        insImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getContext(),InsActivity.class);
                getContext().startActivity(intent);

            }
        });

        //跳转到谱曲详情
        compositionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getContext(),CompositionActivity.class);
                getContext().startActivity(intent);

            }
        });

        //跳转到创作广场详情
        hallImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getContext(),HallActivity.class);
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
