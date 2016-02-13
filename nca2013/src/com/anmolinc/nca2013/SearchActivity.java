package com.anmolinc.nca2013;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends Activity
{
  Button btn;
  EditText et1;
  WebView webview;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903044);
    getActionBar().setTitle("Companies Act, 2013");
    this.btn = ((Button)findViewById(2131230723));
    this.et1 = ((EditText)findViewById(2131230724));
    this.webview = ((WebView)findViewById(2131230720));
    this.webview.loadUrl("file:///android_asset/Sectionsearch.html");
    this.webview.getSettings().setBuiltInZoomControls(true);
    this.btn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = "Section_" + SearchActivity.this.et1.getText().toString() + ".html";
        SearchActivity.this.webview.loadUrl("file:///android_asset/" + str);
      }
    });
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131165189, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    paramMenuItem.getItemId();
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\nca-dex2jar.jar
 * Qualified Name:     com.anmolinc.nca2013.SearchActivity
 * JD-Core Version:    0.6.2
 */