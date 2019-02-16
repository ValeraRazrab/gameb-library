package com.gameapp.web.mywebviewgamb;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;


public class MyWebChromeClient extends WebChromeClient {
    private Context context;
    private AppCompatActivity myAppCompatActivity;

    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> uploadMessage;
    private int REQUEST_SELECT_FILE;
    private int FILECHOOSER_RESULTCODE;

    MyWebChromeClient(Context context,
                      AppCompatActivity myAppCompatActivity,
                      ValueCallback<Uri> mUploadMessage,
                      ValueCallback<Uri[]> uploadMessage,
                      int REQUEST_SELECT_FILE,
                      int FILECHOOSER_RESULTCODE){

        this.context = context;
        this.myAppCompatActivity = myAppCompatActivity;
        this.mUploadMessage = mUploadMessage;
        this.uploadMessage = uploadMessage;
        this.REQUEST_SELECT_FILE = REQUEST_SELECT_FILE;
        this.FILECHOOSER_RESULTCODE = FILECHOOSER_RESULTCODE;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams)
    {
        Toast.makeText(this.context, "Выберете ГАЛЕРЕЮ, чтобы загрузить фото!", Toast.LENGTH_LONG).show();
        if (uploadMessage != null) {
            uploadMessage.onReceiveValue(null);
            uploadMessage = null;
        }

        uploadMessage = filePathCallback;

        Intent intent = fileChooserParams.createIntent();
        try
        {
            this.myAppCompatActivity.startActivityForResult(intent, REQUEST_SELECT_FILE);
        } catch (ActivityNotFoundException e)
        {
            uploadMessage = null;
            Toast.makeText(this.context, "Не могу открыть File Chooser", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture)
    {
        mUploadMessage = uploadMsg;
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        this.myAppCompatActivity.startActivityForResult(Intent.createChooser(intent, "File Browser"), FILECHOOSER_RESULTCODE);
    }

    protected void openFileChooser(ValueCallback uploadMsg, String acceptType)
    {
        mUploadMessage = uploadMsg;
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        this.myAppCompatActivity.startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);
    }

    protected void openFileChooser(ValueCallback<Uri> uploadMsg)
    {
        mUploadMessage = uploadMsg;
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        this.myAppCompatActivity.startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
    }
}
