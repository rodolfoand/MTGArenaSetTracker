package com.rodolfo.mtgarenasettracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rodolfo.mtgarenasettracker.room.SetViewModel;
import com.rodolfo.mtgarenasettracker.svgdecoder.SvgDecoder;
import com.rodolfo.mtgarenasettracker.svgdecoder.SvgDrawableTranscoder;
import com.rodolfo.mtgarenasettracker.svgdecoder.SvgSoftwareLayerSetter;
import com.rodolfo.mtgarenasettracker.model.Set;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListAllSetsActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView allSetsRecyclerView;
    private SetAdapter setAdapter;
    private List<Set> listSets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_sets);

        allSetsRecyclerView =
                findViewById(R.id.setsRecyclerView);
        listSets = new ArrayList<>();
        setAdapter = new SetAdapter(listSets, this);
        allSetsRecyclerView.setAdapter(setAdapter);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(this);
        allSetsRecyclerView.setLayoutManager(linearLayoutManager);


        getListSets();

//        addSetButton = (MaterialButton)findViewById(R.id.addSetButton);
//        addSetButton.setOnClickListener(this);
//        addSetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "Add", Toast.LENGTH_LONG).show();
//            }
//        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK){
            Toast.makeText(this, "L", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "L2", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }

    private List<Set> getListSets() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.scryfall.com/sets/";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //textView.setText("Response: " + response.toString());
                        //Toast.makeText(context, "Response is: "+ response.toString(),Toast.LENGTH_LONG).show();
                        try {
                            Log.d("HTTPVolley", "Response is: "+ response.get("data").toString());
                            Gson gson = new Gson();
                            Type type = new TypeToken<List<Set>>(){}.getType();

                            List<Set> responseList = gson.fromJson(response.get("data").toString(), type);

                            listSets.clear();
                            listSets.addAll(responseList);
                            setAdapter.notifyDataSetChanged();


                            findViewById(R.id.progressBar).setVisibility(View.GONE);

                            Log.d("HTTPVolley", "Name is: "+ listSets.get(0).getName().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
        return null;
    }

}


class SetViewHolder extends RecyclerView.ViewHolder{
    TextView nameTextView;
    TextView setCardCountTextView;
    ImageView setImageView;
    MaterialButton addSetButton;

    SetViewHolder (View v){
        super (v);
        this.nameTextView =
                v.findViewById(R.id.setNameTextView);
        this.setCardCountTextView =
                v.findViewById(R.id.setCardCountTextView);
        this.setImageView =
                v.findViewById(R.id.setImageView);
        this.setImageView =
                v.findViewById(R.id.setImageView);
        this.addSetButton =
                v.findViewById(R.id.addSetButton);
    }
}

class SetAdapter extends RecyclerView.Adapter<SetViewHolder>{
    private List<Set> sets;
    private Context context;

    private SetViewModel mSetViewModel;
    public static final String EXTRA_REPLY = "com.rodolfo.mtgarenasettracker.REPLY";

    SetAdapter (List<Set> sets, Context context){
        this.sets = sets;
        this.context = context;
        this.mSetViewModel = new ViewModelProvider(((ListAllSetsActivity)context)).get(SetViewModel.class);
    }
    @NonNull
    @Override
    public SetViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                    parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.card_all_sets, parent,
                false);

        return new SetViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull SetViewHolder holder,
                                 int position) {

        Set m = sets.get(position);
        holder.nameTextView.setText(m.getName());

        GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder = Glide.with(context)
                .using(Glide.buildStreamModelLoader(Uri.class, context), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .listener(new SvgSoftwareLayerSetter<Uri>());

        requestBuilder.diskCacheStrategy(DiskCacheStrategy.NONE)
                .load(Uri.parse(m.getIcon_svg_uri()))
                .into(holder.setImageView);

        Log.d("HTTPVolley", m.getReleased_at());

        holder.setCardCountTextView.setText(String.valueOf(m.getCard_count()) + " cards.");


        holder.addSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "ADD" + m.getName(), Toast.LENGTH_LONG).show();

                mSetViewModel.insert(m);


                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY, m.getName());
                ((ListAllSetsActivity)context).setResult(((ListAllSetsActivity)context).RESULT_OK, replyIntent);
                ((ListAllSetsActivity)context).finish();
            }
        });

    }
    @Override
    public int getItemCount() {
        return sets.size();
    }

}