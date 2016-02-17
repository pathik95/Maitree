package example.com.maitreev2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;

import java.util.List;

import example.com.maitreev2.Adapters.HostAdapter;
import example.com.maitreev2.Response.ResponseFood;
import example.com.maitreev2.Response.ResponseHost;
import example.com.maitreev2.Singleton.ResSingleton;

public class HostList extends AppCompatActivity {


    final String HOSTURL="http://vakratundasystem.in/harsh/maitree/getHost.php";
    ResponseHost responsseObj;
    List<ResponseHost.HostEntity> hostList;
    Gson hgson;
    ProgressBar progressBar;
    RecyclerView hostrecycler;
    HostAdapter hostadapter;
    RecyclerView.LayoutManager hostlayoutmanager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_list);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar= (ProgressBar) findViewById(R.id.hostlistprog);

        StringRequest responseBody=new StringRequest(HOSTURL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText(HomeActivity.this, responsestr, Toast.LENGTH_LONG).show();
                //Log.d("response", responsestr);
                hgson = new Gson();
                responsseObj = hgson.fromJson(response, ResponseHost.class);
                hostList = responsseObj.getHost();
                ResSingleton.getInstance().setHostList(hostList);
                hostrecycler= (RecyclerView) findViewById(R.id.hostrecycler);
                hostadapter=new HostAdapter(HostList.this,hostList);
                hostlayoutmanager=new LinearLayoutManager(getApplicationContext());
                hostrecycler.setLayoutManager(hostlayoutmanager);
                hostrecycler.setAdapter(hostadapter);
                hostrecycler.setHasFixedSize(true);
                hostrecycler.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                 // activity where it is displayed
                SnackbarManager.show(Snackbar.with(getApplicationContext()) // context
                        .text("Can not connect to server!") // text to display
                        .actionLabel("retry") // action button label
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked(Snackbar snackbar) {
                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            }
                        }) // action button's ActionClickListener
                        , HostList.this);
            }
        });
        RequestQueue requestQueue= ResSingleton.getInstance().getRequestQueue(getApplicationContext());
        requestQueue.add(responseBody);






    }
}
