package com.naruto.vpmc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

public abstract class VPMCFragment<P extends VPMCPresenter> extends Fragment implements View.OnClickListener {
    public P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(onCreateViewByID(), container, false);
        mPresenter = getmPresenterInstance();
        if(mPresenter!=null)mPresenter.bindView(this);
        ButterKnife.bind(this,view);
        initViews();
        initEvents();
        return view;
    }

    @Override
    public void onDestroy() {
        if(mPresenter!=null)mPresenter.unBindView();
        super.onDestroy();
    }

    protected abstract int onCreateViewByID();
    protected abstract void initViews();
    protected abstract void initEvents();
    protected abstract P getmPresenterInstance();
}