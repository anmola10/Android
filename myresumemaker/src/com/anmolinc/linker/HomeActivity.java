package com.anmolinc.linker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity
{
  Button about;
  Button btnSignIn;
  Button btnSignUp;
  Button exit;
  LoginDataBaseAdapter loginDataBaseAdapter;

  public void onBackPressed()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Anmol Inc. Resume Maker Lite");
    localBuilder.setMessage("Do you want to exit application?").setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        HomeActivity.this.finish();
      }
    }).setNeutralButton("Rate App", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse("market://details?id=com.anmolinc.linker"));
        HomeActivity.this.startActivity(localIntent);
      }
    }).setNegativeButton("No", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
      }
    });
    localBuilder.create().show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903056);
    this.loginDataBaseAdapter = new LoginDataBaseAdapter(this);
    this.loginDataBaseAdapter = this.loginDataBaseAdapter.open();
    this.btnSignIn = ((Button)findViewById(2130968607));
    this.btnSignUp = ((Button)findViewById(2130968608));
    this.about = ((Button)findViewById(2130968579));
    this.exit = ((Button)findViewById(2130968580));
    this.btnSignUp.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(HomeActivity.this.getApplicationContext(), SignUPActivity.class);
        HomeActivity.this.startActivity(localIntent);
      }
    });
    this.about.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(HomeActivity.this, AboutActivity.class);
        HomeActivity.this.startActivity(localIntent);
      }
    });
    this.exit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HomeActivity.this.finish();
      }
    });
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.loginDataBaseAdapter.close();
  }

  public void signIn(View paramView)
  {
    final Dialog localDialog = new Dialog(this);
    localDialog.setContentView(2130903055);
    localDialog.setTitle("Login");
    final EditText localEditText1 = (EditText)localDialog.findViewById(2130968604);
    final EditText localEditText2 = (EditText)localDialog.findViewById(2130968605);
    ((Button)localDialog.findViewById(2130968606)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = localEditText1.getText().toString();
        if (localEditText2.getText().toString().equals(HomeActivity.this.loginDataBaseAdapter.getSinlgeEntry(str)))
        {
          Toast.makeText(HomeActivity.this, "Congrats: Login Successfull", 1).show();
          localDialog.dismiss();
          Intent localIntent = new Intent(HomeActivity.this, InfoActivity.class);
          HomeActivity.this.startActivity(localIntent);
          return;
        }
        Toast.makeText(HomeActivity.this, "User Name or Password does not match", 1).show();
      }
    });
    localDialog.show();
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.HomeActivity
 * JD-Core Version:    0.6.2
 */