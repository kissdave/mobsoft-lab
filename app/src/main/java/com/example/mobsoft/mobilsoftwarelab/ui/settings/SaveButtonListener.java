package com.example.mobsoft.mobilsoftwarelab.ui.settings;

import android.view.View;

/**
 * Created by dkiss on 2017. 05. 15..
 */

public class SaveButtonListener implements View.OnClickListener {
    private SettingsActivity settingsActivity;

    public SaveButtonListener(SettingsActivity settingsActivity) {
        this.settingsActivity = settingsActivity;
    }

    @Override
    public void onClick(View v) {
        settingsActivity.save("Saving changes...");
    }
}
