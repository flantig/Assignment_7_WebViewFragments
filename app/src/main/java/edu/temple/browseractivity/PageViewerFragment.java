package edu.temple.browseractivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.util.PatternsCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.regex.Pattern;


public class PageViewerFragment extends Fragment {
    WebView webber;
    Wave parentActivityInterface;

    public PageViewerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Wave) {
            parentActivityInterface = (Wave) context;
        } else {
            throw new RuntimeException("You must implement ButtonClickInterface to attach this fragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View webv = inflater.inflate(R.layout.fragment_page_viewer, container, false);
        WebView webber = webv.findViewById(R.id.webv);
        webber.loadUrl("https://google.com");
        webber.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                parentActivityInterface.updateText(url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                parentActivityInterface.updateText(url);
            }
        });


        WebSettings webset = webber.getSettings();
        webset.setJavaScriptEnabled(true);
        return webv;
    }

    public boolean WebViewGoBack() {
        WebView webber = (WebView) getView().findViewById(R.id.webv);
        webber.getSettings().setJavaScriptEnabled(true);
        if (webber.canGoBack()) {
            webber.goBack();
            return true;
        }
        return false; //webview cannot go back, so use the method of the BackButton
    }

    public boolean WebViewGoForward() {
        WebView webber = (WebView) getView().findViewById(R.id.webv);
        webber.getSettings().setJavaScriptEnabled(true);
        if (webber.canGoForward()) {
            webber.goForward();
            return true;
        }
        return false; //webview cannot go back, so use the method of the BackButton
    }

    public void WebViewLoad(String url) {
        WebView webber = (WebView) getView().findViewById(R.id.webv);
        webber.getSettings().setJavaScriptEnabled(true);
        if(URLUtil.isValidUrl(url)){
            webber.loadUrl(url);
        } else {
            String httpsURL = "https://" + url;
            String httpURL = "http://" + url;
            if(URLUtil.isValidUrl(httpURL)){
                webber.loadUrl(httpURL);
            } else if (URLUtil.isValidUrl(httpsURL)){
                webber.loadUrl(httpsURL);
            } else {
                webber.loadUrl(url);
            }
        }
    }

    interface Wave { //ROCK SHOOT
        void updateText(String url);
    }

}
