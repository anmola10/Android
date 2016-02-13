package com.example.personaldiary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903049);
    new Thread()
    {
      public void run()
      {
        try
        {
          Thread.sleep(2000L);
          Intent localIntent = new Intent(SplashActivity.this, MenuActivity.class);
          SplashActivity.this.finish();
          SplashActivity.this.startActivity(localIntent);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
        }
      }
    }
    .start();
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.SplashActivity
 * JD-Core Version:    0.6.2
 */