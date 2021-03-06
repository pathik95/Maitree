package example.com.maitreev2.Singleton;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

import example.com.maitreev2.Response.ResponseFood;
import example.com.maitreev2.Response.ResponseHost;
import example.com.maitreev2.Response.ResponseList;

/**
 * Created by Hello on 29-01-2016.
 */
public class ResSingleton {

    static ResSingleton obj;
    List<ResponseList.DatesEntity> datesEntities;
    List<ResponseFood.FoodEntity> foodEntities;

    public List<ResponseFood.FoodEntity> getFoodEntities() {
        return foodEntities;
    }

    public void setFoodEntities(List<ResponseFood.FoodEntity> foodEntities) {
        this.foodEntities = foodEntities;
    }

    List<ResponseHost.HostEntity> hostlist;
    ResponseList.DatesEntity.PlacedetailsEntity placeEntity;
    RequestQueue requestQueue;

    public ResponseList.DatesEntity.PlacedetailsEntity getPlaceEntity() {
        return placeEntity;
    }

    public void setPlaceEntity(ResponseList.DatesEntity.PlacedetailsEntity placeEntity) {
        this.placeEntity = placeEntity;
    }

    public static ResSingleton getInstance(){

        if(obj==null)
        {
            obj=new ResSingleton();

        }
        return obj;
    }

    public void setdateList(List<ResponseList.DatesEntity> datesEntities)
    {

        this.datesEntities=datesEntities;
    }
    public  List<ResponseList.DatesEntity> getdateList()
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

    public void setHostList(List<ResponseHost.HostEntity> hostList)
    {
        this.hostlist=hostList;


    }

    public List<ResponseHost.HostEntity> getHostlist()
    {
        return hostlist;
    }
}
