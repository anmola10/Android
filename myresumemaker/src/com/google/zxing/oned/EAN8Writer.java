package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class EAN8Writer extends UPCEANWriter
{
  private static final int CODE_WIDTH = 67;

  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    if (paramBarcodeFormat != BarcodeFormat.EAN_8)
      throw new IllegalArgumentException("Can only encode EAN_8, but got " + paramBarcodeFormat);
    return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }

  public byte[] encode(String paramString)
  {
    if (paramString.length() != 8)
      throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + paramString.length());
    byte[] arrayOfByte = new byte[67];
    int i = 0 + appendPattern(arrayOfByte, 0, UPCEANReader.START_END_PATTERN, 1);
    for (int j = 0; j <= 3; j++)
    {
      int i1 = Integer.parseInt(paramString.substring(j, j + 1));
      i += appendPattern(arrayOfByte, i, UPCEANReader.L_PATTERNS[i1], 0);
    }
    int k = i + appendPattern(arrayOfByte, i, UPCEANReader.MIDDLE_PATTERN, 0);
    for (int m = 4; m <= 7; m++)
    {
      int n = Integer.parseInt(paramString.substring(m, m + 1));
      k += appendPattern(arrayOfByte, k, UPCEANReader.L_PATTERNS[n], 1);
    }
    (k + appendPattern(arrayOfByte, k, UPCEANReader.START_END_PATTERN, 1));
    return arrayOfByte;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.EAN8Writer
 * JD-Core Version:    0.6.2
 */