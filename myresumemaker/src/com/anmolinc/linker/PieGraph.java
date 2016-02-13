package com.anmolinc.linker;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public class PieGraph extends View
{
  private boolean mDrawCompleted = false;
  private int mInnerCircleRatio;
  private OnSliceClickedListener mListener;
  private int mPadding;
  private Paint mPaint = new Paint();
  private RectF mRectF = new RectF();
  private int mSelectedIndex = -1;
  private ArrayList<PieSlice> mSlices = new ArrayList();

  public PieGraph(Context paramContext)
  {
    this(paramContext, null);
  }

  public PieGraph(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PieGraph(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.PieGraph, 0, 0);
    this.mInnerCircleRatio = localTypedArray.getInt(0, 0);
    this.mPadding = localTypedArray.getDimensionPixelSize(1, 0);
  }

  public void addSlice(PieSlice paramPieSlice)
  {
    this.mSlices.add(paramPieSlice);
    postInvalidate();
  }

  public PieSlice getSlice(int paramInt)
  {
    return (PieSlice)this.mSlices.get(paramInt);
  }

  public ArrayList<PieSlice> getSlices()
  {
    return this.mSlices;
  }

  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0);
    this.mPaint.reset();
    this.mPaint.setAntiAlias(true);
    float f1 = 270.0F;
    int i = 0;
    float f2 = getWidth() / 2;
    float f3 = getHeight() / 2;
    float f4;
    float f5;
    float f6;
    Iterator localIterator1;
    if (f2 < f3)
    {
      f4 = f2;
      f5 = f4 - this.mPadding;
      f6 = f5 * this.mInnerCircleRatio / 255.0F;
      localIterator1 = this.mSlices.iterator();
    }
    int j;
    Iterator localIterator2;
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        j = 0;
        localIterator2 = this.mSlices.iterator();
        if (localIterator2.hasNext())
          break label157;
        this.mDrawCompleted = true;
        return;
        f4 = f3;
        break;
      }
      PieSlice localPieSlice1 = (PieSlice)localIterator1.next();
      i = (int)(i + localPieSlice1.getValue());
    }
    label157: PieSlice localPieSlice2 = (PieSlice)localIterator2.next();
    Path localPath = localPieSlice2.getPath();
    localPath.reset();
    if ((this.mSelectedIndex == j) && (this.mListener != null))
      this.mPaint.setColor(localPieSlice2.getSelectedColor());
    while (true)
    {
      float f7 = 360.0F * (localPieSlice2.getValue() / i);
      this.mRectF.set(f2 - f5, f3 - f5, f2 + f5, f3 + f5);
      localPath.arcTo(this.mRectF, f1 + this.mPadding, f7 - this.mPadding);
      this.mRectF.set(f2 - f6, f3 - f6, f2 + f6, f3 + f6);
      localPath.arcTo(this.mRectF, f1 + this.mPadding + (f7 - this.mPadding), -(f7 - this.mPadding));
      localPath.close();
      localPieSlice2.getRegion().set((int)(f2 - f5), (int)(f3 - f5), (int)(f2 + f5), (int)(f3 + f5));
      paramCanvas.drawPath(localPath, this.mPaint);
      f1 += f7;
      j++;
      break;
      this.mPaint.setColor(localPieSlice2.getColor());
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Point localPoint;
    int i;
    Region localRegion;
    Iterator localIterator;
    if (this.mDrawCompleted)
    {
      localPoint = new Point();
      localPoint.x = ((int)paramMotionEvent.getX());
      localPoint.y = ((int)paramMotionEvent.getY());
      i = 0;
      localRegion = new Region();
      localIterator = this.mSlices.iterator();
      if (localIterator.hasNext());
    }
    else
    {
      if ((1 == paramMotionEvent.getAction()) || (3 == paramMotionEvent.getAction()))
      {
        this.mSelectedIndex = -1;
        postInvalidate();
      }
      return true;
    }
    PieSlice localPieSlice = (PieSlice)localIterator.next();
    localRegion.setPath(localPieSlice.getPath(), localPieSlice.getRegion());
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      i++;
      break;
      if (localRegion.contains(localPoint.x, localPoint.y))
      {
        this.mSelectedIndex = i;
        postInvalidate();
        continue;
        if ((i == this.mSelectedIndex) && (this.mListener != null) && (localRegion.contains(localPoint.x, localPoint.y)))
          this.mListener.onClick(this.mSelectedIndex);
      }
    }
  }

  public void removeSlices()
  {
    this.mSlices.clear();
    postInvalidate();
  }

  public void setInnerCircleRatio(int paramInt)
  {
    this.mInnerCircleRatio = paramInt;
    postInvalidate();
  }

  public void setOnSliceClickedListener(OnSliceClickedListener paramOnSliceClickedListener)
  {
    this.mListener = paramOnSliceClickedListener;
  }

  public void setPadding(int paramInt)
  {
    this.mPadding = paramInt;
    postInvalidate();
  }

  public void setSlices(ArrayList<PieSlice> paramArrayList)
  {
    this.mSlices = paramArrayList;
    postInvalidate();
  }

  public static abstract interface OnSliceClickedListener
  {
    public abstract void onClick(int paramInt);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.PieGraph
 * JD-Core Version:    0.6.2
 */