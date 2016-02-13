package com.anmolinc.linker;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class FragActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void selectFrag(View paramView)
  {
    Object localObject;
    if (paramView == findViewById(2130968579))
      localObject = new SkillFrag();
    while (true)
    {
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.replace(2130968581, (Fragment)localObject);
      localFragmentTransaction.commit();
      return;
      if (paramView == findViewById(2130968580))
        localObject = new FragmentTwo();
      else if (paramView == findViewById(2130968583))
        localObject = new FragmentThree();
      else if (paramView == findViewById(2130968582))
        localObject = new FragmentFour();
      else if (paramView == findViewById(2130968584))
        localObject = new FragmentFive();
      else
        localObject = new FragmentOne();
    }
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\linker-dex2jar.jar
 * Qualified Name:     com.anmolinc.linker.FragActivity
 * JD-Core Version:    0.6.2
 */