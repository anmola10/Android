package com.anmolinc.linker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class FragmentTwo extends Fragment
{
  EditText Phone;
  EditText add;
  AppLocationService appLocationService;
  private Button btn;
  private EditText editTxt;
  Button locate;
  EditText mail;
  EditText name;
  String result;
  Button save;
  EditText uid;
  Button upload;
  View vw;

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.vw = paramLayoutInflater.inflate(2130903049, paramViewGroup, false);
    this.btn = ((Button)this.vw.findViewById(2130968584));
    this.upload = ((Button)this.vw.findViewById(2130968579));
    this.name = ((EditText)this.vw.findViewById(2130968602));
    this.Phone = ((EditText)this.vw.findViewById(2130968599));
    this.add = ((EditText)this.vw.findViewById(2130968601));
    this.uid = ((EditText)this.vw.findViewById(2130968600));
    this.mail = ((EditText)this.vw.findViewById(2130968603));
    this.save = ((Button)this.vw.findViewById(2130968580));
    this.appLocationService = new AppLocationService(getActivity());
    Button localButton1 = (Button)this.vw.findViewById(2130968583);
    Button localButton2 = (Button)this.vw.findViewById(2130968582);
    int i = 1 + new Random().nextInt(20000);
    this.uid.setText(i);
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Location localLocation = FragmentTwo.this.appLocationService.getLocation("gps");
        if (localLocation != null)
        {
          double d1 = localLocation.getLatitude();
          double d2 = localLocation.getLongitude();
          new LocationAddress();
          LocationAddress.getAddressFromLocation(d1, d2, FragmentTwo.this.getActivity(), new FragmentTwo.GeocoderHandler(FragmentTwo.this, null));
          return;
        }
        FragmentTwo.this.showSettingsAlert();
      }
    });
    Activity localActivity = getActivity();
    getActivity();
    localActivity.openOrCreateDatabase("two", 2, null).execSQL("create table if not exists info(title varchar,content varchar,password varchar,status varchar)");
    this.save.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Log.d("Insert: ", "Inserting ..");
        Activity localActivity = FragmentTwo.this.getActivity();
        FragmentTwo.this.getActivity();
        localActivity.openOrCreateDatabase("two", 2, null).execSQL("insert into info values('" + FragmentTwo.this.name.getText().toString() + "','" + FragmentTwo.this.Phone.getText().toString() + "','" + FragmentTwo.this.add.getText().toString() + "','" + FragmentTwo.this.mail.getText().toString() + "')");
        Toast.makeText(FragmentTwo.this.getActivity(), "Saved In DataBase", 3000).show();
        FragmentThree localFragmentThree = new FragmentThree();
        FragmentTransaction localFragmentTransaction = FragmentTwo.this.getFragmentManager().beginTransaction();
        localFragmentTransaction.replace(2130968581, localFragmentThree);
        localFragmentTransaction.commit();
      }
    });
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = FragmentTwo.this.uid.getText().toString();
        Activity localActivity = FragmentTwo.this.getActivity();
        FragmentTwo.this.getActivity();
        Display localDisplay = ((WindowManager)localActivity.getSystemService("window")).getDefaultDisplay();
        Point localPoint = new Point();
        localDisplay.getSize(localPoint);
        int i = localPoint.x;
        int j = localPoint.y;
        int k;
        if (i < j)
          k = i;
        while (true)
        {
          int m = k * 3 / 4;
          QRCodeEncoder localQRCodeEncoder = new QRCodeEncoder(str, null, "TEXT_TYPE", BarcodeFormat.QR_CODE.toString(), m);
          try
          {
            Bitmap localBitmap = localQRCodeEncoder.encodeAsBitmap();
            ((ImageView)FragmentTwo.this.vw.findViewById(2130968594)).setImageBitmap(localBitmap);
            return;
            k = j;
          }
          catch (WriterException localWriterException)
          {
            localWriterException.printStackTrace();
          }
        }
      }
    });
    this.upload.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        View localView = LayoutInflater.from(FragmentTwo.this.getActivity()).inflate(2130903057, null);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(FragmentTwo.this.getActivity());
        localBuilder.setView(localView);
        localBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            FragmentTwo.this.result = this.val$userInput.getText().toString();
            File localFile = new File(Environment.getExternalStorageDirectory(), FragmentTwo.this.result);
            StringBuilder localStringBuilder = new StringBuilder();
            if (FragmentTwo.this.result.equals(""))
            {
              FragmentTwo.this.uid.setText("");
              FragmentTwo.this.name.setText("");
              FragmentTwo.this.Phone.setText("");
              FragmentTwo.this.add.setText("");
              FragmentTwo.this.mail.setText("");
            }
            try
            {
              BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
              String str1 = localBufferedReader.readLine();
              FragmentTwo.this.name.setText(str1);
              String str2 = localBufferedReader.readLine();
              FragmentTwo.this.add.setText(str2);
              String str3 = localBufferedReader.readLine();
              FragmentTwo.this.Phone.setText(str3);
              localStringBuilder.append(str1);
              localStringBuilder.append('\n');
              return;
            }
            catch (IOException localIOException)
            {
            }
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
    return this.vw;
  }

  public void showSettingsAlert()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    localBuilder.setTitle("SETTINGS");
    localBuilder.setMessage("Enable Location Provider! Go to settings menu?");
    localBuilder.setPositiveButton("Settings", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        FragmentTwo.this.getActivity().startActivity(localIntent);
      }
    });
    localBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    localBuilder.show();
  }

  private class GeocoderHandler extends Handler
  {
    private GeocoderHandler()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 1:
      }
      for (Object localObject = null; ; localObject = paramMessage.getData().getString("address"))
      {
        FragmentTwo.this.add.setText((CharSequence)localObject);
        return;
      }
    }
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.FragmentTwo
 * JD-Core Version:    0.6.2
 */