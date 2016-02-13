package com.anmolinc.linker;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class SkillFrag extends Fragment
{
  private ArrayAdapter<String> adapter;
  Button add;
  private ArrayList<String> arrayList;
  int c = 0;
  private ListView list;
  Button save;
  EditText sk;
  View vw;

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.vw = paramLayoutInflater.inflate(2130903059, paramViewGroup, false);
    this.sk = ((EditText)this.vw.findViewById(2130968602));
    Activity localActivity = getActivity();
    getActivity();
    localActivity.openOrCreateDatabase("skill", 2, null).execSQL("create table if not exists skills(title varchar,content varchar,password varchar,status varchar)");
    this.add = ((Button)this.vw.findViewById(2130968579));
    this.save = ((Button)this.vw.findViewById(2130968580));
    new String[] { "abc", "sa" };
    this.list = ((ListView)this.vw.findViewById(2130968615));
    this.arrayList = new ArrayList();
    this.adapter = new ArrayAdapter(getActivity(), 17367048, this.arrayList);
    this.list.setAdapter(this.adapter);
    this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(SkillFrag.this.getActivity());
        localBuilder.setTitle("Delete?");
        localBuilder.setMessage("Are you sure you want to delete this skill?");
        localBuilder.setNegativeButton("Cancel", null);
        localBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            String str = (String)SkillFrag.this.adapter.getItem(paramAnonymousInt);
            SkillFrag.this.adapter.remove(str);
            SkillFrag.this.adapter.notifyDataSetChanged();
          }
        });
        localBuilder.show();
      }
    });
    this.add.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SkillFrag.this.arrayList.add(SkillFrag.this.sk.getText().toString());
        SkillFrag.this.adapter.notifyDataSetChanged();
        SkillFrag localSkillFrag = SkillFrag.this;
        localSkillFrag.c = (1 + localSkillFrag.c);
      }
    });
    this.save.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (SkillFrag.this.c < 5)
        {
          Toast.makeText(SkillFrag.this.getActivity(), "Please enter atleast 4 skills", 3000).show();
          return;
        }
        Log.d("Insert: ", "Inserting ..");
        Activity localActivity = SkillFrag.this.getActivity();
        SkillFrag.this.getActivity();
        localActivity.openOrCreateDatabase("skill", 2, null).execSQL("insert into skills values('" + ((String)SkillFrag.this.adapter.getItem(1)).toString() + "','" + ((String)SkillFrag.this.adapter.getItem(2)).toString() + "','" + ((String)SkillFrag.this.adapter.getItem(3)).toString() + "','" + ((String)SkillFrag.this.adapter.getItem(4)).toString() + "')");
        Toast.makeText(SkillFrag.this.getActivity(), "Saved In DataBase", 3000).show();
        FragmentFour localFragmentFour = new FragmentFour();
        FragmentTransaction localFragmentTransaction = SkillFrag.this.getFragmentManager().beginTransaction();
        localFragmentTransaction.replace(2130968581, localFragmentFour);
        localFragmentTransaction.commit();
      }
    });
    return this.vw;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.SkillFrag
 * JD-Core Version:    0.6.2
 */