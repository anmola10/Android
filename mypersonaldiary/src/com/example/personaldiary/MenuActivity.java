package com.example.personaldiary;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity
{
  Button about;
  Button add;
  Button exit;
  Button view;

  public void onBackPressed()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("My Personal Diary");
    localBuilder.setMessage("Do you want to exit application?").setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MenuActivity.this.finish();
      }
    }).setNegativeButton("No", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
      }
    });
    localBuilder.create().show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    this.add = ((Button)findViewById(2131296261));
    this.view = ((Button)findViewById(2131296271));
    this.about = ((Button)findViewById(2131296272));
    this.exit = ((Button)findViewById(2131296273));
    this.add.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(MenuActivity.this, AddTitleActivity.class);
        MenuActivity.this.startActivity(localIntent);
      }
    });
    this.view.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(MenuActivity.this, MainActivity.class);
        MenuActivity.this.startActivity(localIntent);
      }
    });
    this.about.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(MenuActivity.this, AboutActivity.class);
        MenuActivity.this.startActivity(localIntent);
      }
    });
    this.exit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MenuActivity.this.finish();
      }
    });
    this.view.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(MenuActivity.this, MainActivity.class);
        MenuActivity.this.startActivity(localIntent);
      }
    });
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230727, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131296282)
      return true;
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.MenuActivity
 * JD-Core Version:    0.6.2
 */