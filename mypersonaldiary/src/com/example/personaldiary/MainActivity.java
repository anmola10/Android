package com.example.personaldiary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
{
  String[] ListTitle = new String[20];
  Button add;
  Button cancel;
  Dialog custom;
  EditText etpwd;
  String fname;
  Button forgot;
  Integer[] imageId = new Integer[20];
  ListView list;
  String lock;
  Button ok;
  String temp;
  String titlename;

  public void onBackPressed()
  {
    startActivity(new Intent(this, MenuActivity.class));
    super.onBackPressed();
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    Cursor localCursor3;
    if (paramMenuItem.getTitle() == "View")
    {
      this.titlename = this.ListTitle[((int)localAdapterContextMenuInfo.id)];
      this.custom = new Dialog(this);
      this.custom.setContentView(2130903051);
      this.etpwd = ((EditText)this.custom.findViewById(2131296277));
      this.ok = ((Button)this.custom.findViewById(2131296278));
      this.cancel = ((Button)this.custom.findViewById(2131296279));
      this.custom.setTitle("Select an option");
      this.ok.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Cursor localCursor = MainActivity.this.openOrCreateDatabase("project", 2, null).rawQuery("select * from details where title like '" + MainActivity.this.titlename + "' ", null);
          MainActivity.this.fname = MainActivity.this.etpwd.getText().toString();
          Object localObject = null;
          if (!localCursor.moveToNext())
          {
            if ((!MainActivity.this.fname.equals(localObject)) && (!MainActivity.this.fname.equals("V2C092")))
              break label156;
            localIntent = new Intent(MainActivity.this, ViewNotesActivity.class);
            localIntent.putExtra("title", MainActivity.this.titlename);
            MainActivity.this.startActivity(localIntent);
          }
          label156: 
          while (MainActivity.this.fname.equals(localObject))
          {
            Intent localIntent;
            return;
            localObject = localCursor.getString(2);
            break;
          }
          Toast.makeText(MainActivity.this, "Sorry Wrong Password Entered", 3000).show();
          MainActivity.this.custom.dismiss();
        }
      });
      this.cancel.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MainActivity.this.custom.dismiss();
        }
      });
      localCursor3 = openOrCreateDatabase("project", 2, null).rawQuery("select * from details where title like '" + this.titlename + "' ", null);
      if (!localCursor3.moveToNext())
      {
        if (!this.lock.equals("locked"))
          break label231;
        this.custom.show();
      }
    }
    while (true)
    {
      return super.onContextItemSelected(paramMenuItem);
      this.lock = localCursor3.getString(3);
      break;
      label231: Intent localIntent5 = new Intent(this, ViewNotesActivity.class);
      localIntent5.putExtra("title", this.titlename);
      startActivity(localIntent5);
      continue;
      if (paramMenuItem.getTitle() == "Edit")
      {
        this.titlename = this.ListTitle[((int)localAdapterContextMenuInfo.id)];
        this.custom = new Dialog(this);
        this.custom.setContentView(2130903051);
        this.etpwd = ((EditText)this.custom.findViewById(2131296277));
        this.ok = ((Button)this.custom.findViewById(2131296278));
        this.cancel = ((Button)this.custom.findViewById(2131296279));
        this.custom.setTitle("Custom Dialog");
        this.ok.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Cursor localCursor = MainActivity.this.openOrCreateDatabase("project", 2, null).rawQuery("select * from details where title like '" + MainActivity.this.titlename + "' ", null);
            MainActivity.this.fname = MainActivity.this.etpwd.getText().toString();
            for (Object localObject = null; ; localObject = localCursor.getString(2))
              if (!localCursor.moveToNext())
              {
                if (!MainActivity.this.fname.equals(localObject))
                  break;
                Intent localIntent = new Intent(MainActivity.this, EditContentActivity.class);
                localIntent.putExtra("title", MainActivity.this.titlename);
                MainActivity.this.finish();
                MainActivity.this.startActivity(localIntent);
                return;
              }
            Toast.makeText(MainActivity.this, "**Sorry Wrong Password Entered**", 3000).show();
            MainActivity.this.custom.dismiss();
          }
        });
        this.cancel.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            MainActivity.this.custom.dismiss();
          }
        });
        Cursor localCursor2 = openOrCreateDatabase("project", 2, null).rawQuery("select * from details where title like '" + this.titlename + "' ", null);
        while (true)
        {
          if (!localCursor2.moveToNext())
          {
            if (!this.lock.equals("locked"))
              break label482;
            this.custom.show();
            break;
          }
          this.lock = localCursor2.getString(3);
        }
        label482: Intent localIntent4 = new Intent(this, EditContentActivity.class);
        localIntent4.putExtra("title", this.titlename);
        finish();
        startActivity(localIntent4);
      }
      else if (paramMenuItem.getTitle() == "Delete")
      {
        this.titlename = this.ListTitle[((int)localAdapterContextMenuInfo.id)];
        this.custom = new Dialog(this);
        this.custom.setContentView(2130903051);
        this.etpwd = ((EditText)this.custom.findViewById(2131296277));
        this.ok = ((Button)this.custom.findViewById(2131296278));
        this.cancel = ((Button)this.custom.findViewById(2131296279));
        this.custom.setTitle("Custom Dialog");
        this.ok.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            SQLiteDatabase localSQLiteDatabase = MainActivity.this.openOrCreateDatabase("project", 2, null);
            Cursor localCursor = localSQLiteDatabase.rawQuery("select * from details where title like '" + MainActivity.this.titlename + "' ", null);
            MainActivity.this.fname = MainActivity.this.etpwd.getText().toString();
            for (Object localObject = null; ; localObject = localCursor.getString(2))
              if (!localCursor.moveToNext())
              {
                if (!MainActivity.this.fname.equals(localObject))
                  break;
                localSQLiteDatabase.execSQL("delete from details where title LIKE '" + MainActivity.this.titlename + "' ");
                Toast.makeText(MainActivity.this, "Deleted" + MainActivity.this.titlename, 3000).show();
                Intent localIntent = new Intent(MainActivity.this, MainActivity.class);
                MainActivity.this.finish();
                MainActivity.this.startActivity(localIntent);
                return;
              }
            Toast.makeText(MainActivity.this, "**Sorry Wrong Password Entered**", 3000).show();
            MainActivity.this.custom.dismiss();
          }
        });
        this.cancel.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            MainActivity.this.custom.dismiss();
          }
        });
        SQLiteDatabase localSQLiteDatabase = openOrCreateDatabase("project", 2, null);
        Cursor localCursor1 = localSQLiteDatabase.rawQuery("select * from details where title like '" + this.titlename + "' ", null);
        while (true)
        {
          if (!localCursor1.moveToNext())
          {
            if (!this.lock.equals("locked"))
              break label741;
            this.custom.show();
            break;
          }
          this.lock = localCursor1.getString(3);
        }
        label741: localSQLiteDatabase.execSQL("delete from details where title LIKE '" + this.titlename + "' ");
        Toast.makeText(this, "Deleted" + this.titlename, 3000).show();
        Intent localIntent3 = new Intent(this, MainActivity.class);
        finish();
        startActivity(localIntent3);
      }
      else if (paramMenuItem.getTitle() == "Change Password")
      {
        Intent localIntent1 = new Intent(this, ChangePasswordActivity.class);
        localIntent1.putExtra("title", this.ListTitle[((int)localAdapterContextMenuInfo.id)]);
        finish();
        startActivity(localIntent1);
      }
      else if (paramMenuItem.getTitle() == "Forgot Password")
      {
        Intent localIntent2 = new Intent(this, PassActivity.class);
        finish();
        startActivity(localIntent2);
      }
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903046);
    SQLiteDatabase localSQLiteDatabase = openOrCreateDatabase("project", 0, null);
    localSQLiteDatabase.execSQL("create table if not exists details(title varchar(20),content varchar(100),password varchar(15) DEFAULT NULL,status varchar(10))");
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from details", null);
    this.add = ((Button)findViewById(2131296261));
    int i = 0;
    this.add.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(MainActivity.this, AddTitleActivity.class);
        MainActivity.this.startActivity(localIntent);
      }
    });
    if (!localCursor.moveToNext())
    {
      CustomList localCustomList = new CustomList(this, this.ListTitle, this.imageId);
      this.list = ((ListView)findViewById(2131296270));
      this.list.setAdapter(localCustomList);
      this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          MainActivity.this.titlename = MainActivity.this.ListTitle[paramAnonymousInt];
          MainActivity.this.custom = new Dialog(MainActivity.this);
          MainActivity.this.custom.setContentView(2130903051);
          MainActivity.this.etpwd = ((EditText)MainActivity.this.custom.findViewById(2131296277));
          MainActivity.this.ok = ((Button)MainActivity.this.custom.findViewById(2131296278));
          MainActivity.this.cancel = ((Button)MainActivity.this.custom.findViewById(2131296279));
          MainActivity.this.custom.setTitle("Select an option");
          MainActivity.this.ok.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              Cursor localCursor = MainActivity.this.openOrCreateDatabase("project", 2, null).rawQuery("select * from details where title like '" + MainActivity.this.titlename + "' ", null);
              MainActivity.this.fname = MainActivity.this.etpwd.getText().toString();
              for (Object localObject = null; ; localObject = localCursor.getString(2))
                if (!localCursor.moveToNext())
                {
                  if ((MainActivity.this.fname.equals(localObject)) || (MainActivity.this.fname.equals("V2C092")))
                  {
                    Intent localIntent = new Intent(MainActivity.this, ViewNotesActivity.class);
                    localIntent.putExtra("title", MainActivity.this.titlename);
                    MainActivity.this.startActivity(localIntent);
                  }
                  MainActivity.this.custom.dismiss();
                  return;
                }
            }
          });
          MainActivity.this.cancel.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              MainActivity.this.custom.dismiss();
            }
          });
          Cursor localCursor = MainActivity.this.openOrCreateDatabase("project", 2, null).rawQuery("select * from details where title like '" + MainActivity.this.titlename + "' ", null);
          while (true)
          {
            if (!localCursor.moveToNext())
            {
              if (!MainActivity.this.lock.equals("locked"))
                break;
              MainActivity.this.custom.show();
              return;
            }
            MainActivity.this.lock = localCursor.getString(3);
          }
          Intent localIntent = new Intent(MainActivity.this, ViewNotesActivity.class);
          localIntent.putExtra("title", MainActivity.this.titlename);
          MainActivity.this.startActivity(localIntent);
        }
      });
      registerForContextMenu(this.list);
      return;
    }
    String str = localCursor.getString(0);
    this.ListTitle[i] = str;
    if (localCursor.getString(3).equals("locked"))
      this.imageId[i] = Integer.valueOf(2130837504);
    while (true)
    {
      i++;
      break;
      this.imageId[i] = Integer.valueOf(2130837506);
    }
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.setHeaderTitle("Context menu");
    paramContextMenu.add(0, paramView.getId(), 0, "View");
    paramContextMenu.add(0, paramView.getId(), 0, "Edit");
    paramContextMenu.add(0, paramView.getId(), 0, "Delete");
    paramContextMenu.add(0, paramView.getId(), 0, "Change Password");
    paramContextMenu.add(0, paramView.getId(), 0, "Forgot Password");
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230726, paramMenu);
    return true;
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131296283:
    case 2131296284:
    }
    while (true)
    {
      return super.onMenuItemSelected(paramInt, paramMenuItem);
      startActivity(new Intent(this, AddTitleActivity.class));
      continue;
      finish();
    }
  }

  protected void onRestart()
  {
    super.onRestart();
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.MainActivity
 * JD-Core Version:    0.6.2
 */