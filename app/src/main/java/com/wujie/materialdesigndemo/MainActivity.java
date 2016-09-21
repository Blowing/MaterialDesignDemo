package com.wujie.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import com.wujie.materialdesigndemo.fragment.PlugFragment;
import com.wujie.materialdesigndemo.fragment.RouterFragment;
import com.wujie.materialdesigndemo.fragment.UsbFragment;
import com.wujie.materialdesigndemo.fragment.UtilFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction ;
    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initView();
        popupWindow = new PopupWindow(getLayoutInflater().inflate(R.layout.layout, null), 300,300);

    }

    private void initFragment () {
        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        RouterFragment routerFragment = new RouterFragment();
        mTransaction.add(R.id.frame_content, routerFragment);
        mTransaction.addToBackStack("router");
        mTransaction.commit();
    }

    private void initView () {
        findViewById(R.id.btn_pluging).setOnClickListener(this);
        findViewById(R.id.btn_router).setOnClickListener(this);
        findViewById(R.id.btn_usb).setOnClickListener(this);
        findViewById(R.id.btn_util).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment mFragment = null;
        mTransaction = mFragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.btn_pluging:

                mFragment = new PlugFragment();
                mTransaction.addToBackStack("plug");
                break;
            case R.id.btn_router:
                mFragment = new RouterFragment();
                mTransaction.addToBackStack("router");
                break;
            case R.id.btn_util:
                mFragment = new UtilFragment();
                mTransaction.addToBackStack("util");
                break;
            case R.id.btn_usb:
                mFragment = new UsbFragment();
                mTransaction.addToBackStack("usb");
                break;
        }

       // mTransaction.detach(mFragment);
//        mTransaction.replace(R.id.frame_content, mFragment);
//        mTransaction.commit();
        startActivity(new Intent(this, ViedeoActivity.class));
        //popupWindow.showAtLocation(findViewById(R.id.btn_pluging), Gravity.CENTER_VERTICAL, 1, 2);
    }
}
