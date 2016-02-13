package com.example.personaldiary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ViewNotesActivity extends Activity
{
  String Matter;
  String Status;
  String titlename;
  TextView tv1;
  TextView tv2;
  TextView tv3;

  protected void onCreate(Bundle paramBundle)
  {
    SQLiteDatabase localSQLiteDatabase = openOrCreateDatabase("project", 0, null);
    setContentView(2130903050);
    this.tv1 = ((TextView)findViewById(2131296274));
    this.tv2 = ((TextView)findViewById(2131296276));
    this.tv3 = ((TextView)findViewById(2131296275));
    this.titlename = getIntent().getExtras().getString("title");
    try
    {
      Cursor localCursor = localSQLiteDatabase.rawQuery("select * from details where title like '" + this.titlename + "' ", null);
      while (true)
      {
        if (!localCursor.moveToNext())
        {
          if (!this.Status.equals("locked"))
            break;
          this.tv3.setText("**Protected by Password**");
          this.tv1.setText("Title : " + this.titlename);
          this.tv2.setText(this.Matter);
          Toast.makeText(this, this.titlename, 3000).show();
          super.onCreate(paramBundle);
          return;
        }
        this.Matter = localCursor.getString(1);
        this.Status = localCursor.getString(3);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        Toast.makeText(this, "error occured", 3000).show();
        continue;
        this.tv3.setText("**Not Password Protected**");
      }
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230730, paramMenu);
    return true;
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131296285:
    case 2131296286:
    case 2131296287:
    case 2131296289:
    case 2131296288:
    }
    while (true)
    {
      return super.onMenuItemSelected(paramInt, paramMenuItem);
      Intent localIntent5 = new Intent(this, EditContentActivity.class);
      localIntent5.putExtra("title", this.titlename);
      finish();
      startActivity(localIntent5);
      continue;
      Intent localIntent4 = new Intent(this, EditContentActivity.class);
      finish();
      startActivity(localIntent4);
      continue;
      Intent localIntent3 = new Intent(this, MainActivity.class);
      finish();
      startActivity(localIntent3);
      Intent localIntent2 = new Intent("android.intent.action.SENDTO");
      localIntent2.setType("text/plain");
      localIntent2.putExtra("android.intent.extra.SUBJECT", this.tv1.getText().toString());
      localIntent2.putExtra("android.intent.extra.TEXT", this.tv2.getText().toString());
      localIntent2.setData(Uri.parse("mailto:"));
      localIntent2.addFlags(268435456);
      startActivity(localIntent2);
      Intent localIntent1 = new Intent(this, ChangeColorActivity.class);
      finish();
      startActivity(localIntent1);
    }
  }

  protected void onResume()
  {
    super.onResume();
    String str = PreferenceManager.getDefaultSharedPreferences(this).getString("l1", "RED");
    if (str.equals("red"))
      this.tv2.setBackgroundColor(-65536);
    do
    {
      return;
      if (str.equals("blue"))
      {
        this.tv2.setBackgroundColor(-16776961);
        return;
      }
      if (str.equals("white"))
      {
        this.tv2.setBackgroundColor(-1);
        return;
      }
      if (str.equals("green"))
      {
        this.tv2.setBackgroundColor(-16711936);
        return;
      }
      if (str.equals("cyan"))
      {
        this.tv2.setBackgroundColor(-16711681);
        return;
      }
      if (str.equals("yellow"))
      {
        this.tv2.setBackgroundColor(-256);
        return;
      }
    }
    while (!str.equals("black"));
    this.tv2.setBackgroundColor(-16777216);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.ViewNotesActivity
 * JD-Core Version:    0.6.2
 */