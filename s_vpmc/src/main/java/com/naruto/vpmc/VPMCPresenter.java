package com.naruto.vpmc;

public abstract class VPMCPresenter<V>{
    public V mView;

    public void bindView(V mView){
        this.mView = mView;
    }
    public void unBindView(){
        this.mView = null;
    }
}
