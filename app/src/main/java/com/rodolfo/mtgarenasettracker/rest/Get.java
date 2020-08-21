package com.rodolfo.mtgarenasettracker.rest;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rodolfo.mtgarenasettracker.R;
import com.rodolfo.mtgarenasettracker.model.Set;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class Get {

    private RequestQueue queue;
    private String url;
    private Context context;
    private JSONObject jsonObject;


    public Get(Context context) {
        this.context = context;
        this.queue = Volley.newRequestQueue(this.context);
    }

    public LiveData<List<Set>> getSets(String url){
        this.url = "https://api.scryfall.com/sets/" + url;
        List<Set> setList = null;
        MutableLiveData<List<Set>> listLiveData = null;

        Gson gson = new Gson();
        JSONObject response = get();

        if (response.has("data")){
            try {
                Type type = new TypeToken<List<Set>>(){}.getType();
                setList = gson.fromJson(response.get("data").toString(), type);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            setList.add(gson.fromJson(response.toString(), Set.class));
        }

        listLiveData.setValue(setList);
        return listLiveData;
    }

    private JSONObject get(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        jsonObject = response;
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
        return jsonObject;
    }
}
