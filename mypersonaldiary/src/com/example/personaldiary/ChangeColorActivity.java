package com.example.personaldiary;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;

public class ChangeColorActivity extends PreferenceActivity
{
  private PreferenceScreen createPreferenceHierarchy()
  {
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    PreferenceCategory localPreferenceCategory = new PreferenceCategory(this);
    localPreferenceCategory.setTitle("Colour Menu");
    localPreferenceScreen.addPreference(localPreferenceCategory);
    ListPreference localListPreference = new ListPreference(this);
    localListPreference.setEntries(2130968576);
    localListPreference.setEntryValues(2130968577);
    localListPreference.setDialogTitle("Choose One");
    localListPreference.setKey("l1");
    localListPreference.setTitle("Select Color");
    localListPreference.setSummary("Select A Background color of your home screen");
    localPreferenceCategory.addPreference(localListPreference);
    return localPreferenceScreen;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setPreferenceScreen(createPreferenceHierarchy());
  }
}

/* Location:           C:\Users\T00049862\Downloads\JARS\PersonalDiary-dex2jar.jar
 * Qualified Name:     com.example.personaldiary.ChangeColorActivity
 * JD-Core Version:    0.6.2
 */