package com.example.turntable.fragment.mochixuan;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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

import java.net.URL;

import static android.content.Context.WINDOW_SERVICE;

public class HeptagonalOvalFragment extends Fragment {

    RelativeLayout.LayoutParams layoutParams ;

    private static HexagonCircleFragment newInstance(){
        HexagonCircleFragment fragment = new HexagonCircleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        initWindows();
        View view = inflater.inflate(R.layout.fragment_mochixuan_heptagonal_oval,container,false);

        MochixuanETurntableViewGroup mETurntableMenuView = (MochixuanETurntableViewGroup) view.findViewById(R.id.eturnable_view);

        mochixuanUtil util = new mochixuanUtil(getContext());
        mETurntableMenuView.setLayoutParams(setTurnTableLayoutPosition(util));
        mETurntableMenuView.setMenuItemIconsAndTexts(mochixuanConstant.getImages(8),mochixuanConstant.getTexts(8));
        mETurntableMenuView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                Toast.makeText(getContext(),pos+" "+mochixuanConstant.TextItems[pos], Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private RelativeLayout.LayoutParams setTurnTableLayoutPosition(mochixuanUtil util){
        layoutParams =
                new RelativeLayout.LayoutParams(util.getMinLenght(), util.getMinLenght());

        if (util.getMinLenght()*1.5f<util.getMaxLenght()) {
            if (util.getWidth()>util.getHeigth()) {
                layoutParams = new RelativeLayout.LayoutParams((int) (util.getHeigth()*1.5f), util.getHeigth());
            } else {
                // 1.0 至中
                layoutParams = new RelativeLayout.LayoutParams((int)(util.getWidth()), (int) (util.getWidth()*1.0f));
            }
        }
        return layoutParams;
    }

    private void initWindows() {

        WindowManager manager = (WindowManager) getActivity().getSystemService(WINDOW_SERVICE);
        int width = manager.getDefaultDisplay().getWidth();
        int height = manager.getDefaultDisplay().getHeight();

        if (width<height) {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

    }
}
