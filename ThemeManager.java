
package com.calculatrice;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemeManager {

    private static final String PREFS = "ThemeSettings";
    private static final String KEY_DARK = "dark_mode";

    private SharedPreferences preferences;

    public ThemeManager(Context context) {
        preferences = context.getSharedPreferences(
                PREFS, Context.MODE_PRIVATE);
    }

    public boolean isDarkMode() {
        return preferences.getBoolean(KEY_DARK, false);
    }

    public void setDarkMode(boolean enabled) {
        preferences.edit()
                .putBoolean(KEY_DARK, enabled)
                .apply();
    }
}
