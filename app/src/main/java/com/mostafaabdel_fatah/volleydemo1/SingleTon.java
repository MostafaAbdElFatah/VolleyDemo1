package com.mostafaabdel_fatah.volleydemo1;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Mostafa AbdEl_Fatah on 9/8/2017.
 */

public class SingleTon {

    private static SingleTon sInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private SingleTon(Context context1){
        context = context1;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return  requestQueue;
    }
    public static synchronized SingleTon getsInstance(Context context1){
        if (sInstance == null){
            sInstance = new SingleTon(context1);
        }
        return sInstance;
    }
    public<T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
