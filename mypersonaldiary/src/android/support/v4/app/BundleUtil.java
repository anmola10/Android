package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Arrays;

class BundleUtil
{
  public static Bundle[] getBundleArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (((arrayOfParcelable instanceof Bundle[])) || (arrayOfParcelable == null))
      return (Bundle[])arrayOfParcelable;
    Bundle[] arrayOfBundle = (Bundle[])Arrays.copyOf(arrayOfParcelable, arrayOfParcelable.length, [Landroid.os.Bundle.class);
    paramBundle.putParcelableArray(paramString, arrayOfBundle);
    return arrayOfBundle;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BundleUtil
 * JD-Core Version:    0.6.2
 */