package com.naruto.dispatchersample;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.naruto.dispatchersample.databinding.ActivityMainBinding;
import com.naruto.vpmc.VPMCActivity;
import com.naruto.vpmc.VPMCPresenter;


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
