package net.gshp.messagesandfiles.network;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by gnu on 9/02/18.
 */

public class DownloadFile extends AsyncTask<String, String, String> {

    private ProgressBar progressBar;

    public DownloadFile(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    /**
     * Before starting background thread
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        System.out.println("Starting download");

    }

    /**
     * Downloading file in background thread
     */
    @Override
    protected String doInBackground(String... f_url) {
        int count;
        try {
            String root = Environment.getExternalStorageDirectory().toString().concat("/").concat(f_url[1]);

            System.out.println("Downloading " + f_url[0]);
            URL url = new URL(f_url[0]);

            URLConnection conection = url.openConnection();
            conection.connect();
            // getting file length
            int lenghtOfFile = conection.getContentLength();

            // input stream to read file - with 8k buffer
            InputStream input = new BufferedInputStream(url.openStream(), 8192);

            // Output stream to write file

            OutputStream output = new FileOutputStream(root + "/downloadedfile.mp4");
            byte data[] = new byte[1024];

            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                progressBar.setProgress((int) ((total * 100) / lenghtOfFile));

                // writing data to file
                output.write(data, 0, count);

            }

            // flushing output
            output.flush();

            // closing streams
            output.close();
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * After completing background task
     **/
    @Override
    protected void onPostExecute(String file_url) {
        System.out.println("Downloaded");

    }
}
