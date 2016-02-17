package example.com.maitreev2.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.squareup.picasso.Picasso;

import java.util.List;

import example.com.maitreev2.R;

import example.com.maitreev2.Response.ResponseFood;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.CustomViewHolder> {

    private final Context context;
    private List<ResponseFood.FoodEntity> foodlist;

    public FoodAdapter(Context context,List<ResponseFood.FoodEntity> foodlist)
    {
        this.foodlist=foodlist;
        this.context = context;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custlay, null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv= (TextView) view.findViewById(R.id.txtid);
                SnackbarManager.show(
                        Snackbar.with(context)
                                .text(tv.getText()));
            }
        });
        CustomViewHolder viewHolder = new CustomViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.foodlistname.setText(foodlist.get(position).getFoodname());
        holder.foodlistid.setText(foodlist.get(position).getFoodid());
        holder.foodlistplace.setText(foodlist.get(position).getFoodat());
        Picasso.with(context).load(foodlist.get(position).getIcon()).into(holder.foodlisticon);
        //   String encodedImage=hostlist.get(position).getHostpic();
        //  byte[] decodedString = Base64.decode(encodedImage.getBytes(), Base64.DEFAULT);
        // Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        //  holder.hostlisticon.setImageBitmap(decodedByte);


    }


    @Override
    public int getItemCount() {
        return (null != foodlist ? foodlist.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView foodlistname,foodlistid,foodlistplace;
        ImageView foodlisticon;


        public CustomViewHolder(View itemView) {
            super(itemView);

            this.foodlisticon= (ImageView) itemView.findViewById(R.id.circleView);
            this.foodlistid= (TextView) itemView.findViewById(R.id.txtid);
            this.foodlistname= (TextView) itemView.findViewById(R.id.txthead);
            this.foodlistplace= (TextView) itemView.findViewById(R.id.txttime);
        }
    }
}
