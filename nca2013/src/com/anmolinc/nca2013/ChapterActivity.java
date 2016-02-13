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

public class ChapterActivity extends ListActivity
{
  String[] screens = { "Home", "Chapter 1 (Sections 1 to 2)", "Chapter 2 (Sections 3 to 22)", "Chapter 3 (Sections 23 to 42)", "Chapter 4 (Sections 43 to 72)", "Chapter 5 (Sections 73 to 76)", "Chapter 6 (Sections 77 to 87)", "Chapter 7 (Sections 88 to 122)", "Chapter 8 (Sections 123 to 127)", "Chapter 9 (Sections 128 to 138)", "Chapter 10 (Sections 139 to 148)", "Chapter 11 (Sections 149 to 172)", "Chapter 12 (Sections 173 to 195)", "Chapter 13 (Sections 196 to 205)", "Chapter 14 (Sections 206 to 229)", "Chapter 15 (Sections 230 to 240)", "Chapter 16 (Sections 241 to 246)", "Chapter 17 (Sections 247 to 247)", "Chapter 18 (Sections 248 to 252)", "Chapter 19 (Sections 253 to 269)", "Chapter 20 (Sections 270 to 365)", "Chapter 21 (Sections 366 to 378)", "Chapter 22 (Sections 379 to 393)", "Chapter 23 (Sections 394 to 395)", "Chapter 24 (Sections 396 to 404)", "Chapter 25 (Sections 405 to 405)", "Chapter 26 (Sections 406 to 406)", "Chapter 27 (Sections 407 to 434)", "Chapter 28 (Sections 435 to 446)", "Chapter 29 (Sections 447 to 470)", "Schedules" };
  WebView webview;

  public void onBackPressed()
  {
    finish();
  }

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
    if (this.screens[paramInt].equals("Schedules"))
    {
      startActivity(new Intent(this, SchedActivity.class));
      return;
    }
    Toast.makeText(this, this.screens[paramInt], 0).show();
    String str = "chap" + paramInt + ".html";
    try
    {
      Intent localIntent = new Intent(this, SecondActivity.class);
      localIntent.putExtra("s", str);
      startActivity(localIntent);
      localIntent.putExtra("pos", paramInt);
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
    startActivity(new Intent(this, SearchActivity.class));
    return true;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\nca-dex2jar.jar
 * Qualified Name:     com.anmolinc.nca2013.ChapterActivity
 * JD-Core Version:    0.6.2
 */