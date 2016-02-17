package example.com.maitreev2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;

import java.util.List;

import example.com.maitreev2.Adapters.FoodAdapter;
import example.com.maitreev2.Response.ResponseFood;
import example.com.maitreev2.Singleton.ResSingleton;

public class FoodListActivity extends AppCompatActivity {

    final String FOODURL="http://vakratundasystem.in/harsh/maitree/getFood.php";
    ResponseFood responsseObj;
    List<ResponseFood.FoodEntity> FoodList;
    Gson hgson;
    ProgressBar progressBar;
    RecyclerView Foodrecycler;
    FoodAdapter Foodadapter;
    RecyclerView.LayoutManager Foodlayoutmanager;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Foodrecycler= (RecyclerView) findViewById(R.id.foodrecycler);
        Foodrecycler.setVisibility(View.INVISIBLE);
        progressBar= (ProgressBar) findViewById(R.id.foodlistprog);
        progressBar.setVisibility(View.VISIBLE);
        StringRequest responseBody=new StringRequest(FOODURL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText(HomeActivity.this, responsestr, Toast.LENGTH_LONG).show();
                //Log.d("response", responsestr);
                hgson = new Gson();
                responsseObj = hgson.fromJson(response, ResponseFood.class);
                FoodList = responsseObj.getFood();

                Foodadapter=new FoodAdapter(FoodListActivity.this,FoodList);
                Foodlayoutmanager=new LinearLayoutManager(getApplicationContext());
                Foodrecycler.setLayoutManager(Foodlayoutmanager);
                Foodrecycler.setAdapter(Foodadapter);
                Foodrecycler.setHasFixedSize(true);
                Foodrecycler.setVisibility(View.VISIBLE);
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
                        , FoodListActivity.this);
            }
        });
        RequestQueue requestQueue= ResSingleton.getInstance().getRequestQueue(getApplicationContext());
        requestQueue.add(responseBody);
    }
}
