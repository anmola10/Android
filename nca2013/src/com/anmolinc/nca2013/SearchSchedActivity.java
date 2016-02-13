package com.anmolinc.nca2013;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SearchSchedActivity extends Activity
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
    this.webview.loadUrl("file:///android_asset/Schedsearch.html");
    this.webview.getSettings().setBuiltInZoomControls(true);
    this.btn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = "Schedule_" + SearchSchedActivity.this.et1.getText().toString() + ".html";
        SearchSchedActivity.this.webview.loadUrl("file:///android_asset/" + str);
      }
    });
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\nca-dex2jar.jar
 * Qualified Name:     com.anmolinc.nca2013.SearchSchedActivity
 * JD-Core Version:    0.6.2
 */