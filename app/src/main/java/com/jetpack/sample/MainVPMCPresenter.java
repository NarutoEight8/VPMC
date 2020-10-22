package com.jetpack.sample;

import android.util.Log;

import com.jetpack.vpmc.VPMCPresenter;

public class MainVPMCPresenter extends VPMCPresenter<MainActivity> {

    public void doingSth(){
        Log.e("AA","BB");
        mView.doingSth();
    }
}
