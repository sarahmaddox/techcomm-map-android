package com.techcomm.map.mobile.render;

import com.techcomm.map.mobile.data.EventData;

/**
 * The color of an event marker on the map, as determined by event type.
 */
public class MarkerColor {
    private static final MarkerColor CONFERENCES_2017= new MarkerColor(0xff808080, 0xff404040);
    private static final MarkerColor CONFERENCES_2018 = new MarkerColor(0xffc077f1, 0xffa347e1);
    private static final MarkerColor SOCIETIES = new MarkerColor(0xfff6bb2e, 0xffee7b0c);
    private static final MarkerColor GROUPS = new MarkerColor(0xffee4bf3, 0xffff00ff);
    private static final MarkerColor BUSINESSES = new MarkerColor(0xff1ab61a, 0xff008000);
    private static final MarkerColor COURSES = new MarkerColor(0xff017cff, 0xff0000ff);
    private static final MarkerColor OTHER = new MarkerColor(0xff01e2ff, 0xff01c4ff);
    private static final MarkerColor CONFERENCES_2017_HIGHLIGHT =
            new MarkerColor(0xff808080, 0xffffffff);
    private static final MarkerColor CONFERENCES_2018_HIGHLIGHT =
            new MarkerColor(0xffc077f1, 0xffffffff);
    private static final MarkerColor SOCIETIES_HIGHLIGHT = new MarkerColor(0xfff6bb2e, 0xffffffff);
    private static final MarkerColor GROUPS_HIGHLIGHT = new MarkerColor(0xffee4bf3, 0xffffffff);
    private static final MarkerColor BUSINESSES_HIGHLIGHT = new MarkerColor(0xff1ab61a, 0xffffffff);
    private static final MarkerColor COURSES_HIGHLIGHT = new MarkerColor(0xff017cff, 0xffffffff);
    private static final MarkerColor OTHER_HIGHLIGHT = new MarkerColor(0xff01e2ff, 0xffffffff);

    public final int fillColor;
    public final int strokeColor;

    private MarkerColor(int fillColor, int strokeColor) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
    }

    public static MarkerColor getMarkerColor(EventData event, boolean highlight) {
        if ("Conference 2017".equals(event.getType())) {
            return highlight ? CONFERENCES_2017_HIGHLIGHT : CONFERENCES_2017;
        } else if ("Conference 2018".equals(event.getType())) {
            return highlight ? CONFERENCES_2018_HIGHLIGHT : CONFERENCES_2018;
        } else if ("Society".equals(event.getType())) {
            return highlight ? SOCIETIES_HIGHLIGHT : SOCIETIES;
        } else if ("Group".equals(event.getType())) {
            return highlight ? GROUPS_HIGHLIGHT : GROUPS;
        } else if ("Business".equals(event.getType())) {
            return highlight ? BUSINESSES_HIGHLIGHT : BUSINESSES;
        } else if ("Course".equals(event.getType())) {
            return highlight ? COURSES_HIGHLIGHT : COURSES;
        } else {
            return highlight ? OTHER_HIGHLIGHT : OTHER;
        }
    }
}
