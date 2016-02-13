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

public class SearchRulesActivity extends Activity
{
  Button btn;
  EditText et1;
  WebView webview;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903045);
    getActionBar().setTitle("Companies Act, 2013");
    this.btn = ((Button)findViewById(2131230723));
    this.et1 = ((EditText)findViewById(2131230724));
    this.webview = ((WebView)findViewById(2131230720));
    this.webview.loadUrl("file:///android_asset/Rulesearch.html");
    this.webview.getSettings().setBuiltInZoomControls(true);
    this.btn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = "rule_" + SearchRulesActivity.this.et1.getText().toString() + ".html";
        SearchRulesActivity.this.webview.loadUrl("file:///android_asset/" + str);
      }
    });
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\nca-dex2jar.jar
 * Qualified Name:     com.anmolinc.nca2013.SearchRulesActivity
 * JD-Core Version:    0.6.2
 */