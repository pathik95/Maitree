package example.com.maitreev2.Adapters;

/**
 * Created by Hello on 19-01-2016.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import example.com.maitreev2.HostProfile;
import example.com.maitreev2.R;

import example.com.maitreev2.Response.ResponseHost;


public class HostAdapter extends RecyclerView.Adapter<HostAdapter.CustomViewHolder> {

    private final Context context;
    private List<ResponseHost.HostEntity> hostlist;

    public HostAdapter(Context context,List<ResponseHost.HostEntity> hostlist)
    {
        this.hostlist=hostlist;
        this.context = context;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hostrow, null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              TextView tv= (TextView) view.findViewById(R.id.hostlistid);
                Intent i=new Intent(context, HostProfile.class);
                i.putExtra("hostid",tv.getText());
                context.startActivity(i);
            }
        });
        CustomViewHolder viewHolder = new CustomViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.hostlistname.setText(hostlist.get(position).getHostname());
        holder.hostlistid.setText(hostlist.get(position).getHostid());
        Picasso.with(context).load(hostlist.get(position).getHostpic()).into(holder.hostlisticon);
         //   String encodedImage=hostlist.get(position).getHostpic();
          //  byte[] decodedString = Base64.decode(encodedImage.getBytes(), Base64.DEFAULT);
           // Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
          //  holder.hostlisticon.setImageBitmap(decodedByte);


    }


    @Override
    public int getItemCount() {
        return (null != hostlist ? hostlist.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView hostlistname,hostlistid;
        ImageView hostlisticon;


        public CustomViewHolder(View itemView) {
            super(itemView);

            this.hostlisticon= (ImageView) itemView.findViewById(R.id.hostlisticon);
            this.hostlistid= (TextView) itemView.findViewById(R.id.hostlistid);
            this.hostlistname= (TextView) itemView.findViewById(R.id.hostlistname);
        }
    }
}
