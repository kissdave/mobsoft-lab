package com.example.mobsoft.mobilsoftwarelab.ui.settings;

import com.example.mobsoft.mobilsoftwarelab.model.User;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface SettingsScreen {
    public void getSettings(String text);

    public void save(String text);

    public void showMessage(String text);

    public void displaySettings(User user);
}
