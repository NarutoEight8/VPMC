package com.naruto.vpmc;

public abstract class BaseMvpPresenter<M extends BaseMvpModel, V ,CONTRACT> extends SupperBase<CONTRACT>{
    public M mModel;
    public V mView;
    public BaseMvpPresenter(){
        this.mModel = getmModelInstance();
    }

    public void bindView(V mView){
        this.mView = mView;
    }
    public void unBindView(){
        this.mView = null;
        this.mModel = null;
    }
    public abstract M getmModelInstance();
//    public abstract CONTRACT getContract();
}
