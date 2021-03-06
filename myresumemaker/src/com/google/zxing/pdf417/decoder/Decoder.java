package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;

public final class Decoder
{
  private static final int MAX_EC_CODEWORDS = 512;
  private static final int MAX_ERRORS = 3;

  private static int correctErrors(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
    throws FormatException
  {
    if ((paramArrayOfInt2.length > 3 + paramInt / 2) || (paramInt < 0) || (paramInt > 512))
      throw FormatException.getFormatInstance();
    int i = paramArrayOfInt2.length;
    if (0 > 0)
      i += 0;
    if (i > 3)
      throw FormatException.getFormatInstance();
    return 0;
  }

  private static void verifyCodewordCount(int[] paramArrayOfInt, int paramInt)
    throws FormatException
  {
    if (paramArrayOfInt.length < 4)
      throw FormatException.getFormatInstance();
    int i = paramArrayOfInt[0];
    if (i > paramArrayOfInt.length)
      throw FormatException.getFormatInstance();
    if (i == 0)
    {
      if (paramInt < paramArrayOfInt.length)
        paramArrayOfInt[0] = (paramArrayOfInt.length - paramInt);
    }
    else
      return;
    throw FormatException.getFormatInstance();
  }

  public DecoderResult decode(BitMatrix paramBitMatrix)
    throws FormatException
  {
    BitMatrixParser localBitMatrixParser = new BitMatrixParser(paramBitMatrix);
    int[] arrayOfInt = localBitMatrixParser.readCodewords();
    if (arrayOfInt.length == 0)
      throw FormatException.getFormatInstance();
    int i = 1 << 1 + localBitMatrixParser.getECLevel();
    correctErrors(arrayOfInt, localBitMatrixParser.getErasures(), i);
    verifyCodewordCount(arrayOfInt, i);
    return DecodedBitStreamParser.decode(arrayOfInt);
  }

  public DecoderResult decode(boolean[][] paramArrayOfBoolean)
    throws FormatException
  {
    int i = paramArrayOfBoolean.length;
    BitMatrix localBitMatrix = new BitMatrix(i);
    for (int j = 0; j < i; j++)
      for (int k = 0; k < i; k++)
        if (paramArrayOfBoolean[k][j] != 0)
          localBitMatrix.set(k, j);
    return decode(localBitMatrix);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.Decoder
 * JD-Core Version:    0.6.2
 */