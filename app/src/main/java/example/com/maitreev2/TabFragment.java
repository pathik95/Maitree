package example.com.maitreev2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.com.maitreev2.Adapters.MeetAdapter;
import example.com.maitreev2.Adapters.PickAdapter;
import example.com.maitreev2.Adapters.PlaceListAdapter;

/**
 * Created by Hello on 18-01-2016.
 */
public class TabFragment extends Fragment {


    Response.DatesEntity datesEntity;
    public TabFragment(Response.DatesEntity datesEntity){
       this.datesEntity=datesEntity;
    }

    ListView listView;
    ListView meetlist;
    ListView picklist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_tab,container,false);

        List<Response.DatesEntity.PlacedetailsEntity> placepointlist=datesEntity.getPlacedetails();
        List<Response.DatesEntity.MeetingpointsEntity> meetpointlist=datesEntity.getMeetingpoints();
        List<Response.DatesEntity.PickuppointsEntity> pickpointlist=datesEntity.getPickuppoints();
        listView= (ListView) view.findViewById(R.id.placelist);
        listView.setAdapter(new PlaceListAdapter(getContext(),placepointlist));
        int count=listView.getCount();
        int height= (int) getResources().getDimension(R.dimen.placelist);
        int totalheight=height*count;
        listView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, totalheight));

        meetlist= (ListView) view.findViewById(R.id.meetlist);
        meetlist.setAdapter(new MeetAdapter(getContext(), meetpointlist));
        count=meetlist.getCount();
        height= (int) getResources().getDimension(R.dimen.meetlist_height);
        totalheight=height*count;
        meetlist.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, totalheight));
        picklist= (ListView) view.findViewById(R.id.picklist);
        picklist.setAdapter(new PickAdapter(getContext(),pickpointlist));
        count=picklist.getCount();
        height= (int) getResources().getDimension(R.dimen.meetlist_height);
        totalheight=height*count;
        picklist.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, totalheight));







       // View v=inflater.inflate(R.layout.custlay,null);

       // PlaceHeight=listView.getCount()*v.getHeight();
       // listView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,PlaceHeight));
       // Toast.makeText(getContext(),String.valueOf(v.getHeight())+"*"+String.valueOf(listView.getCount()),Toast.LENGTH_LONG).show();

        return view;

    }
}
