package com.example.mvplogin.Presenter;

import com.example.mvplogin.Model.LoginInteractor;
import com.example.mvplogin.View.LoginView;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void onUserNameError() {
        if (loginView!=null){
            loginView.setUserNameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView!=null){
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView!=null){
            loginView.navegateToHome();
            loginView.hideProgress();
        }

    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView!=null){
            loginView.showProgress();
        }
        loginInteractor.login(username,password,this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }
}
