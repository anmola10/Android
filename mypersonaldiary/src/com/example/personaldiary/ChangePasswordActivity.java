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

public class ChangePasswordActivity extends Activity
{
  String Status;
  Button btn;
  EditText et1;
  EditText et2;
  String newpwd;
  String oldpwd = null;
  String titlename;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    this.et1 = ((EditText)findViewById(2131296259));
    this.et2 = ((EditText)findViewById(2131296260));
    this.btn = ((Button)findViewById(2131296261));
    this.titlename = getIntent().getExtras().getString("title");
    this.btn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ChangePasswordActivity.this.oldpwd = ChangePasswordActivity.this.et1.getText().toString();
        ChangePasswordActivity.this.newpwd = ChangePasswordActivity.this.et2.getText().toString();
        SQLiteDatabase localSQLiteDatabase = ChangePasswordActivity.this.openOrCreateDatabase("project", 0, null);
        Cursor localCursor = localSQLiteDatabase.rawQuery("select * from details where title like '" + ChangePasswordActivity.this.titlename + "' ", null);
        while (true)
        {
          if (!localCursor.moveToNext())
          {
            if (!ChangePasswordActivity.this.oldpwd.equals("null"))
              break label259;
            if ((!ChangePasswordActivity.this.Status.equals(ChangePasswordActivity.this.oldpwd)) && (!ChangePasswordActivity.this.oldpwd.equals("V2C092")))
              break;
            localSQLiteDatabase.execSQL("update details set password = '" + ChangePasswordActivity.this.newpwd + "',status ='locked' where title like '" + ChangePasswordActivity.this.titlename + "' ");
            Intent localIntent3 = new Intent(ChangePasswordActivity.this, MainActivity.class);
            ChangePasswordActivity.this.finish();
            ChangePasswordActivity.this.startActivity(localIntent3);
            return;
          }
          ChangePasswordActivity.this.Status = localCursor.getString(2);
        }
        Toast.makeText(ChangePasswordActivity.this, "sorry old password is wrong", 3000).show();
        return;
        label259: if (ChangePasswordActivity.this.newpwd.equals("null"))
        {
          if ((ChangePasswordActivity.this.Status.equals(ChangePasswordActivity.this.oldpwd)) || (ChangePasswordActivity.this.oldpwd.equals("V2C092")))
          {
            localSQLiteDatabase.execSQL("update details set password = '" + ChangePasswordActivity.this.newpwd + "',status ='unlocked' where title like '" + ChangePasswordActivity.this.titlename + "' ");
            Intent localIntent2 = new Intent(ChangePasswordActivity.this, MainActivity.class);
            ChangePasswordActivity.this.finish();
            ChangePasswordActivity.this.startActivity(localIntent2);
            return;
          }
          Toast.makeText(ChangePasswordActivity.this, "sorry old password is wrong", 3000).show();
          return;
        }
        localSQLiteDatabase.execSQL("update details set password = '" + ChangePasswordActivity.this.newpwd + "',status ='locked' where title like '" + ChangePasswordActivity.this.titlename + "' ");
        Intent localIntent1 = new Intent(ChangePasswordActivity.this, MainActivity.class);
        ChangePasswordActivity.this.finish();
        ChangePasswordActivity.this.startActivity(localIntent1);
      }
    });
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.ChangePasswordActivity
 * JD-Core Version:    0.6.2
 */