package com.example.personaldiary;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterContentActivity extends Activity
{
  Button btn;
  String content;
  EditText et;
  String pwd;
  String status;
  String title;
  TextView tv1;
  TextView tv2;

  protected void onCreate(Bundle paramBundle)
  {
    openOrCreateDatabase("project", 2, null).execSQL("create table if not exists details(title varchar,content varchar,password varchar,status varchar)");
    super.onCreate(paramBundle);
    setContentView(2130903045);
    this.tv1 = ((TextView)findViewById(2131296267));
    this.tv2 = ((TextView)findViewById(2131296266));
    this.et = ((EditText)findViewById(2131296269));
    this.btn = ((Button)findViewById(2131296268));
    Bundle localBundle = getIntent().getExtras();
    this.title = localBundle.getString("title");
    this.pwd = localBundle.getString("password");
    this.tv1.setText(this.title);
    String str = localBundle.getString("pwdyes");
    this.tv2.setText(str);
    if (str.equals("Yes"));
    for (this.status = "locked"; ; this.status = "unlocked")
    {
      this.btn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          EnterContentActivity.this.content = EnterContentActivity.this.et.getText().toString();
          EnterContentActivity.this.openOrCreateDatabase("project", 2, null).execSQL("insert into details values('" + EnterContentActivity.this.title + "','" + EnterContentActivity.this.content + "','" + EnterContentActivity.this.pwd + "','" + EnterContentActivity.this.status + "')");
          Toast.makeText(EnterContentActivity.this, "Saved In DataBase", 3000).show();
          Intent localIntent = new Intent(EnterContentActivity.this, MainActivity.class);
          EnterContentActivity.this.finish();
          EnterContentActivity.this.startActivity(localIntent);
        }
      });
      return;
    }
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.EnterContentActivity
 * JD-Core Version:    0.6.2
 */