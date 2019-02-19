package com.mysample;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.gameapp.web.mywebviewgamb.MyWebViewGamb;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    Context context;
    AppCompatActivity myAppCompatActivity;
    MyWebViewGamb wB;
    ProgressBar pB;

    private ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> uploadMessage;
    public static final int REQUEST_SELECT_FILE = 100;
    private final static int FILECHOOSER_RESULTCODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        context = this;
        myAppCompatActivity = this;
        pB = findViewById(R.id.progressBar);

        wB = new MyWebViewGamb(webView,
                context,
                myAppCompatActivity,
                pB,
                mUploadMessage,
                uploadMessage,
                REQUEST_SELECT_FILE,
                FILECHOOSER_RESULTCODE);

        webView = wB.getWebView();

        webView.loadUrl("https://uploadfiles.io/https://uploadfiles.io/");


    }
}

    <?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".WebViewActivity">

<ProgressBar
        android:id="@+id/progressBar"
                style="?android:attr/progressBarStyle"
                android:layout_width="102dp"
                android:layout_height="98dp"
                android:layout_marginStart="154dp"
                android:layout_marginLeft="154dp"
                android:layout_marginTop="8dp"
                android:layout_marginEnd="155dp"
                android:layout_marginRight="155dp"
                android:layout_marginBottom="8dp"
                app:layout_constraintBottom_toBottomOf="@+id/webView"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />

<WebView
        android:id="@+id/webView"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent">

</WebView>
</android.support.constraint.ConstraintLayout>