package com.naruto.dispatchersample;

import android.util.Log;

import com.naruto.vpmc.VPMCPresenter;

public class MainVPMCPresenter extends VPMCPresenter<MainActivity> {

    public void doingSth(){
        Log.e("AA","BB");
        mView.doingSth();
    }
}
