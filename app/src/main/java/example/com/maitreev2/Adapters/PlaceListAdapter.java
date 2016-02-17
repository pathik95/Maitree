package example.com.maitreev2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import example.com.maitreev2.PlaceDetail;
import example.com.maitreev2.R;
import example.com.maitreev2.Response.ResponseList;
import example.com.maitreev2.Singleton.ResSingleton;

/**
 * Created by Hello on 18-01-2016.
 */
public class PlaceListAdapter extends BaseAdapter{

  //  String[] placename={"Place name1","Place Name2","Placw Name3","Place Name4","Place name5","Placename6","placename 7"};
    LayoutInflater mLayoutInflater;
    Context context;
    List<ResponseList.DatesEntity.PlacedetailsEntity> placelist;
   public PlaceListAdapter(Context context,List<ResponseList.DatesEntity.PlacedetailsEntity> placelist)
    {
        this.context=context;
        this.placelist=placelist;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return placelist.size();
    }

    @Override
    public ResponseList.DatesEntity.PlacedetailsEntity getItem(int position) {
        return placelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        final ViewHolder mViewHolder;
        if(convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.custlay,null);
            mViewHolder = new ViewHolder();
            mViewHolder.placename = (TextView) convertView.findViewById(R.id.txthead);
            mViewHolder.placetime = (TextView) convertView.findViewById(R.id.txttime);
            mViewHolder.placeid= (TextView) convertView.findViewById(R.id.txtid);
            mViewHolder.placeimage= (ImageView) convertView.findViewById(R.id.circleView);
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.placename.setText(getItem(position).getPlacename());
        mViewHolder.placetime.setText(getItem(position).getPlacetime());
        mViewHolder.placeid.setText(getItem(position).getPlaceid());

        Picasso.with(context).load(getItem(position).getIcon()).resize(50,50).centerCrop().into(mViewHolder.placeimage);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, PlaceDetail.class);
                ResSingleton.getInstance().setPlaceEntity(getItem(position));
                i.putExtra("placeid",mViewHolder.placeid.getText().toString());
                context.startActivity(i);
            }
        });
        return convertView;
    }
    static class ViewHolder {


        TextView placename;
        TextView placeid;
        TextView placetime;
        ImageView placeimage;

    }
}
