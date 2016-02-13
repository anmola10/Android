package com.anmolinc.nca2013;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SchedActivity extends ListActivity
{
  String[] screens = { "Home", "Schedule I", "Schedule II", "Schedule III", "Schedule IV", "Schedule V", "Schedule VI", "Schedule VII", "Exit" };
  WebView webview;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setListAdapter(new ArrayAdapter(this, 17367043, this.screens));
    registerForContextMenu(getListView());
    getActionBar().setTitle("Companies Act, 2013");
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131165192, paramMenu);
    return true;
  }

  protected void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    super.onListItemClick(paramListView, paramView, paramInt, paramLong);
    if (this.screens[paramInt].equals("Home"))
    {
      startActivity(new Intent(this, UIActivity.class));
      return;
    }
    if (this.screens[paramInt].equals("Exit"))
    {
      finish();
      return;
    }
    Toast.makeText(this, this.screens[paramInt], 0).show();
    String str = "Schedule_" + paramInt + ".html";
    try
    {
      Intent localIntent = new Intent(this, SchedViewActivity.class);
      localIntent.putExtra("s", str);
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      Toast.makeText(this, "screen not yet designed", 1).show();
    }
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
 * Qualified Name:     com.anmolinc.nca2013.SchedActivity
 * JD-Core Version:    0.6.2
 */