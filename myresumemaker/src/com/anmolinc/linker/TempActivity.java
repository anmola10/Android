package com.anmolinc.linker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TempActivity extends Activity
{
  Button b1;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903048);
    this.b1 = ((Button)findViewById(2130968579));
    Button localButton = (Button)findViewById(2130968580);
    this.b1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(TempActivity.this, DispActivity.class);
        TempActivity.this.startActivity(localIntent);
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(TempActivity.this, Disp2Activity.class);
        TempActivity.this.startActivity(localIntent);
      }
    });
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230735, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2130968616)
      return true;
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.TempActivity
 * JD-Core Version:    0.6.2
 */