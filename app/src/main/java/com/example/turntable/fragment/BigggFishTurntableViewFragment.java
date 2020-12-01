package com.example.turntable.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.turntable.R;
import com.example.turntable.view.bigggfish.BigggFishTurnableFrameLayout;
import com.example.turntable.view.bigggfish.OnBtnClickListener;
import com.example.turntable.view.bigggfish.OnRotatingStopListener;

import java.util.ArrayList;
import java.util.List;


public class BigggFishTurntableViewFragment extends Fragment {

    private BigggFishTurnableFrameLayout fishTurnableFrameLayout;
    private TextView mSeekBarValue;
    private SeekBar mSeekBar;
    private Switch mSwitch;

    private static BigggFishTurntableViewFragment newInstance(){
        BigggFishTurntableViewFragment fragment = new BigggFishTurntableViewFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bigggfish_turntable,container,false);
        fishTurnableFrameLayout = view.findViewById(R.id.luck_plate_view);
        mSeekBar = (SeekBar) view.findViewById(R.id.seekbar);
        mSeekBarValue = view.findViewById(R.id.tv_seekbar_value);
        mSwitch = (Switch) view.findViewById(R.id.switch_mode);

        fishTurnableFrameLayout.setOnBtnClickListener(new OnBtnClickListener() {
            @Override
            public void onClick() {
                fishTurnableFrameLayout.startRotating(2);
            }
        });

        fishTurnableFrameLayout.setOnRotatingStopListener(new OnRotatingStopListener() {
            @Override
            public void onStop(int stopPosition) {
                Toast.makeText(getContext(), "恭喜您抽中了" + stopPosition + "号奖品", Toast.LENGTH_SHORT).show();
            }
        });

        fishTurnableFrameLayout.setItemTextStrList(getStrList(6));
        fishTurnableFrameLayout.setItemBitmapList(getBitmapList(6));

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < 2) {
                    progress = 2;
                }
                fishTurnableFrameLayout.setItemTextStrList(getStrList(progress));
                fishTurnableFrameLayout.setItemBitmapList(getBitmapList(progress));
                mSeekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    fishTurnableFrameLayout.setRotatingMode(-2);
                } else {
                    fishTurnableFrameLayout.setRotatingMode(-1);
                }
            }
        });

        return view;
    }


    private List<String> getStrList(int count) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arrayList.add("POSITION" + i);
        }
        return arrayList;
    }

    private List<Bitmap> getBitmapList(int count) {
        ArrayList<Bitmap> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                arrayList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round));
            } else {
                arrayList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            }
        }
        return arrayList;
    }
}
