package com.example.personaldiary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AddTitleActivity extends Activity
{
  CheckBox box;
  Button btn;
  EditText confirm;
  EditText et1;
  EditText et2;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    this.et1 = ((EditText)findViewById(2131296259));
    this.et2 = ((EditText)findViewById(2131296260));
    this.box = ((CheckBox)findViewById(2131296258));
    this.btn = ((Button)findViewById(2131296261));
    this.confirm = ((EditText)findViewById(2131296262));
    this.btn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(AddTitleActivity.this, EnterContentActivity.class);
        localIntent.putExtra("title", AddTitleActivity.this.et1.getText().toString());
        if (AddTitleActivity.this.box.isChecked())
        {
          localIntent.putExtra("pwdyes", "Yes");
          localIntent.putExtra("password", AddTitleActivity.this.et2.getText().toString());
        }
        while (AddTitleActivity.this.et2.getText().toString().trim().matches(AddTitleActivity.this.confirm.getText().toString().trim()))
        {
          AddTitleActivity.this.finish();
          AddTitleActivity.this.startActivity(localIntent);
          return;
          localIntent.putExtra("pwdyes", "No");
        }
        Toast.makeText(AddTitleActivity.this, "Passwords do not match", 1).show();
      }
    });
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.AddTitleActivity
 * JD-Core Version:    0.6.2
 */