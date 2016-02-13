package com.anmolinc.linker;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AboutActivity extends Activity
{
  WebView webview;

  public void onBackPressed()
  {
    finish();
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    this.webview = ((WebView)findViewById(2130968578));
    this.webview.loadUrl("file:///android_asset/About.html");
    this.webview.getSettings().setBuiltInZoomControls(true);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.AboutActivity
 * JD-Core Version:    0.6.2
 */