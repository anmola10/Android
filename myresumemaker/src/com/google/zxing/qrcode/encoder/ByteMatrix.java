package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

public final class ByteMatrix
{
  private final byte[][] bytes;
  private final int height;
  private final int width;

  public ByteMatrix(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = { paramInt2, paramInt1 };
    this.bytes = ((byte[][])Array.newInstance(Byte.TYPE, arrayOfInt));
    this.width = paramInt1;
    this.height = paramInt2;
  }

  public void clear(byte paramByte)
  {
    for (int i = 0; i < this.height; i++)
      for (int j = 0; j < this.width; j++)
        this.bytes[i][j] = paramByte;
  }

  public byte get(int paramInt1, int paramInt2)
  {
    return this.bytes[paramInt2][paramInt1];
  }

  public byte[][] getArray()
  {
    return this.bytes;
  }

  public int getHeight()
  {
    return this.height;
  }

  public int getWidth()
  {
    return this.width;
  }

  public void set(int paramInt1, int paramInt2, byte paramByte)
  {
    this.bytes[paramInt2][paramInt1] = paramByte;
  }

  public void set(int paramInt1, int paramInt2, int paramInt3)
  {
    this.bytes[paramInt2][paramInt1] = ((byte)paramInt3);
  }

  public void set(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.bytes[paramInt2];
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      arrayOfByte[paramInt1] = ((byte)i);
      return;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(2 + 2 * this.width * this.height);
    for (int i = 0; i < this.height; i++)
    {
      int j = 0;
      if (j < this.width)
      {
        switch (this.bytes[i][j])
        {
        default:
          localStringBuilder.append("  ");
        case 0:
        case 1:
        }
        while (true)
        {
          j++;
          break;
          localStringBuilder.append(" 0");
          continue;
          localStringBuilder.append(" 1");
        }
      }
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.ByteMatrix
 * JD-Core Version:    0.6.2
 */