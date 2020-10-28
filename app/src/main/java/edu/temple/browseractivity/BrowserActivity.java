package edu.temple.browseractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity implements PageControlFragment.GOBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        PageControlFragment pagec = new PageControlFragment();
        PageViewerFragment pagev = new PageViewerFragment();
        ft.add(R.id.page_control, pagec);
        ft.add(R.id.page_viewer, pagev);
        ft.commit();
    }

    @Override
    public void goBack() {
            PageViewerFragment webview = (PageViewerFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.page_viewer);
            webview.WebViewGoBack();
    }
    @Override
    public void goForward() {
        PageViewerFragment webview = (PageViewerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.page_viewer);
        webview.WebViewGoForward();
    }

    @Override
    public void loadURL(String url) {
        PageViewerFragment webview = (PageViewerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.page_viewer);
        webview.WebViewLoad(url);
    }
}
