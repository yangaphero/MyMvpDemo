package com.example.aphero.mymvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aphero.mymvpdemo.R;
import com.example.aphero.mymvpdemo.model.LoginModelImp;
import com.example.aphero.mymvpdemo.presenter.ILoginPresenter;
import com.example.aphero.mymvpdemo.presenter.LoginPresenterImp;

public class MainActivity extends AppCompatActivity implements ILogview, View.OnClickListener {

    private EditText mNameText;
    private EditText mPassText;
    private Button mLoginButton;
    private Button mResetButton;
    private ProgressBar mProgressbar;
    private ProgressBar mProgressbar2;
    private LoginPresenterImp mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewinit();
        mLoginPresenter=new LoginPresenterImp(this);

    }

    private void viewinit() {
        mNameText = (EditText) findViewById(R.id.NameText);
        mPassText = (EditText) findViewById(R.id.PassText);
        mLoginButton = (Button) findViewById(R.id.LoginButton);
        mResetButton = (Button) findViewById(R.id.ResetButton);
        mProgressbar = (ProgressBar) findViewById(R.id.progressbar);
        mProgressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
        mLoginButton.setOnClickListener(this);
        mResetButton.setOnClickListener(this);
    }


    @Override
    public void loginprogress(boolean flag) {
        if (flag) mProgressbar2.setVisibility(View.VISIBLE);
        else mProgressbar2.setVisibility(View.GONE);
    }

    @Override
    public void handlerprogress(int count) {
        mProgressbar2.setProgress(count);
    }

    @Override
    public void loginsucess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginfail() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LoginButton:
                mLoginPresenter.startlogin(mNameText.getText().toString(),mPassText.getText().toString());
                break;
            case R.id.ResetButton:
                mNameText.setText("");
                mPassText.setText("");
                break;
        }
    }
}
