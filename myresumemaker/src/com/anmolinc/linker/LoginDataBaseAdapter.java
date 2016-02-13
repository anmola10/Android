package com.anmolinc.linker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataBaseAdapter
{
  static final String DATABASE_CREATE = "create table LOGIN( ID integer primary key autoincrement,USERNAME  text,PASSWORD text); ";
  static final String DATABASE_NAME = "login.db";
  static final int DATABASE_VERSION = 1;
  public static final int NAME_COLUMN = 1;
  private final Context context;
  public SQLiteDatabase db;
  private DataBaseHelper dbHelper;

  public LoginDataBaseAdapter(Context paramContext)
  {
    this.context = paramContext;
    this.dbHelper = new DataBaseHelper(this.context, "login.db", null, 1);
  }

  public void close()
  {
    this.db.close();
  }

  public int deleteEntry(String paramString)
  {
    return this.db.delete("LOGIN", "USERNAME=?", new String[] { paramString });
  }

  public SQLiteDatabase getDatabaseInstance()
  {
    return this.db;
  }

  public String getSinlgeEntry(String paramString)
  {
    Cursor localCursor = this.db.query("LOGIN", null, " USERNAME=?", new String[] { paramString }, null, null, null);
    if (localCursor.getCount() < 1)
    {
      localCursor.close();
      return "NOT EXIST";
    }
    localCursor.moveToFirst();
    String str = localCursor.getString(localCursor.getColumnIndex("PASSWORD"));
    localCursor.close();
    return str;
  }

  public void insertEntry(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("USERNAME", paramString1);
    localContentValues.put("PASSWORD", paramString2);
    this.db.insert("LOGIN", null, localContentValues);
  }

  public LoginDataBaseAdapter open()
    throws SQLException
  {
    this.db = this.dbHelper.getWritableDatabase();
    return this;
  }

  public void updateEntry(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("USERNAME", paramString1);
    localContentValues.put("PASSWORD", paramString2);
    this.db.update("LOGIN", localContentValues, "USERNAME = ?", new String[] { paramString1 });
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.LoginDataBaseAdapter
 * JD-Core Version:    0.6.2
 */