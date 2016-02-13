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

public class SchedViewActivity extends Activity
{
  WebView webview;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    getActionBar().setTitle("Companies Act, 2013");
    String str = getIntent().getExtras().getString("s");
    this.webview = ((WebView)findViewById(2131230720));
    this.webview.loadUrl("file:///android_asset/" + str);
    this.webview.getSettings().setBuiltInZoomControls(true);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131165188, paramMenu);
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
    startActivity(new Intent(this, SearchSchedActivity.class));
    return true;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\nca-dex2jar.jar
 * Qualified Name:     com.anmolinc.nca2013.SchedViewActivity
 * JD-Core Version:    0.6.2
 */