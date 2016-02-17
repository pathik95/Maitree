package example.com.maitreev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;
import example.com.maitreev2.Adapters.PlaceListAdapter;

public class MainActivity extends AppCompatActivity {

    String TITLES[];
    int ICONS[] = {R.drawable.ic_home_black_18dp,R.drawable.modern11,R.drawable.food,R.drawable.mapmarker,R.drawable.users6,R.drawable.hand220,R.drawable.silhouette67,R.drawable.user81,R.drawable.notebook91};
//    Response responsseObj;
    String url="http://vakratundasystem.in/harsh/maitree/getplace.php";
    Gson gson;
    AsyncHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client=new AsyncHttpClient();
        TITLES=getResources().getStringArray(R.array.DrawerItems);

        final ListView listView= (ListView) findViewById(R.id.placelist1);
        client.get(this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);
                gson = new Gson();
               // responsseObj = gson.fromJson(responsestr, Response.class);
            //    List<Response.DatesEntity> datelist=responsseObj.getDates();
             //   Response.DatesEntity entity=datelist.get(0);
               // listView.setAdapter(new PlaceListAdapter(MainActivity.this,entity.getPlacedetails()));
                int count=listView.getCount();
                int height= (int) getResources().getDimension(R.dimen.placelist);
                int totalheight=height*count;
                listView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, totalheight));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();

            }
        });




    }
}
