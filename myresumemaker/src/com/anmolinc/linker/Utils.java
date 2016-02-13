package com.anmolinc.linker;

import android.graphics.Color;

public class Utils
{
  public static int darkenColor(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    arrayOfFloat[2] = (0.8F * arrayOfFloat[2]);
    return Color.HSVToColor(arrayOfFloat);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.Utils
 * JD-Core Version:    0.6.2
 */