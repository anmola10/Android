package com.anmolinc.nca2013;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class UIActivity extends Activity
{
  Button abt;
  Button btn;
  Button exit;
  LinearLayout layout;
  Button rate;
  Button rules;
  Button schedbtn;
  Button searchbtn;

  public void onBackPressed()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Companies Act - 2013");
    localBuilder.setMessage("Do you want to exit application?").setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        UIActivity.this.finish();
      }
    }).setNeutralButton("Rate App", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse("market://details?id=com.anmolinc.nca2013"));
        UIActivity.this.startActivity(localIntent);
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
    setContentView(2130903048);
    getActionBar().setTitle("Companies Act, 2013");
    this.btn = ((Button)findViewById(2131230723));
    this.btn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(UIActivity.this, ChapterActivity.class);
        UIActivity.this.startActivity(localIntent);
      }
    });
    this.schedbtn = ((Button)findViewById(2131230725));
    this.schedbtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(UIActivity.this, SchedActivity.class);
        UIActivity.this.startActivity(localIntent);
      }
    });
    this.abt = ((Button)findViewById(2131230727));
    this.abt.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(UIActivity.this, AboutActivity.class);
        localIntent.putExtra("s", "About.html");
        UIActivity.this.startActivity(localIntent);
      }
    });
    this.exit = ((Button)findViewById(2131230729));
    this.exit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UIActivity.this.finish();
      }
    });
    this.rules = ((Button)findViewById(2131230726));
    this.rules.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(UIActivity.this, RulesActivity.class);
        UIActivity.this.startActivity(localIntent);
      }
    });
    this.rate = ((Button)findViewById(2131230728));
    this.rate.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse("market://details?id=com.anmolinc.nca2013"));
        UIActivity.this.startActivity(localIntent);
      }
    });
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131165193, paramMenu);
    return true;
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131230730:
    }
    while (true)
    {
      return super.onMenuItemSelected(paramInt, paramMenuItem);
      finish();
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131230731:
    case 2131230732:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      startActivity(new Intent(this, SearchActivity.class));
      return true;
      Intent localIntent = new Intent(this, AboutActivity.class);
      localIntent.putExtra("s", "About.html");
      startActivity(localIntent);
    }
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\nca-dex2jar.jar
 * Qualified Name:     com.anmolinc.nca2013.UIActivity
 * JD-Core Version:    0.6.2
 */