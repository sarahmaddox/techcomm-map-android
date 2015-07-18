package com.techcomm.map.mobile.render;

import com.techcomm.map.mobile.data.EventData;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * An event marker suitable for clustering by ClusterManager.
 */
public class EventMarker implements ClusterItem {
    private final EventData mData;
    private final boolean mHighlight;
    private final LatLng mPosition;

    public EventMarker(EventData data, boolean highlight) {
        mData = data;
        mHighlight = highlight;
        mPosition = new LatLng(data.getLatitude(), data.getLongitude());
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    public String getTitle() {
        return mData.getName();
    }

    public String getSnippet() {
        return mData.getDescription();
    }

    public int getLocalId() {
        return mData.getLocalId();
    }

    public boolean isHighlighted() {
        return mHighlight;
    }

    public EventData getEvent() {
        return mData;
    }
}
