package cn.edu.fjzzit.echomusic.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.dbtext.UserDao;
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
    

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_info, container, false);          //关联布局文件

        my_name = (TextView) view.findViewById(R.id.my_name);
        my_level = (TextView) view.findViewById(R.id.my_level);
        my_sign = (TextView) view.findViewById(R.id.my_sign);
        my_attention_num = (TextView) view.findViewById(R.id.my_attention_num);
        my_d_num = (TextView) view.findViewById(R.id.my_d_num);
        my_fans_num = (TextView) view.findViewById(R.id.my_fans_num);
        my_news_num = (TextView) view.findViewById(R.id.my_news_num);

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
