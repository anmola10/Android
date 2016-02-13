package com.anmolinc.nca2013;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ProgressBar;

public class MainActivity extends Activity
{
  ProgressBar pb;
  Thread t;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    getActionBar().setTitle("Companies Act, 2013");
    this.pb = ((ProgressBar)findViewById(2131230722));
    this.t = new Thread()
    {
      public void run()
      {
        try
        {
          Thread.sleep(2000L);
          Intent localIntent = new Intent(MainActivity.this, UIActivity.class);
          MainActivity.this.finish();
          MainActivity.this.startActivity(localIntent);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    };
    this.t.start();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131165186, paramMenu);
    return true;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\nca-dex2jar.jar
 * Qualified Name:     com.anmolinc.nca2013.MainActivity
 * JD-Core Version:    0.6.2
 */