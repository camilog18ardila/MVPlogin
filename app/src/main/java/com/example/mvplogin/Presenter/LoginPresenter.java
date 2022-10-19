package com.example.mvplogin.Presenter;

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
