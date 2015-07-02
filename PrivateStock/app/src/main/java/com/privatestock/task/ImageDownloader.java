package com.privatestock.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.privatestock.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {

    private static final String EXAMPLE_REPO =
            "https://raw.githubusercontent.com/paceuniversity/CS6392015team3/master/img_repo/";
    private static final String EXAMPLE_EXT = ".jpg";

    private View view = null;
    private Context appContext;
    private String imageUrl;

    public ImageDownloader(View view) {
        this.view = view;
        this.appContext = null;
    }

    public ImageDownloader(View view, Context appContext) {
        this.view = view;
        this.appContext = appContext;
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
        ImageView imageView = (ImageView) view.findViewById(R.id.resultImageView);
        TextView noImageTextView = (TextView) view.findViewById(R.id.noImageTextView);

        if (imageView != null && img != null) {
            noImageTextView.setText("");
            imageView.setImageBitmap(img);
        } else {
            noImageTextView.setText("No Image Found. Please Try Again.");
        }
    }

    public void setImageName(String imageName) {
        this.imageUrl = EXAMPLE_REPO + imageName.toLowerCase().replaceAll(" ", "_") + EXAMPLE_EXT;
    }
}
