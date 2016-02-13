package com.anmolinc.linker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

public class InfoActivity extends Activity
{
  TextView add;
  Context context = this;
  Button edit;
  TextView name;
  TextView phone;
  TextView uid;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903044);
    TextView localTextView1 = (TextView)findViewById(2130968587);
    TextView localTextView2 = (TextView)findViewById(2130968589);
    TextView localTextView3 = (TextView)findViewById(2130968591);
    this.edit = ((Button)findViewById(2130968579));
    Button localButton = (Button)findViewById(2130968580);
    TextView localTextView4 = (TextView)findViewById(2130968595);
    SQLiteDatabase localSQLiteDatabase = openOrCreateDatabase("two", 0, null);
    localSQLiteDatabase.execSQL("create table if not exists info(title varchar(20),content varchar(100),password varchar(15) DEFAULT NULL,status varchar(10))");
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from info", null);
    while (true)
    {
      int j;
      int k;
      QRCodeEncoder localQRCodeEncoder;
      if (!localCursor.moveToNext())
      {
        this.edit.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Intent localIntent = new Intent(InfoActivity.this, FragActivity.class);
            InfoActivity.this.startActivity(localIntent);
          }
        });
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Intent localIntent = new Intent(InfoActivity.this, DispActivity.class);
            InfoActivity.this.startActivity(localIntent);
          }
        });
        String str = localTextView1.getText().toString();
        Display localDisplay = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay();
        Point localPoint = new Point();
        localDisplay.getSize(localPoint);
        int i = localPoint.x;
        j = localPoint.y;
        if (i >= j)
          break label318;
        k = i;
        int m = k * 3 / 4;
        localQRCodeEncoder = new QRCodeEncoder(str, null, "TEXT_TYPE", BarcodeFormat.QR_CODE.toString(), m);
      }
      try
      {
        Bitmap localBitmap = localQRCodeEncoder.encodeAsBitmap();
        ((ImageView)findViewById(2130968594)).setImageBitmap(localBitmap);
        return;
        localTextView1.setText(localCursor.getString(0));
        localTextView2.setText(localCursor.getString(1));
        localTextView3.setText(localCursor.getString(2));
        localTextView4.setText(localCursor.getString(3));
        continue;
        label318: k = j;
      }
      catch (WriterException localWriterException)
      {
        localWriterException.printStackTrace();
      }
    }
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.InfoActivity
 * JD-Core Version:    0.6.2
 */