package example.com.maitreev2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.joanzapata.pdfview.PDFView;

public class PDF extends AppCompatActivity {
PDFView p;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        p = (PDFView) findViewById(R.id.pdf);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        p.fromAsset("MaitreeFinal.pdf").swipeVertical(true).defaultPage(1).load();

//        File fileBrochure = new File("/sdcard/abc.pdf");
//        if (!fileBrochure.exists())
//        {
//            CopyAssetsbrochure();
//        }
//
//        /** PDF reader code */
//        File file = new File("/sdcard/abc.pdf");
//
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            getApplicationContext().startActivity(intent);




    }
//    public void CopyAssetsbrochure() {
//        AssetManager assetManager = getAssets();
//        String[] files = null;
//        try
//        {
//            files = assetManager.list("");
//        }
//        catch (IOException e)
//        {
//            Log.e("tag", e.getMessage());
//        }
//        for(int i=0; i<files.length; i++)
//        {
//            String fStr = files[i];
//            if(fStr.equalsIgnoreCase("MATSCHE.pdf"))
//            {
//                InputStream in = null;
//                OutputStream out = null;
//                try
//                {
//                    in = assetManager.open(files[i]);
//                    out = new FileOutputStream("/sdcard/" + files[i]);
//                    copyFile(in, out);
//                    in.close();
//                    in = null;
//                    out.flush();
//                    out.close();
//                    out = null;
//                    break;
//                }
//                catch(Exception e)
//                {
//                    Log.e("tag", e.getMessage());
//                }
//            }
//        }
//    }
//
//    private void copyFile(InputStream in, OutputStream out) throws IOException {
//        byte[] buffer = new byte[1024];
//        int read;
//        while((read = in.read(buffer)) != -1){
//            out.write(buffer, 0, read);
//        }
//    }





}
