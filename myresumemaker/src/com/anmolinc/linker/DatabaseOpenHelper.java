package com.anmolinc.linker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOpenHelper extends SQLiteOpenHelper
{
  private static final String Database_Name = "matrimonial.db";
  private static final String Sql_Query2 = "Create Table Register(_id INTEGER PRIMARY KEY AUTOINCREMENT,Fname TEXT, Pass TEXT);";
  private static final String TAG = "DatabaseOpenHelper";
  private static final String Table_Name2 = "Register";

  public DatabaseOpenHelper(Context paramContext)
  {
    super(paramContext, "matrimonial.db", null, 1);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("DatabaseOpenHelper", "Database Created");
    paramSQLiteDatabase.execSQL("Create Table Register(_id INTEGER PRIMARY KEY AUTOINCREMENT,Fname TEXT, Pass TEXT);");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Log.w("DatabaseOpenHelper", "Version Upgraded from " + paramInt1 + " to " + paramInt2);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.DatabaseOpenHelper
 * JD-Core Version:    0.6.2
 */