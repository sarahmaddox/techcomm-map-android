package com.techcomm.map.mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * Displays an "About" screen describing the app.
 */
public class AboutActivity extends AppCompatActivity {

    /**
     * Initializes the "about" activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Add the toolbar at the top of the screen.
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)(findViewById(R.id.about_toolbar));
        setSupportActionBar(toolbar);

        // Get the introductory text view and make the links interactive
        // by calling setMovementMethod() on the TextView object.
        TextView introTextView = (TextView) findViewById(R.id.about_intro);
        introTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
