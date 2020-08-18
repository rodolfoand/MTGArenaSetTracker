package com.rodolfo.mtgarenasettracker.http;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rodolfo.mtgarenasettracker.model.Set;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class HttpService extends AsyncTask<Void, Void, List<Set>> {

    @Override
    protected List<Set> doInBackground(Void... voids) {

        StringBuilder stringReturn = new StringBuilder();
        StringBuilder stringSets = new StringBuilder();

        try {
            URL url = new URL("https://api.scryfall.com/sets/");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                stringReturn.append(scanner.next());
            }

            JSONObject jsonObj = new JSONObject(stringReturn.toString());
            stringSets.append(jsonObj.get("data").toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("HTTPSet", stringSets.toString());


        Gson gson = new Gson();
        Type type = new TypeToken<List<Set>>(){}.getType();
        List<Set> setList = gson.fromJson(stringSets.toString(), type);


        //Log.d("HTTPSet", setList.get(6).getName());
        //Log.d("HTTPSet", setList.get(6).getIcon_svg_uri());

        return setList;
    }
}
