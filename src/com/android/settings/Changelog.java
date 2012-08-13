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
        Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.changelog);
        mContext = getActivity().getApplicationContext();

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
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(R.string.aboutsteeldroid_changelog_title);
        builder.setMessage(R.string.aboutsteeldroid_changelog);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
