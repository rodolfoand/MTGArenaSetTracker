package com.rodolfo.mtgarenasettracker.service;

import android.content.Context;

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
import com.rodolfo.mtgarenasettracker.model.Set;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Scryfall {

    private RequestQueue queue;
    private Context context;
    private String url = "https://api.scryfall.com/sets/";

    public Scryfall(Context context) {
        this.queue = Volley.newRequestQueue(context);
    }

    public LiveData<List<Set>> getSet(){
        MutableLiveData<List<Set>> mutableLiveData = new MutableLiveData<>();

        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                List<Set> setList = new ArrayList<>();
                Type type = new TypeToken<List<Set>>(){}.getType();
                setList.clear();
                try {
                    setList = gson.fromJson(response.get("data").toString(), type);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                mutableLiveData.setValue(setList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(json);

        return mutableLiveData;
    }

    public LiveData<Set> getSet(String code){
        MutableLiveData<Set> mutableLiveData = new MutableLiveData<>();

        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url + code, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                Set set = gson.fromJson(String.valueOf(response), Set.class);

                mutableLiveData.setValue(set);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(json);

        return mutableLiveData;
    }
}
