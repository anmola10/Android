package com.anmolinc.linker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity extends Activity
{
  Button btnCreateAccount;
  EditText editTextConfirmPassword;
  EditText editTextPassword;
  EditText editTextUserName;
  LoginDataBaseAdapter loginDataBaseAdapter;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903058);
    this.loginDataBaseAdapter = new LoginDataBaseAdapter(this);
    this.loginDataBaseAdapter = this.loginDataBaseAdapter.open();
    this.editTextUserName = ((EditText)findViewById(2130968611));
    this.editTextPassword = ((EditText)findViewById(2130968612));
    this.editTextConfirmPassword = ((EditText)findViewById(2130968613));
    this.btnCreateAccount = ((Button)findViewById(2130968614));
    this.btnCreateAccount.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = SignUPActivity.this.editTextUserName.getText().toString();
        String str2 = SignUPActivity.this.editTextPassword.getText().toString();
        String str3 = SignUPActivity.this.editTextConfirmPassword.getText().toString();
        if ((str1.equals("")) || (str2.equals("")) || (str3.equals("")))
        {
          Toast.makeText(SignUPActivity.this.getApplicationContext(), "Field Vaccant", 1).show();
          return;
        }
        if (!str2.equals(str3))
        {
          Toast.makeText(SignUPActivity.this.getApplicationContext(), "Password does not match", 1).show();
          return;
        }
        SignUPActivity.this.loginDataBaseAdapter.insertEntry(str1, str2);
        Toast.makeText(SignUPActivity.this.getApplicationContext(), "Account Successfully Created ", 1).show();
        Intent localIntent = new Intent(SignUPActivity.this, ResumeActivity.class);
        SignUPActivity.this.startActivity(localIntent);
      }
    });
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.loginDataBaseAdapter.close();
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.SignUPActivity
 * JD-Core Version:    0.6.2
 */