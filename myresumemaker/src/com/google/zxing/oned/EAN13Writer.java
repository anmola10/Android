package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class EAN13Writer extends UPCEANWriter
{
  private static final int CODE_WIDTH = 95;

  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    if (paramBarcodeFormat != BarcodeFormat.EAN_13)
      throw new IllegalArgumentException("Can only encode EAN_13, but got " + paramBarcodeFormat);
    return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }

  public byte[] encode(String paramString)
  {
    if (paramString.length() != 13)
      throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + paramString.length());
    int i = Integer.parseInt(paramString.substring(0, 1));
    int j = EAN13Reader.FIRST_DIGIT_ENCODINGS[i];
    byte[] arrayOfByte = new byte[95];
    int k = 0 + appendPattern(arrayOfByte, 0, UPCEANReader.START_END_PATTERN, 1);
    for (int m = 1; m <= 6; m++)
    {
      int i3 = Integer.parseInt(paramString.substring(m, m + 1));
      if ((0x1 & j >> 6 - m) == 1)
        i3 += 10;
      k += appendPattern(arrayOfByte, k, UPCEANReader.L_AND_G_PATTERNS[i3], 0);
    }
    int n = k + appendPattern(arrayOfByte, k, UPCEANReader.MIDDLE_PATTERN, 0);
    for (int i1 = 7; i1 <= 12; i1++)
    {
      int i2 = Integer.parseInt(paramString.substring(i1, i1 + 1));
      n += appendPattern(arrayOfByte, n, UPCEANReader.L_PATTERNS[i2], 1);
    }
    (n + appendPattern(arrayOfByte, n, UPCEANReader.START_END_PATTERN, 1));
    return arrayOfByte;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.EAN13Writer
 * JD-Core Version:    0.6.2
 */