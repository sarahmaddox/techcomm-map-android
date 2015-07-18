package com.techcomm.map.mobile;

import android.content.Context;
import android.os.AsyncTask;

import com.techcomm.map.mobile.data.EventData;

import org.json.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import io.realm.Realm;

/**
 * AsyncTask that fetches the data from the network, and stores the data on the device using Realm.
 * The data source is a Google Sheet, accessed via an Apps Script that outputs the data in JSON
 * format.
 */
class DataFetcherTask extends AsyncTask<Void, Void, Void> {
    private final String TAG = DataFetcherTask.class.getSimpleName();
    private static final String DATA_URL =
            "https://script.googleusercontent.com/a/macros/google.com/echo?user_content_key=" +
            "bkLlXYbwZhrXQdVGKWjyLwLILW7LO46yLoLeybpSORx4B8i1EvcPYy1PJf2JddRzuqvV-_mhzzJ7ca0tM8g0" +
            "_nkfy0QMOpqlOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMi80zadyHLKA1v4M_UJVXmVE7BfPhQv9zYXCLwcA8" +
            "uT4jGAN4QiC-mO2_XQmdTxAxMdOK9_Z24oSW4IHLf5WxsFVlMYYFhI9nsI9upHmnpgxuTmoSAyRRY1e340iM" +
            "BXwJ8hjNwDS03h4KFopgNAxL3bc3d--FIG6vBJAGtH1-f29VzNeIhWXmXQSQBrR9fn9v6w_L1Z8J86A&lib=" +
            "MRsLmDuDo-t3XZuGu1d_7J5SkNBQGtLke";

    private final Context context;
    private final Runnable callback;

    DataFetcherTask(Context context, Runnable callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Void... params) {
        URL url = null;
        try {
            url = new URL(DATA_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            // Use a junk delimiter to get the whole string.
            String inputStreamString = new Scanner(url.openStream(), "UTF-8")
                    .useDelimiter("\\A").next();
            String strippedString = inputStreamString.substring(
                    inputStreamString.indexOf("["),
                    inputStreamString.length() - 1);
            JSONArray result = new JSONArray(strippedString);

            if (result == null) {
                return null;
            }

            // Realm is a mobile database - a replacement for SQLite. See realm.io.
            Realm realm = Realm.getInstance(context);
            realm.beginTransaction();
            realm.allObjects(EventData.class).clear();

            // Process each row in the spreadsheet. Skip the first row, because it contains
            // header information. Each row contains the data for a single event:
            // event type, name, description, website, start date, end date, address, latitude,
            // longitude.
            for (int i = 1; i < result.length(); i++) {
                JSONArray eventArray = result.getJSONArray(i);
                EventData eventData = new EventData(
                        i,
                        eventArray.getString(0),
                        eventArray.getString(1),
                        eventArray.getString(2),
                        eventArray.getString(3),
                        eventArray.getString(4),
                        eventArray.getString(5),
                        eventArray.getString(6),
                        eventArray.getDouble(7),
                        eventArray.getDouble(8));
                realm.copyToRealm(eventData);
            }
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        callback.run();
    }
}
