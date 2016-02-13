package com.anmolinc.nca2013;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
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
    getActionBar().setTitle("Companies Act, 2013");
    String str = getIntent().getExtras().getString("s");
    this.webview = ((WebView)findViewById(2131230720));
    this.webview.loadUrl("file:///android_asset/" + str);
    this.webview.getSettings().setBuiltInZoomControls(true);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\nca-dex2jar.jar
 * Qualified Name:     com.anmolinc.nca2013.AboutActivity
 * JD-Core Version:    0.6.2
 */