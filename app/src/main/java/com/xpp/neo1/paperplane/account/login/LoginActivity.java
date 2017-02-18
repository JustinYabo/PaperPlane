package com.xpp.neo1.paperplane.account.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xpp.neo1.paperplane.R;
import com.xpp.neo1.paperplane.account.register.RegisterActivity;
import com.xpp.neo1.paperplane.app.AppComponent;
import com.xpp.neo1.paperplane.bean.User;
import com.xpp.neo1.paperplane.base.BaseActivity;
import com.xpp.neo1.paperplane.home.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class LoginActivity extends BaseActivity implements LoginContract.View {


    @BindView(R.id.pg_account_loading)
    ProgressBar pgAccountLoading;
    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;

    @Inject
    LoginPresenter mUserLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerLoginActivityComponent
                .builder()
                .loginPresenterModule(new LoginPresenterModule(this))
                .build()
                .inject(this);
    }


    @Override
    public String getUserName() {
        return email.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showLoading() {
        pgAccountLoading.setVisibility(VISIBLE);
    }

    @Override
    public void hideLoading() {
        pgAccountLoading.setVisibility(GONE);
    }

    @Override
    public void toMainActivity(User user) {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toRegisterActivity() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @OnClick(R.id.btn_account_login)
    public void onLogin(View view) {
        mUserLoginPresenter.login(getUserName(), getPassword());
    }

    @OnClick(R.id.btn_account_register)
    public void onRegister(View view) {
        toRegisterActivity();
    }

    @OnClick(R.id.tv_account_forget_pwd)
    public void onForget(View view) {
        toRegisterActivity();
    }

    @Override
    public void initViews() {

    }
}

