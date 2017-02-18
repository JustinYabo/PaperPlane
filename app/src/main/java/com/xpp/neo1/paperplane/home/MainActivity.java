package com.xpp.neo1.paperplane.home;

import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xpp.neo1.paperplane.R;
import com.xpp.neo1.paperplane.app.App;
import com.xpp.neo1.paperplane.app.AppComponent;
import com.xpp.neo1.paperplane.base.BaseActivity;
import com.xpp.neo1.paperplane.home.sidebar.bookmarks.BookMarksFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    private MainFragment mainFragment;
    private BookMarksFragment bookMarksFragment;

    private static final String MAIN_FRAGMENT_TAG = "mainFragment";
    private static final String BOOK_MARKS_FRAGMENT_TAG = "bookmarkdFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //设置侧滑栏
        setupDrawerLayout();

        if (savedInstanceState != null) {
            mainFragment = (MainFragment) getSupportFragmentManager().getFragment(savedInstanceState, MAIN_FRAGMENT_TAG);
            bookMarksFragment = (BookMarksFragment) getSupportFragmentManager().getFragment(savedInstanceState, BOOK_MARKS_FRAGMENT_TAG);
        } else {
            mainFragment = MainFragment.newInstance();
            bookMarksFragment = BookMarksFragment.newInstance();
        }
        if (!mainFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, mainFragment, MAIN_FRAGMENT_TAG).commit();
        }
        if (!bookMarksFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, bookMarksFragment, BOOK_MARKS_FRAGMENT_TAG).commit();
        }

        showMainFragment();

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }


    private void showMainFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.show(mainFragment);
        ft.hide(bookMarksFragment);
        ft.commit();

        toolbar.setTitle("纸飞机");
    }

    private void showBookMarksFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.show(bookMarksFragment);
        ft.hide(mainFragment);
        ft.commit();

        toolbar.setTitle("收藏");
    }

    private void setupDrawerLayout() {

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            showMainFragment();
        } else if (id == R.id.nav_bookmarks) {
            showBookMarksFragment();

        } else if (id == R.id.nav_change_theme) {
            //change daytime/night mode after drawer close
            drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
                @Override
                public void onDrawerSlide(View drawerView, float slideOffset) {

                }

                @Override
                public void onDrawerOpened(View drawerView) {

                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {

                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                    } else {

                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                    }

                    getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
                    recreate();
                }

                @Override
                public void onDrawerStateChanged(int newState) {

                }
            });

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_about) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mainFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, MAIN_FRAGMENT_TAG, mainFragment);
        }

        if (bookMarksFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, BOOK_MARKS_FRAGMENT_TAG, bookMarksFragment);
        }
    }
}
