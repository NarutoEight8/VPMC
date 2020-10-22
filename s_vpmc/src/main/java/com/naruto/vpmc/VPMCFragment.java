package com.naruto.vpmc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

/**

 private ActivityMainBinding binding;

 @Override
 protected ViewBinding getBinding(LayoutInflater inflater, ViewGroup container) {
 binding = ActivityMainBinding.inflate(inflater,container,false);//R.layout.activity_main
 return binding;
 }

 */
public abstract class VPMCFragment<P extends VPMCPresenter> extends Fragment implements View.OnClickListener {
    public P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewBinding viewBinding = getBinding(inflater,container);
        mPresenter = getmPresenterInstance();
        if(mPresenter!=null)mPresenter.bindView(this);
        initViews();
        initEvents();
        return viewBinding.getRoot();
    }

    @Override
    public void onDestroy() {
        if(mPresenter!=null)mPresenter.unBindView();
        super.onDestroy();
    }

    protected abstract ViewBinding getBinding(LayoutInflater inflater, ViewGroup container);
    protected abstract void initViews();
    protected abstract void initEvents();
    protected abstract P getmPresenterInstance();
}