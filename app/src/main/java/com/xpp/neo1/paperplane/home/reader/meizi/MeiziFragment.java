package com.xpp.neo1.paperplane.home.reader.meizi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpp.neo1.paperplane.R;
import com.xpp.neo1.paperplane.home.reader.zhihu.DaggerZhihuFragmentComponent;

import javax.inject.Inject;

public class MeiziFragment extends Fragment implements MeiziContract.View {
    @Inject
    MeiziPresenter meiziPresenter;

    public static MeiziFragment newInstance() {
        return new MeiziFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meizi, container, false);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showDatas() {

    }

    @Override
    public void showTimePickerDialog() {

    }

    @Override
    public void initViews() {

    }

    private void setupComponent() {
        DaggerMeiziFragmentComponent
                .builder()
                .meiziPresenerModule(new MeiziPresenerModule(this))
                .build()
                .inject(this);
    }
}
