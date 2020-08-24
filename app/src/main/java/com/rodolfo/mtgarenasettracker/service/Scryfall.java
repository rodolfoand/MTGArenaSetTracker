package com.rodolfo.mtgarenasettracker.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
import com.rodolfo.mtgarenasettracker.model.Card;
import com.rodolfo.mtgarenasettracker.model.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Scryfall {

    private RequestQueue queue;
    private Context context;
    private String url = "https://api.scryfall.com/";
//    "https://api.scryfall.com/cards/search?q=s%3Am21+r%3Arare"

    public Scryfall(Context context) {
        this.queue = Volley.newRequestQueue(context);
    }

    public LiveData<List<Set>> getSets(){

        MutableLiveData<List<Set>> mutableLiveData = new MutableLiveData<>();

        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url + "sets/", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("HTTPpass", "1");
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

    public LiveData<Set> getSets(String code){
        Log.d("HTTPpass", "2");
        MutableLiveData<Set> mutableLiveData = new MutableLiveData<>();

        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url + "sets/" + code, null, new Response.Listener<JSONObject>() {
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

    public LiveData<Integer> getRarity(String set, String rarity){
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET,
                url + "cards/search?q=s%3A" + set + "+r%3A" + rarity,
                null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                Log.d("HTTPpass", response.toString());
                Gson gson = new Gson();

                Integer total_cards = new Integer(0);
                try {
                    total_cards = gson.fromJson(response.get("total_cards").toString(), Integer.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                mutableLiveData.setValue(total_cards);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(json);

        return mutableLiveData;
    }


    public LiveData<List<Card>> getCards(String set, String rarity, String url_more){

        MutableLiveData<List<Card>> mutableLiveData = new MutableLiveData<>();

        String urlCards;

        if (url_more.isEmpty()){
            urlCards = url + "cards/search?q=s%3A" + set + "+r%3A" + rarity;
        } else {
            urlCards = url_more;
        }

        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET,
                urlCards,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("HTTPpassCard", urlCards + response.toString());


                        Gson gson = new Gson();
                        List<Card> cardList = new ArrayList<>();
                        Type type = new TypeToken<List<Card>>(){}.getType();
                        cardList.clear();
                        try {
                            cardList = gson.fromJson(response.get("data").toString(), type);
//                            cardList.addAll(gson.fromJson(response.get("data").toString(), type));

                            Log.d("HTTPpassCard", cardList.size() + "");
                            if (response.get("has_more").toString().equals("true")){
                                getCards("", "", response.get("next_page").toString()).getValue();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        mutableLiveData.setValue(cardList);

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
