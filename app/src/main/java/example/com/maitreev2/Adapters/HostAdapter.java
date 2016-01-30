package example.com.maitreev2.Adapters;

/**
 * Created by Hello on 19-01-2016.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.com.maitreev2.R;
import example.com.maitreev2.Response;


/**
 * Created by Dalwadi on 11-09-2015.
 */


public class HostAdapter extends RecyclerView.Adapter<HostAdapter.ViewHolder> {


    private List<Response.HostEntity> hostList;

        // Int Array to store the passed icons resource value from MainActivity.java

       //String Resource for header view email


    // Creating a ViewHolder which extends the RecyclerView View Holder
    // ViewHolder are used to to store the inflated views in order to recycle them

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        int Holderid;

        TextView textView;
        ImageView imageView;
        TextView time;



        public ViewHolder(View itemView, int ViewType) {                 // Creating ViewHolder Constructor with View and viewType As a parameter
            super(itemView);
            itemView.setOnClickListener(this);

            // Here we set the appropriate view in accordance with the the view type as passed when the holder object is created


                textView = (TextView) itemView.findViewById(R.id.txthead); // Creating TextView object with the id of textView from item_row.xml
                imageView = (ImageView) itemView.findViewById(R.id.circleView);// Creating ImageView object with the id of ImageView from item_row.xml
                time= (TextView) itemView.findViewById(R.id.txttime);
                Holderid = 1;                                               // setting holder id as 1 as the object being populated are of type item row



            // Setting holder id = 0 as the object being populated are of type header view
            }

        @Override
        public void onClick(View v) {
            int i=getPosition();
        }
    }





    public HostAdapter(List<Response.HostEntity> hostList) { // HostAdapter Constructor with titles and icons parameter
        // titles, icons, name, email, profile pic are passed from the main activity as we
        this.hostList=hostList;
                         //here we assign those passed values to the values we declared here
        //in adapter


    }


    //Below first we ovverride the method onCreateViewHolder which is called when the ViewHolder is
    //Created, In this method we inflate the item_row.xml layout if the viewType is Type_ITEM or else we inflate header.xml
    // if the viewType is TYPE_HEADER
    // and pass it to the view holder

    @Override
    public HostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custlay, parent, false); //Inflating the layout

            ViewHolder vhItem = new ViewHolder(v, viewType); //Creating ViewHolder and passing the object of type view

            return vhItem; // Returning the created object

            //inflate your layout and pass it to view holder



    }

    //Next we override a method which is called when the item in a row is needed to be displayed, here the int position
    // Tells us item at which position is being constructed to be displayed and the holder id of the holder object tell us
    // which view type is being created 1 for item row
    @Override
    public void onBindViewHolder(HostAdapter.ViewHolder holder, int position) {
                                  // as the list view is going to be called after the header view so we decrement the
            // position by 1 and pass it to the holder while setting the text and image


          //  holder.textView.setText(mNavTitles[position]); // Setting the Text with the array of our Titles
            //holder.imageView.setImageResource(mIcons[position]);
           // holder.time.setText(mTimes[position]);


            // Settimg the image with array of our icons

    }

    // This method returns the number of items present in the list
    @Override
    public int getItemCount() {
        return hostList.size(); // the number of items in the list will be +1 the titles including the header view.
    }


    // Witht the following method we check what type of view is being passed
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
        {}
            return 0;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}