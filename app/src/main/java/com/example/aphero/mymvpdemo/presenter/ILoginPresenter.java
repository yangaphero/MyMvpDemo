package com.example.aphero.mymvpdemo.presenter;

/**
 * Created by aphero on 17-5-24.
 */

public interface ILoginPresenter {

    void showprogress(boolean flag);

    void handlerprogress(int count);

    void loginsucess();

    void loginfail();

}
