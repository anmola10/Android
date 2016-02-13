package com.google.zxing.oned.rss.expanded.decoders;

abstract class DecodedObject
{
  private final int newPosition;

  DecodedObject(int paramInt)
  {
    this.newPosition = paramInt;
  }

  int getNewPosition()
  {
    return this.newPosition;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.DecodedObject
 * JD-Core Version:    0.6.2
 */