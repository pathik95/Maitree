package example.com.maitreev2.Singleton;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

import example.com.maitreev2.Response;

/**
 * Created by Hello on 29-01-2016.
 */
public class ResSingleton {

    static ResSingleton obj;
    List<Response.DatesEntity> datesEntities;
    Response.DatesEntity.PlacedetailsEntity placeEntity;
    RequestQueue requestQueue;

    public Response.DatesEntity.PlacedetailsEntity getPlaceEntity() {
        return placeEntity;
    }

    public void setPlaceEntity(Response.DatesEntity.PlacedetailsEntity placeEntity) {
        this.placeEntity = placeEntity;
    }

    public static ResSingleton getInstance(){

        if(obj==null)
        {
            obj=new ResSingleton();

        }
        return obj;
    }

    public void setdateList(List<Response.DatesEntity> datesEntities)
    {

        this.datesEntities=datesEntities;
    }
    public  List<Response.DatesEntity> getdateList()
    {
        return datesEntities;
    }

    public RequestQueue getRequestQueue(Context context){
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(context);
        }
        return requestQueue;
    }


}
