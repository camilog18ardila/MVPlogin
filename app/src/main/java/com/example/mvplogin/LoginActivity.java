package com.example.mvplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvplogin.Model.LoginInteractorImpl;
import com.example.mvplogin.Presenter.LoginPresenter;
import com.example.mvplogin.Presenter.LoginPresenterImpl;
import com.example.mvplogin.View.LoginView;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText usuario, password;
    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        usuario= (EditText) findViewById(R.id.etusuario);
        password=(EditText) findViewById(R.id.etcontraseña);

        findViewById(R.id.btningresar).setOnClickListener(this);

        presenter= new LoginPresenterImpl(this, new LoginInteractorImpl());

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        presenter.validateCredentials(usuario.getText().toString(),password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        usuario.setError("Error de usuario");
    }

    @Override
    public void setPasswordError() {
        password.setError("Error de contraseña");
    }

    @Override
    public void navegateToHome() {
        Toast.makeText(this, "Ingreso correctamente  "+usuario.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}