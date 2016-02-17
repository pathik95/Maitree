package example.com.maitreev2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import example.com.maitreev2.Response.ResponseHost;
import example.com.maitreev2.Singleton.ResSingleton;


public class HostProfile extends AppCompatActivity {

    ResponseHost.HostEntity hostEntity;
    TextView hostname,hostmob,hostdesc,hostaddr;
    ImageView hosticon;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_profile);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hostname= (TextView) findViewById(R.id.hostname);
        hostaddr= (TextView) findViewById(R.id.hostaddress);
        hostdesc= (TextView) findViewById(R.id.hostdesc);
        hostmob= (TextView) findViewById(R.id.hostcontact);
        hosticon= (ImageView) findViewById(R.id.hostprofileicon);
        Intent i=getIntent();
       String id=i.getStringExtra("hostid");
        int temp= Integer.parseInt(id);
        temp=temp-1;
        hostEntity= ResSingleton.getInstance().getHostlist().get(temp);
        hostname.setText(hostEntity.getHostname());
        hostmob.setText(hostEntity.getMobno());
        hostdesc.setText(hostEntity.getDesc());
        hostaddr.setText(hostEntity.getAddress());
        Picasso.with(this).load(hostEntity.getHostpic()).resize(80,80).centerCrop().into(hosticon);

    }
}
