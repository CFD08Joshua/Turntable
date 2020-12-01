package com.example.turntable.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.turntable.R;
import com.example.turntable.view.lottery.LotteryTurntableSufaceView;
import com.example.turntable.view.lottery.SpanRollListener;

public class wangchengmengLotteryTurntableFragment extends Fragment implements View.OnClickListener {

    private ImageView mIvStart;
    private LotteryTurntableSufaceView lotteryTurntableSufaceView;
    private boolean   mIsClickStart;

    private static wangchengmengLotteryTurntableFragment newInstance(){
        wangchengmengLotteryTurntableFragment fragment = new wangchengmengLotteryTurntableFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wangchengmeng_turntable,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        lotteryTurntableSufaceView =  view.findViewById(R.id.lottery_turntable_surfaceview);
        mIvStart = (ImageView) view.findViewById(R.id.iv_start);

        mIvStart.setOnClickListener(this);

        lotteryTurntableSufaceView.setOnSpanRollListener(new SpanRollListener() {
            @Override
            public void onSpanRollListener(double speed) {
                if (0 == speed) {
                    //已经停止下来了 提示中奖名并释放按钮
                    mIvStart.setEnabled(true);
                    if (mIsClickStart) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), "恭喜你中奖了", Toast.LENGTH_SHORT).show();
                                mIsClickStart = false;
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_start:
                mIvStart.setEnabled(false);
                mIsClickStart = true;
                //传入的参数由后台返回指定中哪个奖项
                lotteryTurntableSufaceView.luckyStart(0);
                //模拟请求网络
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //网络请求6秒
                        SystemClock.sleep(5000);
                        //逐渐停止转盘
                        lotteryTurntableSufaceView.luckStop();
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
