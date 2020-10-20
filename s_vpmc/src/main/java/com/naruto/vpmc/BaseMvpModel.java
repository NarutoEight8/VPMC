package com.naruto.vpmc;

public abstract class BaseMvpModel<P extends BaseMvpPresenter,CONTRACT> extends SupperBase<CONTRACT> {
    public P mPresenter;
    public BaseMvpModel(P mPresenter){
        this.mPresenter = mPresenter;
    }

}
