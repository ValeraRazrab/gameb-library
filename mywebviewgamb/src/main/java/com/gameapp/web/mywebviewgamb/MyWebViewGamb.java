package com.gameapp.web.mywebviewgamb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MyWebViewGamb extends WebView {
    WebSettings mySettings;
    MyWebViewClient myWebViewClient;
    MyWebChromeClient myWebChromeClient;

    @SuppressLint("SetJavaScriptEnabled")
    public MyWebViewGamb(Context context, AppCompatActivity myAppCompatActivity, ProgressBar pB) {
        super(context);

        mySettings = this.getSettings();
        mySettings.setJavaScriptEnabled(true);
        mySettings.setDomStorageEnabled(true);
        mySettings.setPluginState(WebSettings.PluginState.ON);
        mySettings.setAllowFileAccess(true);
        mySettings.setSaveFormData(true);
        mySettings.setAllowContentAccess(true);
        mySettings.setBuiltInZoomControls(true);
        mySettings.setDisplayZoomControls(false);

        this.myWebViewClient = new MyWebViewClient(pB);
        this.myWebChromeClient = new MyWebChromeClient(context, myAppCompatActivity);


    }

    @Override
    public void setWebViewClient(WebViewClient client) {
        super.setWebViewClient(this.myWebViewClient);
    }

    @Override
    public void setWebChromeClient(WebChromeClient client) {
        super.setWebChromeClient(this.myWebChromeClient);
    }
}
