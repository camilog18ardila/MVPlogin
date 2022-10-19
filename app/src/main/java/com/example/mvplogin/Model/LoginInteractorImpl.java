package com.example.mvplogin.Model;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractorImpl implements LoginInteractor{
    @Override
    public void login(String username, String password, OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(TextUtils.isEmpty(username)){
                    listener.onUserNameError();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    return;
                }
                listener.onSuccess();
            }
        },1000);
    }
}
