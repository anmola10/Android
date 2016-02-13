package com.anmolinc.linker;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.print.PrintAttributes.Builder;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class DispActivity extends Activity
{
  String add;
  String beg;
  String course;
  String course2;
  String desig;
  Button done;
  String from;
  String from2;
  String mail;
  String name;
  String org;
  String phone;
  String r1;
  String r2;
  String r3;
  String r4;
  String s1;
  String s2;
  String s3;
  String s4;
  Button save;
  String school;
  String school2;
  String till;
  String to;
  String to2;
  WebView web;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    this.web = ((WebView)findViewById(2130968578));
    SQLiteDatabase localSQLiteDatabase1 = openOrCreateDatabase("project", 0, null);
    localSQLiteDatabase1.execSQL("create table if not exists details(title varchar(20),content varchar(100),password varchar(15) DEFAULT NULL,status varchar(10))");
    Cursor localCursor1 = localSQLiteDatabase1.rawQuery("select * from details", null);
    Cursor localCursor2;
    label83: Cursor localCursor3;
    label120: Cursor localCursor4;
    label157: Cursor localCursor5;
    label194: Cursor localCursor6;
    if (!localCursor1.moveToNext())
    {
      SQLiteDatabase localSQLiteDatabase2 = openOrCreateDatabase("skill", 0, null);
      localSQLiteDatabase2.execSQL("create table if not exists skills(title varchar(20),content varchar(100),password varchar(15) DEFAULT NULL,status varchar(10))");
      localCursor2 = localSQLiteDatabase2.rawQuery("select * from skills", null);
      if (localCursor2.moveToNext())
        break label382;
      SQLiteDatabase localSQLiteDatabase3 = openOrCreateDatabase("three", 0, null);
      localSQLiteDatabase3.execSQL("create table if not exists acad(title varchar(20),content varchar(100),password varchar(15) DEFAULT NULL,status varchar(10))");
      localCursor3 = localSQLiteDatabase3.rawQuery("select * from acad", null);
      if (localCursor3.moveToNext())
        break label433;
      SQLiteDatabase localSQLiteDatabase4 = openOrCreateDatabase("three2", 0, null);
      localSQLiteDatabase4.execSQL("create table if not exists acad2(title varchar(20),content varchar(100),password varchar(15) DEFAULT NULL,status varchar(10))");
      localCursor4 = localSQLiteDatabase4.rawQuery("select * from acad2", null);
      if (localCursor4.moveToNext())
        break label484;
      SQLiteDatabase localSQLiteDatabase5 = openOrCreateDatabase("five", 0, null);
      localSQLiteDatabase5.execSQL("create table if not exists refs(title varchar(20),content varchar(100),password varchar(15) DEFAULT NULL,status varchar(10))");
      localCursor5 = localSQLiteDatabase5.rawQuery("select * from refs", null);
      if (localCursor5.moveToNext())
        break label535;
      SQLiteDatabase localSQLiteDatabase6 = openOrCreateDatabase("two", 0, null);
      localSQLiteDatabase6.execSQL("create table if not exists info(title varchar(20),content varchar(100),password varchar(15) DEFAULT NULL,status varchar(10))");
      localCursor6 = localSQLiteDatabase6.rawQuery("select * from info", null);
      label231: if (localCursor6.moveToNext())
        break label586;
      this.save = ((Button)findViewById(2130968579));
      this.done = ((Button)findViewById(2130968580));
      this.web.getSettings().setJavaScriptEnabled(true);
    }
    for (int i = 0; ; i++)
    {
      if (i >= 10)
      {
        Button localButton1 = this.save;
        View.OnClickListener local1 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Toast.makeText(DispActivity.this, "Saved", 1).show();
            PrintManager localPrintManager = (PrintManager)DispActivity.this.getSystemService("print");
            PrintDocumentAdapter localPrintDocumentAdapter = DispActivity.this.web.createPrintDocumentAdapter();
            localPrintManager.print(DispActivity.this.getString(2131099648) + " Print Test", localPrintDocumentAdapter, new PrintAttributes.Builder().build());
          }
        };
        localButton1.setOnClickListener(local1);
        Button localButton2 = this.done;
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Intent localIntent = new Intent(DispActivity.this, HomeActivity.class);
            DispActivity.this.startActivity(localIntent);
          }
        };
        localButton2.setOnClickListener(local2);
        return;
        this.org = localCursor1.getString(0);
        this.desig = localCursor1.getString(1);
        this.beg = localCursor1.getString(2);
        this.till = localCursor1.getString(3);
        break;
        label382: this.s1 = localCursor2.getString(0);
        this.s2 = localCursor2.getString(1);
        this.s3 = localCursor2.getString(2);
        this.s4 = localCursor2.getString(3);
        break label83;
        label433: this.course = localCursor3.getString(0);
        this.school = localCursor3.getString(1);
        this.from = localCursor3.getString(2);
        this.to = localCursor3.getString(3);
        break label120;
        label484: this.course2 = localCursor4.getString(0);
        this.school2 = localCursor4.getString(1);
        this.from2 = localCursor4.getString(2);
        this.to2 = localCursor4.getString(3);
        break label157;
        label535: this.r1 = localCursor5.getString(0);
        this.r2 = localCursor5.getString(1);
        this.r3 = localCursor5.getString(2);
        this.r4 = localCursor5.getString(3);
        break label194;
        label586: this.name = localCursor6.getString(0);
        this.phone = localCursor6.getString(1);
        this.add = localCursor6.getString(2);
        this.mail = localCursor6.getString(3);
        break label231;
      }
      String str = "<html><head><center><h1>" + this.name + "</h1></head><body><p/>" + this.add + " <br/>" + this.phone + "<br/>" + this.mail + "</center><p/><h3>Work Experience</h3><hr/><p/><h4>" + this.org + "," + this.beg + "-" + this.till + "</h4><p/><ul><li>" + this.desig + "</ul><p/><h3>Education<hr/></h3><p/><ul><li>" + this.course + "<br/><li>" + this.school + "<li>" + this.from + "-" + this.to + "</ul><p/><h3>Skills<hr/></h3><p/><ul><li>" + this.s1 + "<br/><li>" + this.s2 + "<br/><li>" + this.s3 + "<br/><li>" + this.s4 + "<br/></ul></body></html>";
      this.web.loadData(str, "text/html", "UTF-8");
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230722, paramMenu);
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
 * Qualified Name:     com.anmolinc.linker.DispActivity
 * JD-Core Version:    0.6.2
 */