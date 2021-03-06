package com.android.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;

import com.android.settings.R;

public class Changelog extends SettingsPreferenceFragment {

	private Activity mActivity;
        Preference mSteelDroidChangelog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.changelog);

        mSteelDroidChangelog = findPreference("aboutsteeldroid_changelog");
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
	if (preference == mSteelDroidChangelog) {
		showChangelog();
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void showChangelog() {
        mActivity = getActivity();
		new AlertDialog.Builder(mActivity)
			.setTitle(R.string.aboutsteeldroid_changelog_title)
			.setMessage(R.string.aboutsteeldroid_changelog)
			.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			})
			.create().show();
    }
}
