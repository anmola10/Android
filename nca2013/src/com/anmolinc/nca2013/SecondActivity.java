package com.anmolinc.nca2013;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SecondActivity extends Activity
{
  int back = 0;
  WebView webview;

  public void onBackPressed()
  {
    this.back = (1 + this.back);
    if (this.back == 1)
    {
      str = getIntent().getExtras().getString("s");
      this.webview = ((WebView)findViewById(2131230720));
      this.webview.loadUrl("file:///android_asset/" + str);
    }
    while (this.back <= 1)
    {
      String str;
      return;
    }
    startActivity(new Intent(this, ChapterActivity.class));
    finish();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    String str = getIntent().getExtras().getString("s");
    getActionBar().setTitle("Companies Act, 2013");
    this.webview = ((WebView)findViewById(2131230720));
    this.webview.loadUrl("file:///android_asset/" + str);
    this.webview.getSettings().setBuiltInZoomControls(true);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131165192, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131230731:
    }
    startActivity(new Intent(this, SearchActivity.class));
    return true;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\nca-dex2jar.jar
 * Qualified Name:     com.anmolinc.nca2013.SecondActivity
 * JD-Core Version:    0.6.2
 */