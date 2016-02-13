package com.example.personaldiary;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>
{
  private final Activity context;
  private final Integer[] imageId;
  private final String[] web;

  public CustomList(Activity paramActivity, String[] paramArrayOfString, Integer[] paramArrayOfInteger)
  {
    super(paramActivity, 2130903052, paramArrayOfString);
    this.context = paramActivity;
    this.web = paramArrayOfString;
    this.imageId = paramArrayOfInteger;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.web[paramInt] != null)
    {
      View localView = this.context.getLayoutInflater().inflate(2130903052, null, true);
      TextView localTextView = (TextView)localView.findViewById(2131296281);
      ImageView localImageView = (ImageView)localView.findViewById(2131296280);
      localTextView.setText(this.web[paramInt]);
      localImageView.setImageResource(this.imageId[paramInt].intValue());
      return localView;
    }
    return this.context.getLayoutInflater().inflate(2130903053, null, true);
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.CustomList
 * JD-Core Version:    0.6.2
 */