package com.anmolinc.linker;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationAddress
{
  private static final String TAG = "LocationAddress";

  public static void getAddressFromLocation(final double paramDouble1, double paramDouble2, Context paramContext, final Handler paramHandler)
  {
    new Thread()
    {
      public void run()
      {
        Geocoder localGeocoder = new Geocoder(LocationAddress.this, Locale.getDefault());
        try
        {
          List localList = localGeocoder.getFromLocation(paramDouble1, this.val$longitude, 1);
          Object localObject2 = null;
          Address localAddress;
          StringBuilder localStringBuilder;
          if (localList != null)
          {
            int i = localList.size();
            localObject2 = null;
            if (i > 0)
            {
              localAddress = (Address)localList.get(0);
              localStringBuilder = new StringBuilder();
            }
          }
          for (int j = 0; ; j++)
          {
            if (j >= localAddress.getMaxAddressLineIndex())
            {
              localStringBuilder.append(localAddress.getLocality()).append("\n");
              localStringBuilder.append(localAddress.getPostalCode()).append("\n");
              localStringBuilder.append(localAddress.getCountryName());
              String str = localStringBuilder.toString();
              localObject2 = str;
              localMessage3 = Message.obtain();
              localMessage3.setTarget(paramHandler);
              if (localObject2 == null)
                break;
              localMessage3.what = 1;
              Bundle localBundle6 = new Bundle();
              localBundle6.putString("address", localObject2);
              localMessage3.setData(localBundle6);
              localMessage3.sendToTarget();
              return;
            }
            localStringBuilder.append(localAddress.getAddressLine(j)).append("\n");
          }
        }
        catch (IOException localIOException)
        {
          Log.e("LocationAddress", "Unable connect to Geocoder", localIOException);
          Message localMessage2 = Message.obtain();
          localMessage2.setTarget(paramHandler);
          if (0 != 0)
          {
            localMessage2.what = 1;
            Bundle localBundle4 = new Bundle();
            localBundle4.putString("address", null);
            localMessage2.setData(localBundle4);
          }
          while (true)
          {
            localMessage2.sendToTarget();
            return;
            localMessage2.what = 1;
            Bundle localBundle3 = new Bundle();
            localBundle3.putString("address", "\n Unable to get address for this lat-long.");
            localMessage2.setData(localBundle3);
          }
        }
        finally
        {
          while (true)
          {
            Message localMessage3;
            Message localMessage1 = Message.obtain();
            localMessage1.setTarget(paramHandler);
            if (0 != 0)
            {
              localMessage1.what = 1;
              Bundle localBundle2 = new Bundle();
              localBundle2.putString("address", null);
              localMessage1.setData(localBundle2);
            }
            while (true)
            {
              localMessage1.sendToTarget();
              throw localObject1;
              localMessage1.what = 1;
              Bundle localBundle1 = new Bundle();
              localBundle1.putString("address", "\n Unable to get address for this lat-long.");
              localMessage1.setData(localBundle1);
            }
            localMessage3.what = 1;
            Bundle localBundle5 = new Bundle();
            localBundle5.putString("address", "\n Unable to get address for this lat-long.");
            localMessage3.setData(localBundle5);
          }
        }
      }
    }
    .start();
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.LocationAddress
 * JD-Core Version:    0.6.2
 */