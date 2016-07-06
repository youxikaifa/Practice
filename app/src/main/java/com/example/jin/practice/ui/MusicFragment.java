package com.example.jin.practice.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jin.practice.R;

import org.androidannotations.annotations.EFragment;

/**
 * Created by Jin on 2016/7/5.
 */
@EFragment(R.layout.fragment_music)
public class MusicFragment extends Fragment {

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View musicView =  LayoutInflater.from(mContext).inflate(R.layout.fragment_music,null);

        return musicView;
    }
}
