package com.jetpack.sample;

import android.content.Intent;


import androidx.viewbinding.ViewBinding;

import android.view.View;
import com.jetpack.vpmc.VPMCActivity;
import com.naruto.dispatchersample.databinding.ActivityMainBinding;


public class MainActivity extends VPMCActivity<MainVPMCPresenter> {
    private ActivityMainBinding binding;

    @Override
    protected ViewBinding getBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        return binding;//R.layout.activity_main
    }

    @Override
    protected void initViews() {
        binding.txtName.setText("Activity:"+MainActivity.class.getSimpleName());
    }

    @Override
    protected void initEvents() {
        binding.btnStart.setOnClickListener(this);
        binding.btnSwitch.setOnClickListener(this);
    }
    public void doingSth(){

    }


    @Override
    public void onClick(View v) {
        if(v==binding.btnStart){
            mPresenter.doingSth();
            binding.txtResult.setText("结果："+ binding.editInput.getText().toString().trim());
        }else if(v==binding.btnSwitch){
            finish();
            Intent intent = new Intent(MainActivity.this,ActivityNext.class);
            startActivity(intent);
        }
    }
    @Override
    protected MainVPMCPresenter getmPresenterInstance() {
        return new MainVPMCPresenter();
    }
}
