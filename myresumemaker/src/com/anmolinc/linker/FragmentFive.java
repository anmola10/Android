package com.anmolinc.linker;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentFive extends Fragment
{
  EditText Phone;
  EditText mail;
  EditText name;
  EditText pos;
  Button save;
  View vw;

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.vw = paramLayoutInflater.inflate(2130903050, paramViewGroup, false);
    this.name = ((EditText)this.vw.findViewById(2130968602));
    this.Phone = ((EditText)this.vw.findViewById(2130968599));
    this.mail = ((EditText)this.vw.findViewById(2130968601));
    this.pos = ((EditText)this.vw.findViewById(2130968600));
    Activity localActivity = getActivity();
    getActivity();
    localActivity.openOrCreateDatabase("five", 2, null).execSQL("create table if not exists refs(title varchar,content varchar,password varchar,status varchar)");
    this.save = ((Button)this.vw.findViewById(2130968579));
    this.save.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Log.d("Insert: ", "Inserting ..");
        Activity localActivity = FragmentFive.this.getActivity();
        FragmentFive.this.getActivity();
        localActivity.openOrCreateDatabase("five", 2, null).execSQL("insert into refs values('" + FragmentFive.this.name.getText().toString() + "','" + FragmentFive.this.Phone.getText().toString() + "','" + FragmentFive.this.mail.getText().toString() + "','" + FragmentFive.this.pos.getText().toString() + "')");
        Toast.makeText(FragmentFive.this.getActivity(), "Saved In DataBase", 3000).show();
        Intent localIntent = new Intent(FragmentFive.this.getActivity(), TempActivity.class);
        FragmentFive.this.startActivity(localIntent);
      }
    });
    return this.vw;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.FragmentFive
 * JD-Core Version:    0.6.2
 */