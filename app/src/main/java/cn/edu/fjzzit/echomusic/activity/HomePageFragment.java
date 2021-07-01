package cn.edu.fjzzit.echomusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.ChosenAdapter;
import cn.edu.fjzzit.echomusic.adapter.LoopViewAdapter;
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;

public class HomePageFragment extends Fragment {
    private RecyclerView mChosenRecyclerView;
    Button get_music;
    String TAG="";
    EditText editTextTextPersonName;
    private ImageView topImage;//排行榜图标
    private ImageView planIv;
    private ViewPager viewPager;  //轮播图模块
    private int[] mImg;
    private ArrayList<ImageView> mImgList;
    private LinearLayout ll_dots_container;
    private int previousSelectedPosition = 0;
    boolean isRunning = false;
    private ImageView listImage;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);          //关联布局文件

        get_music =  (Button) view.findViewById(R.id.get_music);
        mChosenRecyclerView = view.findViewById(R.id.chosen_rlv);
        topImage = view.findViewById(R.id.top_iv);
        planIv = view.findViewById(R.id.plan_iv);
        topImage = view.findViewById(R.id.top_iv);
        listImage = view.findViewById(R.id.list_iv);

        // 轮播图相关
        viewPager = (ViewPager) view.findViewById(R.id.loopviewpager);
        ll_dots_container = (LinearLayout) view.findViewById(R.id.ll_dots_loop);

        initLoopView();  //实现轮播图

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

        //跳转曲集
        listImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(getContext(), ListActivity.class);
                getContext().startActivity(intent);

            }
        });

        return view;
    }

    private void initLoopView() {
        // 图片资源id数组
        mImg = new int[]{
                R.drawable.musicact1,
                R.drawable.musicact2,
                R.drawable.musicact3,
                R.drawable.musicact4,
                R.drawable.musicact5,
        };

        // 初始化要展示的5个ImageView
        mImgList = new ArrayList<ImageView>();
        ImageView imageView;
        View dotView;
        LinearLayout.LayoutParams layoutParams;
        for(int i=0;i<mImg.length;i++){
            //初始化要显示的图片对象
            imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(mImg[i]);
            mImgList.add(imageView);
            //加引导点
            dotView = new View(getActivity());
            dotView.setBackgroundResource(R.drawable.dot);
            layoutParams = new LinearLayout.LayoutParams(10,10);
            if(i!=0){
                layoutParams.leftMargin=10;
            }
            //设置默认所有都不可用
            dotView.setEnabled(false);
            ll_dots_container.addView(dotView,layoutParams);
        }

        ll_dots_container.getChildAt(0).setEnabled(true);
        previousSelectedPosition=0;
        //设置适配器
        viewPager.setAdapter(new LoopViewAdapter(mImgList));
        // 把ViewPager设置为默认选中Integer.MAX_VALUE / t2，从十几亿次开始轮播图片，达到无限循环目的;
        int m = (Integer.MAX_VALUE / 2) %mImgList.size();
        int currentPosition = Integer.MAX_VALUE / 2 - m;
        viewPager.setCurrentItem(currentPosition);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int newPosition = i % mImgList.size();
                ll_dots_container.getChildAt(previousSelectedPosition).setEnabled(false);
                ll_dots_container.getChildAt(newPosition).setEnabled(true);
                previousSelectedPosition = newPosition;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        // 开启轮询
        new Thread(){
            public void run(){
                isRunning = true;
                while(isRunning){
                    try{
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //下一条
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                        }
                    });
                }
            }
        }.start();

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
