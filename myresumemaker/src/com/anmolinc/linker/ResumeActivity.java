package com.anmolinc.linker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResumeActivity extends Activity
{
  String a;
  Button create;
  String n;
  String name;
  String p;
  String phone;
  Button save;
  TextView sub;
  Button upload;
  WebView web;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903046);
    this.upload = ((Button)findViewById(2130968579));
    this.create = ((Button)findViewById(2130968580));
    this.web = ((WebView)findViewById(2130968578));
    this.sub = ((TextView)findViewById(2130968585));
    this.sub.setMovementMethod(new ScrollingMovementMethod());
    this.save = ((Button)findViewById(2130968583));
    this.save.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Toast.makeText(ResumeActivity.this, "RESUME SAVED", 3000).show();
        Intent localIntent = new Intent(ResumeActivity.this, HomeActivity.class);
        ResumeActivity.this.startActivity(localIntent);
      }
    });
    this.upload.setOnClickListener(new View.OnClickListener()
    {
      final Context context = ResumeActivity.this;

      public void onClick(View paramAnonymousView)
      {
        View localView = LayoutInflater.from(this.context).inflate(2130903057, null);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.context);
        localBuilder.setView(localView);
        localBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            String str1 = this.val$userInput.getText().toString();
            File localFile = new File(Environment.getExternalStorageDirectory(), str1);
            String str2;
            do
              try
              {
                BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
                str2 = localBufferedReader.readLine();
                continue;
                ResumeActivity.this.sub.append(str2);
                ResumeActivity.this.sub.append("\n");
                String str3 = localBufferedReader.readLine();
                ResumeActivity.this.n = str3;
                String str4 = localBufferedReader.readLine();
                ResumeActivity.this.p = str4;
                str2 = localBufferedReader.readLine();
                ResumeActivity.this.a = str2;
              }
              catch (IOException localIOException)
              {
                localIOException.printStackTrace();
                return;
              }
            while (str2 != null);
          }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.cancel();
          }
        });
        localBuilder.create().show();
      }
    });
    this.create.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(ResumeActivity.this, FragActivity.class);
        ResumeActivity.this.startActivity(localIntent);
      }
    });
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230733, paramMenu);
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
 * Qualified Name:     com.anmolinc.linker.ResumeActivity
 * JD-Core Version:    0.6.2
 */