package com.example.personaldiary;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PassActivity extends Activity
{
  EditText mail;
  Button send;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903048);
    this.send = ((Button)findViewById(2131296261));
    this.mail = ((EditText)findViewById(2131296259));
    this.send.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.SENDTO");
        localIntent.setType("text/plain");
        localIntent.putExtra("android.intent.extra.SUBJECT", "Password");
        localIntent.putExtra("android.intent.extra.TEXT", "Your Temporary password is:V2C092");
        localIntent.setData(Uri.parse("mailto:" + PassActivity.this.mail.getText().toString()));
        localIntent.addFlags(268435456);
        PassActivity.this.startActivity(localIntent);
      }
    });
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230728, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131296282)
      return true;
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.PassActivity
 * JD-Core Version:    0.6.2
 */