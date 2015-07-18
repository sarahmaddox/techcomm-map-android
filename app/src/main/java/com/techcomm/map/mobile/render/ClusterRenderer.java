package com.techcomm.map.mobile.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import java.util.HashMap;
import java.util.Map;

/**
 * A renderer that displays the event markers on the map, grouped into clusters for ease of viewing
 * when there are many markers in a small geographical area.
 */
public class ClusterRenderer extends DefaultClusterRenderer<EventMarker> {

    private final Context context;
    private final Map<MarkerColor, Bitmap> generatedBitmaps = new HashMap<>();

    public ClusterRenderer(Context context, GoogleMap map, ClusterManager<EventMarker> manager) {
        super(context, map, manager);
        this.context = context;
    }

    @Override
    protected void onBeforeClusterItemRendered(EventMarker item, MarkerOptions options) {
        options.icon(BitmapDescriptorFactory.fromBitmap(generateIcon(item)));
        options.position(item.getPosition());
        options.title(item.getTitle());
        options.snippet(item.getSnippet());
    }

    private Bitmap generateIcon(EventMarker eventMarker) {
        MarkerColor markerColor = MarkerColor.getMarkerColor(eventMarker.getEvent(),
                eventMarker.isHighlighted());
        if (generatedBitmaps.containsKey(markerColor)) {
            return generatedBitmaps.get(markerColor);
        }

        int radius = convertDpToPixel(13, context);
        int strokeWidth = convertDpToPixel(4, context);

        Paint fillPaint = new Paint();
        fillPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        fillPaint.setColor(markerColor.fillColor);

        Paint strokePaint = new Paint();
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(strokeWidth);
        strokePaint.setColor(markerColor.strokeColor);

        Bitmap bitmap = Bitmap.createBitmap(radius * 2, radius * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawCircle(radius, radius, radius, fillPaint);
        canvas.drawCircle(radius, radius, radius - strokeWidth / 2, strokePaint);
        generatedBitmaps.put(markerColor, bitmap);
        return bitmap;
    }

    private static int convertDpToPixel(float dp, Context context){
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}
