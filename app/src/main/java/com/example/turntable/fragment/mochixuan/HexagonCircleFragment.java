package com.example.turntable.fragment.mochixuan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.turntable.R;
import com.example.turntable.common.BigggFishConstant;
import com.example.turntable.util.mochixuanUtil;
import com.example.turntable.view.mochixuan.MochixuanETurntableViewGroup;
import com.example.turntable.view.mochixuan.OnMenuItemClickListener;

public class HexagonCircleFragment extends Fragment {

    private MochixuanETurntableViewGroup mochixuanETurntableViewGroup;

    private static HexagonCircleFragment newInstance() {
        HexagonCircleFragment fragment = new HexagonCircleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mochixuan_hexagon_circle, container, false);
        mochixuanETurntableViewGroup = view.findViewById(R.id.eturntableviewgroup);

        mochixuanUtil util = new mochixuanUtil(getContext());

        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(util.getMinLenght(), util.getMinLenght());
        mochixuanETurntableViewGroup.setLayoutParams(layoutParams);
        mochixuanETurntableViewGroup.setMenuItemIconsAndTexts(BigggFishConstant.getImages(6), BigggFishConstant.getTexts(6));
        mochixuanETurntableViewGroup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                Toast.makeText(getContext(), pos + " " + BigggFishConstant.TextItems[pos], Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
