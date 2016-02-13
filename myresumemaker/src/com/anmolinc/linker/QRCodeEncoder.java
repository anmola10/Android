package com.anmolinc.linker;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public final class QRCodeEncoder
{
  private static final int BLACK = -16777216;
  private static final int WHITE = -1;
  private String contents = null;
  private int dimension = -2147483648;
  private String displayContents = null;
  private boolean encoded = false;
  private BarcodeFormat format = null;
  private String title = null;

  public QRCodeEncoder(String paramString1, Bundle paramBundle, String paramString2, String paramString3, int paramInt)
  {
    this.dimension = paramInt;
    this.encoded = encodeContents(paramString1, paramBundle, paramString2, paramString3);
  }

  private boolean encodeContents(String paramString1, Bundle paramBundle, String paramString2, String paramString3)
  {
    this.format = null;
    if (paramString3 != null);
    try
    {
      this.format = BarcodeFormat.valueOf(paramString3);
      label19: if ((this.format == null) || (this.format == BarcodeFormat.QR_CODE))
      {
        this.format = BarcodeFormat.QR_CODE;
        encodeQRCodeContents(paramString1, paramBundle, paramString2);
      }
      while ((this.contents != null) && (this.contents.length() > 0))
      {
        return true;
        if ((paramString1 != null) && (paramString1.length() > 0))
        {
          this.contents = paramString1;
          this.displayContents = paramString1;
          this.title = "Text";
        }
      }
      return false;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label19;
    }
  }

  private void encodeQRCodeContents(String paramString1, Bundle paramBundle, String paramString2)
  {
    if (paramString2.equals("TEXT_TYPE"))
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        this.contents = paramString1;
        this.displayContents = paramString1;
        this.title = "Text";
      }
    label377: float f1;
    label403: label605: label742: float f2;
    label657: 
    do
    {
      do
      {
        do
        {
          String str9;
          do
          {
            String str10;
            do
            {
              String str11;
              do
              {
                return;
                if (!paramString2.equals("EMAIL_TYPE"))
                  break;
                str11 = trim(paramString1);
              }
              while (str11 == null);
              this.contents = ("mailto:" + str11);
              this.displayContents = str11;
              this.title = "E-Mail";
              return;
              if (!paramString2.equals("PHONE_TYPE"))
                break;
              str10 = trim(paramString1);
            }
            while (str10 == null);
            this.contents = ("tel:" + str10);
            this.displayContents = PhoneNumberUtils.formatNumber(str10);
            this.title = "Phone";
            return;
            if (!paramString2.equals("SMS_TYPE"))
              break;
            str9 = trim(paramString1);
          }
          while (str9 == null);
          this.contents = ("sms:" + str9);
          this.displayContents = PhoneNumberUtils.formatNumber(str9);
          this.title = "SMS";
          return;
          if (!paramString2.equals("CONTACT_TYPE"))
            break;
        }
        while (paramBundle == null);
        StringBuilder localStringBuilder1 = new StringBuilder(100);
        StringBuilder localStringBuilder2 = new StringBuilder(100);
        localStringBuilder1.append("MECARD:");
        String str1 = trim(paramBundle.getString("name"));
        if (str1 != null)
        {
          localStringBuilder1.append("N:").append(escapeMECARD(str1)).append(';');
          localStringBuilder2.append(str1);
        }
        String str2 = trim(paramBundle.getString("postal"));
        if (str2 != null)
        {
          localStringBuilder1.append("ADR:").append(escapeMECARD(str2)).append(';');
          localStringBuilder2.append('\n').append(str2);
        }
        HashSet localHashSet1 = new HashSet(Contents.PHONE_KEYS.length);
        int i = 0;
        Iterator localIterator1;
        HashSet localHashSet2;
        int j;
        Iterator localIterator2;
        if (i >= Contents.PHONE_KEYS.length)
        {
          localIterator1 = localHashSet1.iterator();
          if (localIterator1.hasNext())
            break label605;
          localHashSet2 = new HashSet(Contents.EMAIL_KEYS.length);
          j = 0;
          if (j < Contents.EMAIL_KEYS.length)
            break label657;
          localIterator2 = localHashSet2.iterator();
        }
        while (true)
        {
          if (!localIterator2.hasNext())
          {
            String str6 = trim(paramBundle.getString("URL_KEY"));
            if (str6 != null)
            {
              localStringBuilder1.append("URL:").append(str6).append(';');
              localStringBuilder2.append('\n').append(str6);
            }
            String str7 = trim(paramBundle.getString("NOTE_KEY"));
            if (str7 != null)
            {
              localStringBuilder1.append("NOTE:").append(escapeMECARD(str7)).append(';');
              localStringBuilder2.append('\n').append(str7);
            }
            if (localStringBuilder2.length() <= 0)
              break label742;
            localStringBuilder1.append(';');
            this.contents = localStringBuilder1.toString();
            this.displayContents = localStringBuilder2.toString();
            this.title = "Contact";
            return;
            String str3 = trim(paramBundle.getString(Contents.PHONE_KEYS[i]));
            if (str3 != null)
              localHashSet1.add(str3);
            i++;
            break;
            String str8 = (String)localIterator1.next();
            localStringBuilder1.append("TEL:").append(escapeMECARD(str8)).append(';');
            localStringBuilder2.append('\n').append(PhoneNumberUtils.formatNumber(str8));
            break label377;
            String str4 = trim(paramBundle.getString(Contents.EMAIL_KEYS[j]));
            if (str4 != null)
              localHashSet2.add(str4);
            j++;
            break label403;
          }
          String str5 = (String)localIterator2.next();
          localStringBuilder1.append("EMAIL:").append(escapeMECARD(str5)).append(';');
          localStringBuilder2.append('\n').append(str5);
        }
        this.contents = null;
        this.displayContents = null;
        return;
      }
      while ((!paramString2.equals("LOCATION_TYPE")) || (paramBundle == null));
      f1 = paramBundle.getFloat("LAT", 3.4028235E+38F);
      f2 = paramBundle.getFloat("LONG", 3.4028235E+38F);
    }
    while ((f1 == 3.4028235E+38F) || (f2 == 3.4028235E+38F));
    this.contents = ("geo:" + f1 + ',' + f2);
    this.displayContents = (f1 + "," + f2);
    this.title = "Location";
  }

  private static String escapeMECARD(String paramString)
  {
    if ((paramString == null) || ((paramString.indexOf(':') < 0) && (paramString.indexOf(';') < 0)))
      return paramString;
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localStringBuilder.toString();
      char c = paramString.charAt(j);
      if ((c == ':') || (c == ';'))
        localStringBuilder.append('\\');
      localStringBuilder.append(c);
    }
  }

  private static String guessAppropriateEncoding(CharSequence paramCharSequence)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramCharSequence.length())
        return null;
      if (paramCharSequence.charAt(i) > 'ÿ')
        return "UTF-8";
    }
  }

  private static String trim(String paramString)
  {
    if (paramString == null)
      return null;
    String str = paramString.trim();
    if (str.length() == 0)
      str = null;
    return str;
  }

  public Bitmap encodeAsBitmap()
    throws WriterException
  {
    if (!this.encoded)
      return null;
    String str = guessAppropriateEncoding(this.contents);
    EnumMap localEnumMap = null;
    if (str != null)
    {
      localEnumMap = new EnumMap(EncodeHintType.class);
      localEnumMap.put(EncodeHintType.CHARACTER_SET, str);
    }
    BitMatrix localBitMatrix = new MultiFormatWriter().encode(this.contents, this.format, this.dimension, this.dimension, localEnumMap);
    int i = localBitMatrix.getWidth();
    int j = localBitMatrix.getHeight();
    int[] arrayOfInt = new int[i * j];
    int m;
    int n;
    for (int k = 0; ; k++)
    {
      if (k >= j)
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localBitmap.setPixels(arrayOfInt, 0, i, 0, 0, i, j);
        return localBitmap;
      }
      m = k * i;
      n = 0;
      if (n < i)
        break;
    }
    int i1 = m + n;
    if (localBitMatrix.get(n, k));
    for (int i2 = -16777216; ; i2 = -1)
    {
      arrayOfInt[i1] = i2;
      n++;
      break;
    }
  }

  public String getContents()
  {
    return this.contents;
  }

  public String getDisplayContents()
  {
    return this.displayContents;
  }

  public String getTitle()
  {
    return this.title;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.QRCodeEncoder
 * JD-Core Version:    0.6.2
 */