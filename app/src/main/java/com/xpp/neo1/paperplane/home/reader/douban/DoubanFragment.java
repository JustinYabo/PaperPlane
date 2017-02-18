package com.xpp.neo1.paperplane.home.reader.douban;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpp.neo1.paperplane.R;

public class DoubanFragment extends Fragment implements DoubanContract.View{

    public static DoubanFragment newInstance() {
        return new DoubanFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_douban, container, false);
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
}
