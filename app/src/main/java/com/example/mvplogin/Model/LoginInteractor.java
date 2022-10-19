package com.example.mvplogin.Model;

public interface LoginInteractor {
    //se crea una subinterfaz una vez que se realiza el login
    interface OnLoginFinishedListener{

        void onUserNameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
