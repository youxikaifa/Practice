package com.example.jin.practice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.jin.practice.base.BaseA;
import com.example.jin.practice.ui.HomeFragment;
import com.example.jin.practice.ui.MusicFragment;
import com.example.jin.practice.ui.VideoFragment;
import com.example.jin.practice.ui.BookFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabLayoutMode;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseA {

//    int[] testColors = {0xFF00796B, 0xFF5B4947, 0xFF607D8B, 0xFFF57C00, 0xFFF57C00};

    List<Fragment> mFragments;

    Controller controller;

    @ViewById(R.id.tab)
    PagerBottomTabLayout bottomTabLayout;

    @AfterViews
    public void initViews() {
//        R.drawable.ic_menu_home,"主页" ,testColors[0]
//        | TabLayoutMode.CHANGE_BACKGROUND_COLOR

        initFragment();

        controller =  bottomTabLayout.builder()
                .addTabItem(R.drawable.ic_menu_home, "主页")
                .addTabItem(R.drawable.ic_volume_bluetooth_ad2p, "音乐")
                .addTabItem(R.drawable.presence_video_online, "视频")
                .addTabItem(R.drawable.ic_menu_archive, "book")
                .setMode(TabLayoutMode.HIDE_TEXT)
                .build();

        controller.addTabItemClickListener(listener);
    }

    public void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new MusicFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new BookFragment());

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.contentPanel,mFragments.get(0));
        ft.commit();
}

//    public Fragment createFragment(String tag){
//        HomeFragment fragment = new HomeFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("content",tag);
//        fragment.setArguments(bundle);
//        return fragment;
//    }

    OnTabItemSelectListener listener = new OnTabItemSelectListener() {
        @Override
        public void onSelected(int index, Object tag) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.contentPanel,mFragments.get(index));
            ft.commit();
        }

        @Override
        public void onRepeatClick(int index, Object tag) {
//            Toast.makeText(getApplicationContext(), "请勿重复点击", Toast.LENGTH_SHORT).show();
        }
    };
}
