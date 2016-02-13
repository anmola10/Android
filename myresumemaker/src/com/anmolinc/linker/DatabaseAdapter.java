package com.anmolinc.linker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAdapter
{
  SQLiteDatabase dbase;
  DatabaseOpenHelper dbhelper;

  public DatabaseAdapter(Context paramContext)
  {
    this.dbhelper = new DatabaseOpenHelper(paramContext);
  }

  public void close()
  {
    this.dbase.close();
  }

  public boolean deletedata(long paramLong)
  {
    return this.dbase.delete("Register", "_id=?" + paramLong, null) > 0;
  }

  public Cursor fetchid(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = this.dbase;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramString1);
    arrayOfString[1] = String.valueOf(paramString2);
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from Register where Pass=? and Fname=?", arrayOfString);
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      return localCursor;
    }
    localCursor.moveToFirst();
    return localCursor;
  }

  public long insertRegister(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("Fname", paramString1);
    localContentValues.put("Pass", paramString2);
    return this.dbase.insert("Register", null, localContentValues);
  }

  public void open()
  {
    this.dbase = this.dbhelper.getWritableDatabase();
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.DatabaseAdapter
 * JD-Core Version:    0.6.2
 */