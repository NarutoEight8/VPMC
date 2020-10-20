package com.naruto.dispatchersample;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.naruto.vpmc.VPMCActivity;
import com.naruto.vpmc.VPMCPresenter;


public class MainActivity extends VPMCActivity<MainVPMCPresenter> {
    private TextView txt_result,txt_name;
    private Button btn_start,btn_switch;
    private EditText edit_input;

    @Override
    protected int onCreateViewByID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        txt_name = findViewById(R.id.txt_name);
        txt_result = findViewById(R.id.txt_result);
        btn_start = findViewById(R.id.btn_start);
        btn_switch = findViewById(R.id.btn_switch);
        edit_input = findViewById(R.id.edit_input);
        txt_name.setText("Activity:"+MainActivity.class.getSimpleName());
    }

    @Override
    protected void initEvents() {
        btn_start.setOnClickListener(this);
        btn_switch.setOnClickListener(this);
    }
    public void doingSth(){

    }


    @Override
    public void onClick(View v) {
        if(v==btn_start){
            mPresenter.doingSth();
            txt_result.setText("结果："+ edit_input.getText().toString().trim());
        }else if(v==btn_switch){
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
