package com.example.mvplogin.View;

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUserNameError();

    void setPasswordError();

    void navegateToHome();
}
