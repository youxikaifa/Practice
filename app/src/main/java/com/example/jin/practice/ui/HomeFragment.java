package com.example.jin.practice.ui;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jin.practice.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

/**
 * Created by Jin on 2016/7/5.
 */
@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    public Context mContext;
    public Activity mActivity;

    public View homeView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        String content = getArguments().getString("content");
        homeView =  LayoutInflater.from(mContext).inflate(R.layout.fragment_home,null);

        homeView.findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentPanel,new HomeSubFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });



        return homeView;
    }

    @AfterViews
    public void initViews(){
//        homeView =  LayoutInflater.from(mContext).inflate(R.layout.fragment_home,null);

    }


    @Click(R.id.btn_home)
    public void goNext(){
//        getFragmentManager()
//                .beginTransaction()
//                .replace(R.id.contentPanel,new HomeSubFragment())
//                .addToBackStack(null)
//                .commit();
    }

    @Click(R.id.btn_back)
    public void goBack(){

    }

}
