package cn.edu.fjzzit.echomusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.entity.MyInfo;

public class MyInfoFragment extends Fragment {
    View view;
    TextView my_name;
    TextView my_level;
    TextView my_sign;
    TextView my_attention_num;
    TextView my_d_num;
    TextView my_fans_num;
    TextView my_news_num;
    MyInfo myInfo;
    private LinearLayout localMusic;
    private View browsing_history;
    private View purchased_music;
    private View my_songbook;
    private View my_download;
    private View my_favorite;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_info, container, false);          //关联布局文件

        my_name = (TextView) view.findViewById(R.id.my_name);
        my_level = (TextView) view.findViewById(R.id.my_level);
        my_sign = (TextView) view.findViewById(R.id.my_sign);
        my_attention_num = (TextView) view.findViewById(R.id.my_attention_num);
        my_d_num = (TextView) view.findViewById(R.id.my_d_num);
        my_fans_num = (TextView) view.findViewById(R.id.my_fans_num);
        my_news_num = (TextView) view.findViewById(R.id.my_news_num);
        localMusic = view.findViewById(R.id.ly_local_music);


        my_songbook = view.findViewById(R.id.my_songbook);
        my_songbook.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SongBookActivity.class);
                startActivity(intent);
            }
        });

        my_favorite = view.findViewById(R.id.my_favorite);
        my_favorite.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyfavoriteActivity.class);
                startActivity(intent);
            }
        });

        my_download = view.findViewById(R.id.my_download);
        my_download.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyDownloadActivity.class);
                startActivity(intent);
            }
        });

        purchased_music = view.findViewById(R.id.purchased_music);
        purchased_music.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PursedActivity.class);
                startActivity(intent);
            }
        });

        browsing_history = view.findViewById(R.id.browsing_history);
        browsing_history.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlayHistoryActivity.class);
                startActivity(intent);
            }
        });

        //新页面接收数据
        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle!=null){
            myInfo= (MyInfo) bundle.getSerializable("myInfo");
        }

        if(myInfo!=null){
            my_name.setText(myInfo.getName());
            my_level.setText(myInfo.getLevel());
            my_sign.setText(myInfo.getSign());
            my_attention_num.setText(myInfo.getAttention());
            my_d_num.setText(myInfo.getDynamic());
            my_fans_num.setText(myInfo.getFans());
            my_news_num.setText(myInfo.getNews());
        }

        //本地音乐按钮
        localMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), LocalMusicActivity.class);
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
        super.onActivityCreated(savedInstanceState);

    }
}
