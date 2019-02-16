package com.gameapp.web.mywebviewgamb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

import android.widget.ProgressBar;

public class MyWebViewGamb{
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    MyWebViewGamb(WebView webView,
                  Context context,
                  AppCompatActivity myAppCompatActivity,
                  ProgressBar pB,
                  ValueCallback<Uri> mUploadMessage,
                  ValueCallback<Uri[]> uploadMessage,
                  int REQUEST_SELECT_FILE,
                  int FILECHOOSER_RESULTCODE) {

        this.webView = webView;

        WebSettings mySettings = this.webView.getSettings();

        mySettings.setJavaScriptEnabled(true);
        mySettings.setDomStorageEnabled(true);
        mySettings.setPluginState(WebSettings.PluginState.ON);
        mySettings.setAllowFileAccess(true);
        mySettings.setSaveFormData(true);
        mySettings.setAllowContentAccess(true);
        mySettings.setBuiltInZoomControls(true);
        mySettings.setDisplayZoomControls(false);

        this.webView.setWebViewClient(new MyWebViewClient(pB));
        this.webView.setWebChromeClient(new MyWebChromeClient(context,
                myAppCompatActivity,
                mUploadMessage,
                uploadMessage,
                REQUEST_SELECT_FILE,
                FILECHOOSER_RESULTCODE));

    }

    public WebView getWebView() {
        return webView;
    }
}
