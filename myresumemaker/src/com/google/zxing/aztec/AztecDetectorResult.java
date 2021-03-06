package com.google.zxing.aztec;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;

public final class AztecDetectorResult extends DetectorResult
{
  private final boolean compact;
  private final int nbDatablocks;
  private final int nbLayers;

  public AztecDetectorResult(BitMatrix paramBitMatrix, ResultPoint[] paramArrayOfResultPoint, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramBitMatrix, paramArrayOfResultPoint);
    this.compact = paramBoolean;
    this.nbDatablocks = paramInt1;
    this.nbLayers = paramInt2;
  }

  public int getNbDatablocks()
  {
    return this.nbDatablocks;
  }

  public int getNbLayers()
  {
    return this.nbLayers;
  }

  public boolean isCompact()
  {
    return this.compact;
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.AztecDetectorResult
 * JD-Core Version:    0.6.2
 */