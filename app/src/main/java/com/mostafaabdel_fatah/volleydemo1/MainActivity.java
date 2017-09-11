package com.mostafaabdel_fatah.volleydemo1;

import android.app.DownloadManager;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String server_url = "http://10.0.2.2/MyWebSites/greeting.php";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.serverResponse);
        /*// 1 + 2 or 2 only
        Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();*/
    }
    public void getServerData_btnClicked(View view) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("SomeThing is error..."+error.getMessage());
                error.printStackTrace();
            }
        });
        SingleTon.getsInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
/* // 2
    public void getServerData_btnClicked(View view) {
        final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response);
                requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("SomeThing is error..."+error.getMessage());
                error.printStackTrace();
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
    }
    */
}
