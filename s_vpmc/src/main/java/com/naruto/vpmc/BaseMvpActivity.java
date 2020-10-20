package com.naruto.vpmc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseMvpActivity<P extends BaseMvpPresenter,CONTRACT> extends Activity implements View.OnClickListener {
    public P mPresenter;
    protected abstract CONTRACT getContract();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onCreateViewByID());
        ButterKnife.bind(this);
        initViews();
        initEvents();
        mPresenter = getmPresenterInstance();
        mPresenter.bindView(this);
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