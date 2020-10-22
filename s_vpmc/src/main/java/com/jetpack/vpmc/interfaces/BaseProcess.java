package com.jetpack.vpmc.interfaces;

import androidx.annotation.CallSuper;

public abstract class BaseProcess{
    public static final int RESULT_RUNNING = 2;//检测中
    public static final int RESULT_STOPED = 0;//0未检完
    public static final int RESULT_FINISHED_SUCESS = 1;//1合格
    public static final int RESULT_FINISHED_FAILED = -1;//-1不合格
    public int currentResult = 0;
    public int tickTime = 0;//一般用于倒计时的tick
    public int progressNum = -1;//当前进入了哪个步骤
    protected OnProcessListener onProcessListener;

    /**外部使用启动**/
    @CallSuper
    public void startProcess(OnProcessListener listener) {
        onProcessListener = listener;
        currentResult = RESULT_RUNNING;
        tickTime = 0;
        progressNum = 1;
        addTickListener();
    }
    /**外部使用停止**/
    @CallSuper
    public void stopProcessOut(){
        runCheckStop(0,"手动停止");
    }
    @CallSuper
    protected void runCheckStop(int resultValue,String reason) {
        removeTickListener();
        currentResult = resultValue;
        progressNum = 0;
        switch (resultValue){
            case RESULT_STOPED:
                if(onProcessListener !=null) onProcessListener.onResultStoped(reason);
                break;
            case RESULT_FINISHED_SUCESS:
                if(onProcessListener !=null) onProcessListener.onResultSucess(reason);
                break;
            case RESULT_FINISHED_FAILED:
                if(onProcessListener !=null) onProcessListener.onResultFailed(reason);
                break;
        }
    }

    protected abstract void addTickListener();
    protected abstract void removeTickListener();
    protected abstract void runTick();

    public interface OnProcessListener {
        void onNeedShowTips(String tips);//运行时提示
        void onResultSucess(String tips);//检测结果
        void onResultFailed(String tips);//检测结果
        void onResultStoped(String tips);//手动停止
        void onOtherControl(int controlValue);//其它控制,例需要弹窗提示
    }
}