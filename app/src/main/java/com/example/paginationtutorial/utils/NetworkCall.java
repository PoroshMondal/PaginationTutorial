package com.example.paginationtutorial.utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.paginationtutorial.interfaces.VolleyCallback;

public class NetworkCall {

    private Context context;
    private VolleyCallback volleyCallback;

    public NetworkCall(Context context) {
        this.context = context;
    }

    public void setVolleyCallbackListener(VolleyCallback volleyCallback) {
        this.volleyCallback = volleyCallback;
    }

    public void requestToServer(String url) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        volleyCallback.onSuccessResponse(response);
                        //Log.d("json_data",response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Failed to fetch data !", Toast.LENGTH_SHORT).show();
            }
        });

        MySingleton.getInstance(context.getApplicationContext()).addToRequestQueue(stringRequest);
    }

}
