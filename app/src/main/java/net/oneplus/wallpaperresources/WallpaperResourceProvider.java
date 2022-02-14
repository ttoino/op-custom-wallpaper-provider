package net.oneplus.wallpaperresources;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class WallpaperResourceProvider extends ContentProvider {
    private static final String KEY_WALLPAPER_CONFIG = "wallpaper_config";
    private static final String METHOD_GET_WALLPAPER_CONFIG = "get_wallpaper_config";
    private static final String TAG = "WallpaperResourceProvider";

    @Override
    public boolean onCreate() {
        return true;
    }

    public Bundle call(String method, String arg, Bundle extras) {
        if (method.equals(METHOD_GET_WALLPAPER_CONFIG)) {
            return getWallpaperConfig();
        }
        return super.call(method, arg, extras);
    }

    private Bundle getWallpaperConfig() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_WALLPAPER_CONFIG, readWallpaperConfig());
        return bundle;
    }

    private String readWallpaperConfig() {
        InputStream openRawResource;
        Context context = getContext();
        if (context == null) {
            Log.e(TAG, "invalid context");
            return null;
        }
        try {
            openRawResource = context.getResources().openRawResource(getWallpaperConfigResId());
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            String str = new String(bArr, StandardCharsets.UTF_8);
            openRawResource.close();
            return str;
        } catch (IOException e) {
            Log.e(TAG, "failed to read config, error=" + e);
            return null;
        }
    }

    private int getWallpaperConfigResId() {
        return R.raw.config;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
