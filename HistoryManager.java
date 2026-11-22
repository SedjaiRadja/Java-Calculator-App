
package com.calculatrice;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class HistoryManager {

    private static final String PREFS_NAME = "CalculatorHistory";
    private static final String HISTORY_KEY = "history";

    private SharedPreferences preferences;

    public HistoryManager(Context context) {
        preferences = context.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void addHistory(String operation) {
        ArrayList<String> history = getHistory();

        history.add(0, operation);

        JSONArray jsonArray = new JSONArray();

        for (String item : history) {
            jsonArray.put(item);
        }

        preferences.edit()
                .putString(HISTORY_KEY, jsonArray.toString())
                .apply();
    }

    public ArrayList<String> getHistory() {
        ArrayList<String> history = new ArrayList<>();

        String saved = preferences.getString(HISTORY_KEY, "[]");

        try {
            JSONArray jsonArray = new JSONArray(saved);

            for (int i = 0; i < jsonArray.length(); i++) {
                history.add(jsonArray.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return history;
    }

    public void clearHistory() {
        preferences.edit()
                .remove(HISTORY_KEY)
                .apply();
    }
}


