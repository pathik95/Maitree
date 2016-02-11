package example.com.maitreev2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        //  Response.DatesEntity.PlacedetailsEntity entity= ResSingleton.getInstance().getPlaceEntity();
        //  if(entity!=null) {
        //      placename.setText(entity.getPlacename());
        //    basedesc.setText(entity.getBasedesc());
        //    extradesc.setText(entity.getExtradesc());
        //}
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //

    }
}
