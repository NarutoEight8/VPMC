package com.naruto.vpmc;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class VPMCActivity<P extends VPMCPresenter> extends AppCompatActivity implements View.OnClickListener {
    public P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onCreateViewByID());
        mPresenter = getmPresenterInstance();
        if(mPresenter!=null)mPresenter.bindView(this);
        ButterKnife.bind(this);
        initViews();
        initEvents();
    }

    @Override
    protected void onDestroy() {
        mPresenter.unBindView();
        super.onDestroy();
    }

    protected abstract int onCreateViewByID();
    protected abstract void initViews();
    protected abstract void initEvents();
    protected abstract P getmPresenterInstance();
}