package com.naruto.vpmc;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseMvpFragment<P extends BaseMvpPresenter,CONTRACT> extends Fragment implements View.OnClickListener {
    public P mPresenter;
    protected abstract CONTRACT getContract();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(onCreateViewByID(), container, false);
        ButterKnife.bind(this,view);
        initViews();
        initEvents();
        mPresenter = getmPresenterInstance();
        mPresenter.bindView(this);
        return view;
    }

    @Override
    public void onDestroy() {
        mPresenter.unBindView();
        super.onDestroy();
    }


    protected abstract int onCreateViewByID();
    protected abstract void initViews();
    protected abstract void initEvents();
    protected abstract P getmPresenterInstance();
}