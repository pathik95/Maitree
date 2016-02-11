package example.com.maitreev2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.List;

import example.com.maitreev2.Adapters.HostAdapter;
import example.com.maitreev2.Adapters.TabsPagerAdapter;
import example.com.maitreev2.Singleton.ResSingleton;

public class HostList extends AppCompatActivity {


    final String HOSTURL="http://10.0.2.2/maitree/gethost.php";
    ResponseHost responsseObj;
    List<ResponseHost.HostEntity> hostList;
    Gson hgson;

    RecyclerView hostrecycler;
    HostAdapter hostadapter;
    RecyclerView.LayoutManager hostlayoutmanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_list);

        StringRequest responseBody=new StringRequest(HOSTURL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText(HomeActivity.this, responsestr, Toast.LENGTH_LONG).show();
                //Log.d("response", responsestr);
                hgson = new Gson();
                responsseObj = hgson.fromJson(response, ResponseHost.class);
                hostList = responsseObj.getHost();
                hostrecycler= (RecyclerView) findViewById(R.id.hostrecycler);
                hostadapter=new HostAdapter(hostList);
                hostlayoutmanager=new LinearLayoutManager(getApplicationContext());
                hostrecycler.setAdapter(hostadapter);
                hostrecycler.setLayoutManager(hostlayoutmanager);
                Toast.makeText(getApplicationContext(),hostList.get(1).getHostname(),Toast.LENGTH_LONG).show();

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"in error response",Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue= ResSingleton.getInstance().getRequestQueue(getApplicationContext());
        requestQueue.add(responseBody);






    }
}
