package com.example.turntable.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.turntable.BaseFragmentPagerAdapter;
import com.example.turntable.R;
import com.example.turntable.common.BigggFishConstant;
import com.example.turntable.fragment.mochixuan.HeptagonalOvalFragment;
import com.example.turntable.fragment.mochixuan.HexagonCircleFragment;
import com.example.turntable.fragment.mochixuan.MoreDisplaysFragment;
import com.google.android.material.tabs.TabLayout;

public class mochixuanETurntableFragment extends Fragment {

    private TabLayout mochixuanTabLayout;
    private ViewPager mochixuanViewPager;

    private static mochixuanETurntableFragment newInstance(){
        mochixuanETurntableFragment fragment = new mochixuanETurntableFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mochixuan_turntable,container,false);
        mochixuanViewPager = (ViewPager) view.findViewById(R.id.mochixuan_view_pager);
        setupViewPager(mochixuanViewPager);

        mochixuanTabLayout = (TabLayout) view.findViewById(R.id.mochixuan_tabs);
        mochixuanTabLayout.setupWithViewPager(mochixuanViewPager);

        return view;
    }

    /**
     * Adding fragments to ViewPager
     *
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new HexagonCircleFragment(), BigggFishConstant.BigggFish_TAB_TITLE[0]);
        adapter.addFrag(new HeptagonalOvalFragment(), BigggFishConstant.BigggFish_TAB_TITLE[1]);
        adapter.addFrag(new MoreDisplaysFragment(), BigggFishConstant.BigggFish_TAB_TITLE[2]);
        viewPager.setAdapter(adapter);
    }
}
