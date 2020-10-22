package com.naruto.dispatchersample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.naruto.dispatchersample.databinding.ActivityMainBinding;
import com.naruto.vpmc.VPMCFragment;
import com.naruto.vpmc.VPMCPresenter;

public class MainFragment extends VPMCFragment {

    private ActivityMainBinding binding;

    @Override
    protected ViewBinding getBinding(LayoutInflater inflater, ViewGroup container) {
        binding = ActivityMainBinding.inflate(inflater,container,false);//R.layout.activity_main
        return binding;
    }


    @Override
    protected void initViews() {
    }

    public void initEvents() {
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    protected VPMCPresenter getmPresenterInstance() {
        return null;
    }



}
