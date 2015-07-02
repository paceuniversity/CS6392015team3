package com.privatestock.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.privatestock.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {

    private static final String EX_REPO = "";

    private View context = null;
    private String imageUrl;

    public ImageDownloader(View context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            URL url = new URL(this.imageUrl);
            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            if (conn.getResponseCode() != 200)
                throw new Exception("Failed to Connect");

            InputStream inStream = conn.getInputStream();
            return BitmapFactory.decodeStream(inStream);

        } catch(Exception e) {
            Log.e("Image", "Failed to Load Image", e);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... params) {

    }

    @Override
    protected void onPostExecute(Bitmap img) {
        ImageView imageView = (ImageView) context.findViewById(R.id.resultImageView);

        if (imageView != null && img != null) {
            imageView.setImageBitmap(img);
        }
    }

    public void setImageName(String imageName) {
        this.imageUrl = imageUrl;
    }
}
