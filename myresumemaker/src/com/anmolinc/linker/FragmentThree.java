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

public class FragmentThree extends Fragment
{
  Button add;
  EditText course;
  EditText from;
  Button next;
  EditText per;
  Button save;
  EditText school;
  EditText to;
  View vw;

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.vw = paramLayoutInflater.inflate(2130903053, paramViewGroup, false);
    this.course = ((EditText)this.vw.findViewById(2130968602));
    this.school = ((EditText)this.vw.findViewById(2130968599));
    this.per = ((EditText)this.vw.findViewById(2130968601));
    this.from = ((EditText)this.vw.findViewById(2130968600));
    this.to = ((EditText)this.vw.findViewById(2130968603));
    Activity localActivity1 = getActivity();
    getActivity();
    localActivity1.openOrCreateDatabase("three", 2, null).execSQL("create table if not exists acad(title varchar,content varchar,password varchar,status varchar)");
    Activity localActivity2 = getActivity();
    getActivity();
    localActivity2.openOrCreateDatabase("three2", 2, null).execSQL("create table if not exists acad2(title varchar,content varchar,password varchar,status varchar)");
    this.next = ((Button)this.vw.findViewById(2130968583));
    this.save = ((Button)this.vw.findViewById(2130968579));
    this.add = ((Button)this.vw.findViewById(2130968580));
    this.save.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Log.d("Insert: ", "Inserting ..");
        Activity localActivity = FragmentThree.this.getActivity();
        FragmentThree.this.getActivity();
        localActivity.openOrCreateDatabase("three", 2, null).execSQL("insert into acad values('" + FragmentThree.this.course.getText().toString() + "','" + FragmentThree.this.school.getText().toString() + "','" + FragmentThree.this.from.getText().toString() + "','" + FragmentThree.this.to.getText().toString() + "')");
        Toast.makeText(FragmentThree.this.getActivity(), "Saved In DataBase", 3000).show();
      }
    });
    this.add.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FragmentThree.this.course.setText("");
        FragmentThree.this.school.setText("");
        FragmentThree.this.from.setText("");
        FragmentThree.this.to.setText("");
        Activity localActivity = FragmentThree.this.getActivity();
        FragmentThree.this.getActivity();
        localActivity.openOrCreateDatabase("three2", 2, null).execSQL("insert into acad2 values('" + FragmentThree.this.course.getText().toString() + "','" + FragmentThree.this.school.getText().toString() + "','" + FragmentThree.this.from.getText().toString() + "','" + FragmentThree.this.to.getText().toString() + "')");
        Toast.makeText(FragmentThree.this.getActivity(), "Saved In DataBase", 3000).show();
      }
    });
    this.next.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SkillFrag localSkillFrag = new SkillFrag();
        FragmentTransaction localFragmentTransaction = FragmentThree.this.getFragmentManager().beginTransaction();
        localFragmentTransaction.replace(2130968581, localSkillFrag);
        localFragmentTransaction.commit();
      }
    });
    return this.vw;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.FragmentThree
 * JD-Core Version:    0.6.2
 */