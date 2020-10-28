package edu.temple.browseractivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class PageViewerFragment extends Fragment {
WebView webber;

    public PageViewerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View webv = inflater.inflate(R.layout.fragment_page_viewer, container, false);
        WebView webber = webv.findViewById(R.id.webv);
        webber.loadUrl("https://google.com");
        webber.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });


        WebSettings webset = webber.getSettings();
        webset.setJavaScriptEnabled(true);

        return webv;
    }

    public boolean WebViewGoBack() {
        WebView webber = (WebView) getView().findViewById(R.id.webv);
        webber.getSettings().setJavaScriptEnabled(true);
        if(webber.canGoBack()){
            webber.goBack();
            return true;
        }
        return false; //webview cannot go back, so use the method of the BackButton
    }

    public boolean WebViewGoForward() {
        WebView webber = (WebView) getView().findViewById(R.id.webv);
        webber.getSettings().setJavaScriptEnabled(true);
        if(webber.canGoForward()){
            webber.goForward();
            return true;
        }
        return false; //webview cannot go back, so use the method of the BackButton
    }

    public void WebViewLoad(String url){
        WebView webber = (WebView) getView().findViewById(R.id.webv);
        webber.getSettings().setJavaScriptEnabled(true);
        webber.loadUrl(url);
    }

}
