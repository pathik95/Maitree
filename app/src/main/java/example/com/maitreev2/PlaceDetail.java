package example.com.maitreev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.com.maitreev2.Adapters.TabsPagerAdapter;
import example.com.maitreev2.Singleton.ResSingleton;

public class PlaceDetail extends AppCompatActivity {
    @Bind(R.id.placename)
    TextView placename;
    @Bind(R.id.basedesc)
    TextView basedesc;
    @Bind(R.id.extradesc)
    TextView extradesc;
    @Bind(R.id.coordinatorname)
    TextView coordinatorname;
    @Bind(R.id.placeicon)
    ImageView placeicon;

    Gson gson;
    String PLACEDETAILURL="http://10.0.2.2/maitree/placedetail.php?id=";
    ResponsePlaceDetails responseObj;
    List<ResponsePlaceDetails.PlaceEntity> placedetaillist;
    ResponsePlaceDetails.PlaceEntity placeEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        Intent i=getIntent();
        String id=i.getStringExtra("placeid");


        StringRequest responseBody=new StringRequest(PLACEDETAILURL+id, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText(HomeActivity.this, responsestr, Toast.LENGTH_LONG).show();
                //Log.d("response", responsestr);
                gson = new Gson();
                responseObj = gson.fromJson(response, ResponsePlaceDetails.class);
                placedetaillist = responseObj.getPlace();
                placeEntity=placedetaillist.get(0);
                placename.setText(placeEntity.getPlacename());
                basedesc.setText(placeEntity.getBasedesc());
                extradesc.setText(placeEntity.getExtradesc());
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= ResSingleton.getInstance().getRequestQueue(getApplicationContext());
        requestQueue.add(responseBody);

        //  if(entity!=null) {
        //      placename.setText(entity.getPlacename());
        //    basedesc.setText(entity.getBasedesc());
        //    extradesc.setText(entity.getExtradesc());
        //}
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //

    }
}
