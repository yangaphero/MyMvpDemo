package com.example.aphero.mymvpdemo.model;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import com.example.aphero.mymvpdemo.presenter.ILoginPresenter;

/**
 * Created by aphero on 17-5-24.
 */

public class LoginModelImp implements ILoginModel {
    private final static String TAG = "LoginModelImp";
    private final Handler mMainHandler;
    private final Handler mhandler;
    private ILoginPresenter mILoginPresenter;
    private int count = 0;
    private String username;
    private String password;

    public LoginModelImp(ILoginPresenter mILoginpresenter){
        HandlerThread mHandlerThread = new HandlerThread("loginmodel");
        mHandlerThread.start();
        mhandler = new Handler(mHandlerThread.getLooper());
        mMainHandler = new Handler(Looper.getMainLooper());
        this.mILoginPresenter=mILoginpresenter;

    }


    @Override
    public void login(String username, String password) {
        mILoginPresenter.showprogress(true);
        mhandler.post(loginRunable);
        this.username=username;
        this.password=password;
        count = 0;

    }

    private void postprogress(final int count){
        mMainHandler.post(new Runnable() {
            @Override
            public void run() {
                mILoginPresenter.handlerprogress(count);
            }
        });

    }



    private Runnable loginRunable = new Runnable() {
        @Override
        public void run() {
            postprogress(count);
            count++;
            if(count <=100) mhandler.postDelayed(loginRunable,50);
            if(count >100) {
                if (!username.isEmpty() && !password.isEmpty())
                    mILoginPresenter.loginsucess();
                else
                    mILoginPresenter.loginfail();
            }
        }
    };

}
