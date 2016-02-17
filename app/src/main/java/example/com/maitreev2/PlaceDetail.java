package example.com.maitreev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.gson.Gson;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.com.maitreev2.Response.ResponsePlaceDetails;
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
    @Bind(R.id.placeprogress)ProgressBar progressBar;
    @Bind(R.id.detailrel)RelativeLayout relativeLayout;
    @Bind(R.id.slider)SliderLayout mDemoSlider;

    Gson gson;
    String PLACEDETAILURL="http://vakratundasystem.in/harsh/maitree/placedetail.php?id=";
    ResponsePlaceDetails responseObj;
    List<ResponsePlaceDetails.PlaceEntity> placedetaillist;
    ResponsePlaceDetails.PlaceEntity placeEntity;
    String encodedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        progressBar.setVisibility(View.VISIBLE);
        relativeLayout.setVisibility(View.INVISIBLE);
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
                relativeLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Picasso.with(getApplicationContext()).load(placeEntity.getIcon()).fit().into(placeicon);
                HashMap<String,String> file_maps = new HashMap<String, String>();
                file_maps.put("image1",placeEntity.getImg1());
                file_maps.put("image2",placeEntity.getImg2());
                file_maps.put("image3", placeEntity.getImg3());

                for(String name : file_maps.keySet()){
                    TextSliderView textSliderView = new TextSliderView(getApplicationContext());
                    // initialize a SliderLayout
                    textSliderView
                            .image(file_maps.get(name))
                            .setScaleType(BaseSliderView.ScaleType.Fit);

                    //add your extra information

                    mDemoSlider.addSlider(textSliderView);
                }
                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
                mDemoSlider.setDuration(3000);


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
                        , PlaceDetail.this);
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
