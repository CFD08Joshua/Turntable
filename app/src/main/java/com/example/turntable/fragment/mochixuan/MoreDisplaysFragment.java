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

import com.example.turntable.view.mochixuan.OnMenuItemClickListener;
import com.example.turntable.R;
import com.example.turntable.common.mochixuanConstant;
import com.example.turntable.util.mochixuanUtil;
import com.example.turntable.view.mochixuan.MochixuanETurntableViewGroup;

public class MoreDisplaysFragment extends Fragment {

    private MochixuanETurntableViewGroup mETurntableMenuView;

    private static MoreDisplaysFragment newInstance(){
        MoreDisplaysFragment fragment = new MoreDisplaysFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mochixuan_more_display,container,false);
        mETurntableMenuView = (MochixuanETurntableViewGroup) view.findViewById(R.id.eturnable_view);

        mochixuanUtil util = new mochixuanUtil(getContext());

        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(util.getMinLenght(),util.getMinLenght());
        if (util.getMinLenght()*1.4f<util.getMaxLenght()) {
            if (util.getWidth()>util.getHeigth()) {
                layoutParams = new RelativeLayout.LayoutParams((int) (util.getHeigth()*1.4f), util.getHeigth());
            } else {
                layoutParams = new RelativeLayout.LayoutParams(util.getWidth(), (int) (util.getWidth()*1.4f));
            }
        }


        mETurntableMenuView.setLayoutParams(layoutParams);

        mETurntableMenuView.setMenuItemIconsAndTexts(mochixuanConstant.getImages(8),mochixuanConstant.getTexts(8));
        mETurntableMenuView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                Toast.makeText(getContext(),pos+" "+mochixuanConstant.TextItems[pos], Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.btn_pre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mETurntableMenuView.slide(false);
            }
        });

        view.findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mETurntableMenuView.slide(true);
            }
        });
        return view;
    }
}
