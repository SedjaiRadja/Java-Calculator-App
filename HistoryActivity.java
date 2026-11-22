
package com.calculatrice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends Activity {

    private HistoryManager historyManager;
    private ThemeManager themeManager;

    private LinearLayout mainLayout;
    private LinearLayout historyContainer;
    private TextView title;
    private Button clearButton;
    private Button themeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        historyManager = new HistoryManager(this);
        themeManager = new ThemeManager(this);

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(25, 25, 25, 25);

        title = new TextView(this);
        title.setText("Historique");
        title.setTextSize(28);
        title.setGravity(Gravity.CENTER);
        mainLayout.addView(title);

        themeButton = new Button(this);
        mainLayout.addView(themeButton);

        clearButton = new Button(this);
        clearButton.setText("Effacer l'historique");
        mainLayout.addView(clearButton);

        ScrollView scrollView = new ScrollView(this);

        historyContainer = new LinearLayout(this);
        historyContainer.setOrientation(LinearLayout.VERTICAL);

        scrollView.addView(historyContainer);

        mainLayout.addView(scrollView,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        0, 1));

        themeButton.setOnClickListener(v -> {
            boolean newMode = !themeManager.isDarkMode();
            themeManager.setDarkMode(newMode);
            applyTheme();
        });

        clearButton.setOnClickListener(v -> {
            historyManager.clearHistory();
            displayHistory();
        });

        setContentView(mainLayout);

        applyTheme();
    }

    private void applyTheme() {

        boolean dark = themeManager.isDarkMode();

        int background = dark ? 0xFF171717 : 0xFFFFFFFF;
        int textColor = dark ? 0xFFFFFFFF : 0xFF000000;

        mainLayout.setBackgroundColor(background);
        title.setTextColor(textColor);

        themeButton.setText(dark ?
                "Activer Light Mode" : "Activer Dark Mode");

        displayHistory();
    }

    private void displayHistory() {

        historyContainer.removeAllViews();

        boolean dark = themeManager.isDarkMode();
        int textColor = dark ? 0xFFFFFFFF : 0xFF000000;

        ArrayList<String> history = historyManager.getHistory();

        if (history.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText("Aucune opération enregistrée");
            empty.setTextColor(textColor);
            empty.setTextSize(18);
            empty.setGravity(Gravity.CENTER);
            historyContainer.addView(empty);
            return;
        }

        for (String operation : history) {
            TextView item = new TextView(this);
            item.setText(operation);
            item.setTextColor(textColor);
            item.setTextSize(18);
            item.setPadding(10, 15, 10, 15);
            historyContainer.addView(item);
        }
    }
}

