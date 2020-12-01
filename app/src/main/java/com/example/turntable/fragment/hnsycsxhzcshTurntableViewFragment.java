package com.example.turntable.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.turntable.R;
import com.example.turntable.view.hnsycsxhzcsh.ITurntableListener;
import com.example.turntable.view.hnsycsxhzcsh.HnsycsxhzcshTurntableView;

import java.util.ArrayList;

public class hnsycsxhzcshTurntableViewFragment extends Fragment {

    private HnsycsxhzcshTurntableView mTurntable;
    private ImageView mIvGo;
    private Button mBtChangeColor;
    private Button mBtChangeData;
    private TextView mTvResult;
    private Button mBtPointTo;

    private static hnsycsxhzcshTurntableViewFragment newInstance() {
        hnsycsxhzcshTurntableViewFragment fragment = new hnsycsxhzcshTurntableViewFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_turntable_hnsycsxhzcsh, container, false);
        mTurntable = (HnsycsxhzcshTurntableView) view.findViewById(R.id.turntable);
        mIvGo = (ImageView) view.findViewById(R.id.iv_node);
        mBtChangeColor = (Button) view.findViewById(R.id.bt_changecolor);
        mBtChangeData = (Button) view.findViewById(R.id.bt_changedata);
        mTvResult = (TextView) view.findViewById(R.id.tv_result);
        mBtPointTo = (Button) view.findViewById(R.id.bt_point_to);

        mBtPointTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTurntable.startRotate(7, new ITurntableListener() {
                    @Override
                    public void onStart() {
                        Toast.makeText(getContext(), "开始抽奖", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEnd(int position, String name) {
                        mTvResult.setText("抽奖结束抽中第" + (position + 1) + "位置的奖品:" + name);
                    }
                });
            }
        });

        mBtChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置item的颜色
                changeColors();
            }
        });

        mBtChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //修改转盘数据
                changeDatas();
            }
        });

        //开始抽奖
        mIvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTurntable.startRotate(new ITurntableListener() {
                    @Override
                    public void onStart() {
                        Toast.makeText(getContext(), "开始抽奖", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEnd(int position, String name) {
                        mTvResult.setText("抽奖结束抽中第" + (position + 1) + "位置的奖品:" + name);
                    }
                });
            }
        });

        return view;
    }

    private void changeColors() {
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#ff8584"));
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(Color.parseColor("#000000"));
        mTurntable.setWheelItemBackgroundColor(colors);
    }

    private void changeDatas() {
        int num = 6;
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            names.add("第" + (i + 1));
            bitmaps.add(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        }
        mTurntable.setWheelItemData(num, names, bitmaps);
    }
}
