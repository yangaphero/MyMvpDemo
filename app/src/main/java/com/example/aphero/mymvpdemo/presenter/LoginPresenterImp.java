package com.example.aphero.mymvpdemo.presenter;

import com.example.aphero.mymvpdemo.model.ILoginModel;
import com.example.aphero.mymvpdemo.model.LoginModelImp;
import com.example.aphero.mymvpdemo.view.ILogview;

/**
 * Created by aphero on 17-5-24.
 */

public class LoginPresenterImp implements ILoginPresenter{
    private ILogview mILoginview;
    private ILoginModel mILoginmodel;

    public LoginPresenterImp(ILogview mILoginview){
        this.mILoginview=mILoginview;
        this.mILoginmodel= new LoginModelImp(this);
    }

    public void startlogin(String username,String password){
        mILoginmodel.login(username,password);
    }

    @Override
    public void showprogress(boolean flag) {
        mILoginview.loginprogress(flag);
    }

    @Override
    public void handlerprogress(int count) {
        mILoginview.handlerprogress(count);
    }

    @Override
    public void loginsucess() {
        mILoginview.loginsucess();
    }

    @Override
    public void loginfail() {
        mILoginview.loginfail();
    }
}
