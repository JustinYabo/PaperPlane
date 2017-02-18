package com.xpp.neo1.paperplane.account.login;

import com.xpp.neo1.paperplane.bean.User;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by neo1 on 2017/2/10.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mLoginView;

    @Inject
    public LoginPresenter(LoginContract.View loginView) {
        this.mLoginView = loginView;
    }

    @Override
    public void login(final String username, final String password) {
        mLoginView.showLoading();
        Maybe.just(isUser(username, password))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Boolean value) {
                        if (value) {
                            User user = new User();
                            user.setUsername(username);
                            user.setPassword(password);
                            mLoginView.toMainActivity(user);
                            mLoginView.hideLoading();
                        } else {
                            mLoginView.showFailedError();
                            mLoginView.hideLoading();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private boolean isUser(String username, String password) {
        return username.equals("xpp") && password.equals("123");
    }

    @Override
    public void start() {

    }
}
