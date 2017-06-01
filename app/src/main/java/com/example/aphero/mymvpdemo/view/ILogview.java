package com.example.aphero.mymvpdemo.view;

/**
 * Created by aphero on 17-5-24.
 */

public interface ILogview {

    void loginprogress(boolean flag);

    void handlerprogress(int count);

    void loginsucess();

    void loginfail();

}
