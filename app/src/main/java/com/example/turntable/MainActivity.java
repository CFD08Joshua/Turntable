package com.example.turntable;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.turntable.common.Constant;
import com.example.turntable.fragment.BigggFishTurntableViewFragment;
import com.example.turntable.fragment.mochixuanETurntableFragment;
import com.example.turntable.fragment.wangchengmengLotteryTurntableFragment;
import com.example.turntable.fragment.hnsycsxhzcshTurntableViewFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    /**
     * Adding fragments to ViewPager
     *
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new BigggFishTurntableViewFragment(), Constant.TAB_TITLE[0]);
        adapter.addFrag(new hnsycsxhzcshTurntableViewFragment(), Constant.TAB_TITLE[1]);
        adapter.addFrag(new mochixuanETurntableFragment(), Constant.TAB_TITLE[2]);
        adapter.addFrag(new wangchengmengLotteryTurntableFragment(), Constant.TAB_TITLE[3]);
        viewPager.setAdapter(adapter);
    }
}