package example.com.maitreev2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.joanzapata.pdfview.PDFView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PDF extends AppCompatActivity {
PDFView p;
    Toolbar toolbar;
    String download_file_url="http://vakratundasystem.in/harsh/maitree/pdfs/MaitreeFinal.pdf";
    ProgressBar progressBar;
    TextView tv;
    int downloadedSize = 0, totalsize;
    float per = 0;
    File file;
    File SDCardRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SDCardRoot = Environment.getExternalStorageDirectory();
        tv = (TextView) findViewById(R.id.pdftext);
        p = (PDFView) findViewById(R.id.pdf);
        progressBar= (ProgressBar) findViewById(R.id.pdfprogress);
        tv.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        downloadAndOpenPDF();
    }

    void downloadAndOpenPDF() {
            class backg extends AsyncTask<Void,Void,Void> {

                @Override
                protected void onPreExecute() {
                            p.setVisibility(View.INVISIBLE);
                            tv.setText("Loading.....");
                }

                @Override
                protected Void doInBackground(Void... params) {
                   file=downloadFile(download_file_url);

                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    progressBar.setVisibility(View.GONE);
                    tv.setVisibility(View.GONE);
                    p.setVisibility(View.VISIBLE);
                    p.fromFile(file).defaultPage(1)
                            .enableSwipe(true)
                            .swipeVertical(true)
                            .load();
                }
            }
        String pdfpath=SDCardRoot.getAbsolutePath()+"/Schedule.pdf";
        file=new File(pdfpath);
        boolean ex = file.exists();
        if (ex){
            progressBar.setVisibility(View.GONE);
            tv.setVisibility(View.GONE);
            p.setVisibility(View.VISIBLE);
            p.fromFile(file).defaultPage(1)
                    .enableSwipe(true)
                    .swipeVertical(true)

                    .load();
        }
        else {
            backg back = new backg();
            back.execute();
        }


    }
    File downloadFile(String dwnload_file_path) {
        File file = null;
        try {

            URL url = new URL(dwnload_file_path);
            HttpURLConnection urlConnection = (HttpURLConnection) url
                    .openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);

            // connect
            urlConnection.connect();

            // set the path where we want to save the file

            // create a new file, to save the downloaded file
            String dest_file_path="/Schedule.pdf";
            file = new File(SDCardRoot, dest_file_path);

            FileOutputStream fileOutput = new FileOutputStream(file);

            // Stream used for reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();

            // this is the total size of the file which we are
            // downloading
            totalsize = urlConnection.getContentLength();
            setText("Starting PDF download...");

            // create a buffer...
            byte[] buffer = new byte[1024 * 1024];
            int bufferLength = 0;

            while ((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
                per = ((float) downloadedSize / totalsize) * 100;
                setText("Total PDF File size  : "
                        + (totalsize / 1024)
                        + " KB\n\nDownloading PDF " + (int) per
                        + "% complete");
            }
            // close the output stream when complete //
            fileOutput.close();
            setText("Download Complete.");

        } catch (final MalformedURLException e) {
            setTextError("Some error occured. Press back and try again.",
                    Color.RED);
        } catch (final IOException e) {
            setTextError("Some error occured. Press back and try again.",
                    Color.RED);
        } catch (final Exception e) {
            setTextError(
                    "Failed to download image. Please check your internet connection.",
                    Color.RED);
        }
        return file;
    }

    void setTextError(final String message, final int color) {
        runOnUiThread(new Runnable() {
            public void run() {
                tv.setTextColor(color);
                tv.setText(message);
            }
        });

    }

    void setText(final String txt) {
        runOnUiThread(new Runnable() {
            public void run() {
                tv.setText(txt);
            }
        });

    }

}



