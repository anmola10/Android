package com.anmolinc.linker;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

public class FragmentFour extends Fragment
{
  EditText desig;
  EditText from;
  EditText org;
  Button save;
  EditText to;
  View vw;

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.vw = paramLayoutInflater.inflate(2130903051, paramViewGroup, false);
    this.org = ((EditText)this.vw.findViewById(2130968602));
    this.desig = ((EditText)this.vw.findViewById(2130968599));
    this.from = ((EditText)this.vw.findViewById(2130968600));
    this.to = ((EditText)this.vw.findViewById(2130968603));
    Activity localActivity = getActivity();
    getActivity();
    localActivity.openOrCreateDatabase("project", 2, null).execSQL("create table if not exists details(title varchar,content varchar,password varchar,status varchar)");
    this.save = ((Button)this.vw.findViewById(2130968579));
    this.save.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Log.d("Insert: ", "Inserting ..");
        Activity localActivity = FragmentFour.this.getActivity();
        FragmentFour.this.getActivity();
        localActivity.openOrCreateDatabase("project", 2, null).execSQL("insert into details values('" + FragmentFour.this.org.getText().toString() + "','" + FragmentFour.this.desig.getText().toString() + "','" + FragmentFour.this.from.getText().toString() + "','" + FragmentFour.this.to.getText().toString() + "')");
        Toast.makeText(FragmentFour.this.getActivity(), "Saved In DataBase", 3000).show();
        FragmentFive localFragmentFive = new FragmentFive();
        FragmentTransaction localFragmentTransaction = FragmentFour.this.getFragmentManager().beginTransaction();
        localFragmentTransaction.replace(2130968581, localFragmentFive);
        localFragmentTransaction.commit();
      }
    });
    return this.vw;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.FragmentFour
 * JD-Core Version:    0.6.2
 */