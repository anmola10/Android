package com.anmolinc.linker;

import android.graphics.Path;
import android.graphics.Region;

public class PieSlice
{
  private int mColor = -13388315;
  private final Path mPath = new Path();
  private final Region mRegion = new Region();
  private int mSelectedColor = -1;
  private String mTitle;
  private float mValue;

  public int getColor()
  {
    return this.mColor;
  }

  public Path getPath()
  {
    return this.mPath;
  }

  public Region getRegion()
  {
    return this.mRegion;
  }

  public int getSelectedColor()
  {
    if (-1 == this.mSelectedColor)
      this.mSelectedColor = Utils.darkenColor(this.mColor);
    return this.mSelectedColor;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public float getValue()
  {
    return this.mValue;
  }

  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
  }

  public void setSelectedColor(int paramInt)
  {
    this.mSelectedColor = paramInt;
  }

  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }

  public void setValue(float paramFloat)
  {
    this.mValue = paramFloat;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.PieSlice
 * JD-Core Version:    0.6.2
 */