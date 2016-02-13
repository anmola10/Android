package com.example.personaldiary;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditContentActivity extends Activity
{
  String Matter;
  Button btn;
  EditText et1;
  EditText et2;
  String newmatter;
  String newtitle;
  String titlename;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903044);
    this.et1 = ((EditText)findViewById(2131296259));
    this.et2 = ((EditText)findViewById(2131296260));
    this.btn = ((Button)findViewById(2131296261));
    SQLiteDatabase localSQLiteDatabase = openOrCreateDatabase("project", 0, null);
    this.titlename = getIntent().getExtras().getString("title");
    try
    {
      Cursor localCursor = localSQLiteDatabase.rawQuery("select * from details where title like '" + this.titlename + "' ", null);
      while (true)
      {
        if (!localCursor.moveToNext())
        {
          this.et2.setText(this.Matter);
          this.et1.setText(this.titlename);
          this.btn.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              SQLiteDatabase localSQLiteDatabase = EditContentActivity.this.openOrCreateDatabase("project", 0, null);
              EditContentActivity.this.newtitle = EditContentActivity.this.et1.getText().toString();
              EditContentActivity.this.newmatter = EditContentActivity.this.et2.getText().toString();
              localSQLiteDatabase.execSQL("update details set title = '" + EditContentActivity.this.newtitle + "',content = '" + EditContentActivity.this.newmatter + "'  where title like '" + EditContentActivity.this.titlename + "' ");
              Toast.makeText(EditContentActivity.this, "updated", 3000).show();
              Intent localIntent = new Intent(EditContentActivity.this, MainActivity.class);
              EditContentActivity.this.finish();
              EditContentActivity.this.startActivity(localIntent);
            }
          });
          return;
        }
        this.Matter = localCursor.getString(1);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        Toast.makeText(this, "error occured", 3000).show();
      }
    }
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.EditContentActivity
 * JD-Core Version:    0.6.2
 */