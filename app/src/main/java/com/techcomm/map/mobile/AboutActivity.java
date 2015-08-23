package com.techcomm.map.mobile;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;

/**
 * Displays an "About" screen describing the app.
 */
public class AboutActivity extends Activity {

    /**
     * Initializes the "about" activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Add the toolbar at the top of the screen.
        Toolbar toolbar = (Toolbar)(findViewById(R.id.about_toolbar));
        setActionBar(toolbar);

        // Get the introductory text view and make the links interactive
        // by calling setMovementMethod() on the TextView object.
        TextView introTextView = (TextView) findViewById(R.id.about_intro);
        introTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // Get and display the Android legal notices.
        String androidLicenseInfo = GoogleApiAvailability.getInstance()
                .getOpenSourceSoftwareLicenseInfo(getApplicationContext());
        TextView androidTextView = (TextView) findViewById(R.id.android_license);
        androidTextView.setText(androidLicenseInfo);
    }
}
