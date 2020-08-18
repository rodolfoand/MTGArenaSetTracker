package com.rodolfo.mtgarenasettracker.http;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;

public class HttpSvg extends AsyncTask<Void, Void, Bitmap> {

    String url;

    public HttpSvg(String url) {
        this.url = url;
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        Bitmap bitmap = null;

        Uri uri = Uri.parse(url);




        return bitmap;
    }
}
