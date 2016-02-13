package com.anmolinc.linker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PieGraphActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903045);
    PieGraph localPieGraph = (PieGraph)findViewById(2130968596);
    PieSlice localPieSlice1 = new PieSlice();
    localPieSlice1.setColor(Color.parseColor("#99CC00"));
    localPieSlice1.setValue(2.0F);
    localPieGraph.addSlice(localPieSlice1);
    PieSlice localPieSlice2 = new PieSlice();
    localPieSlice2.setColor(Color.parseColor("#FFBB33"));
    localPieSlice2.setValue(3.0F);
    localPieGraph.addSlice(localPieSlice2);
    PieSlice localPieSlice3 = new PieSlice();
    localPieSlice3.setColor(Color.parseColor("#AA66CC"));
    localPieSlice3.setValue(8.0F);
    localPieGraph.addSlice(localPieSlice3);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230732, paramMenu);
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
 * Qualified Name:     com.anmolinc.linker.PieGraphActivity
 * JD-Core Version:    0.6.2
 */