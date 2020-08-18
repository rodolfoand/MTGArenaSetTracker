package com.rodolfo.mtgarenasettracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.rodolfo.mtgarenasettracker.http.SvgDecoder;
import com.rodolfo.mtgarenasettracker.http.SvgDrawableTranscoder;
import com.rodolfo.mtgarenasettracker.http.SvgSoftwareLayerSetter;
import com.rodolfo.mtgarenasettracker.http.Utils;
import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.http.HttpService;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    private RecyclerView setsRecyclerView;
    private SetAdapter adapter;
    private List<Set> sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setsRecyclerView =
                findViewById(R.id.setsRecyclerView);
        sets = new ArrayList<>();
        adapter = new SetAdapter(sets, this);
        setsRecyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(this);
        //linearLayoutManager.setReverseLayout(true);
        setsRecyclerView.setLayoutManager(linearLayoutManager);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Set> retorno = new ArrayList<>();
                try {
                    retorno = new HttpService().execute().get();
                    sets.clear();
                    sets.addAll(retorno);

                    adapter.notifyDataSetChanged();

                    if (retorno != null) {
                        Snackbar.make(view, retorno.get(1).getName() + sets.size() + adapter.getItemCount(), Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }



//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

class SetViewHolder extends RecyclerView.ViewHolder{
    TextView nameTextView;
    ImageView setImageView;
    SetViewHolder (View v){
        super (v);
        this.nameTextView =
                v.findViewById(R.id.nameTextView);
        this.setImageView =
                v.findViewById(R.id.setImageView);
    }
}

class SetAdapter extends RecyclerView.Adapter<SetViewHolder>{
    private List<Set> sets;
    private Context context;
    SetAdapter (List<Set> sets, Context context){
        this.sets = sets;
        this.context = context;
    }
    @NonNull
    @Override
    public SetViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                     parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.set_list_item, parent,
                false);
        return new SetViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull SetViewHolder holder,
                                 int position) {
        Set m = sets.get(position);


        holder.nameTextView.setText(m.getName());

        //Utils.fetchSvg(context, m.getIcon_svg_uri(), holder.setImageView);
        //Utils.fetchSvg(context, "https://img.scryfall.com/sets/m21.svg", holder.setImageView);

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



//        SvgLoader.pluck()
//                .with()
//                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
//                .load(m.getIcon_svg_uri(), holder.setImageView);


        //ImageView imageView = holder.setImageView;

        //Picasso.get().load(m.getIcon_svg_uri()).into(imageView);

        //holder.setImageView.setImageAlpha(imageView.getImageAlpha());

//        try {
//            holder.setImageView = new GetBitmap(m.getIcon_svg_uri())
//                            .execute()
//                            .get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Glide.with(context)
//                .asDrawable()
//                .load(m.getIcon_svg_uri())
//                .into(holder.setImageView);


        //holder.setImageView.setImageDrawable();

        //Picasso.get().load(m.getIcon_svg_uri()).into(holder.setImageView);

        //mensagemEditText.setText("");
    }
    @Override
    public int getItemCount() {
        return sets.size();
    }

}
//class GetBitmap extends AsyncTask<Void, Void, ImageView> {
//
//    String url;
//
//    public GetBitmap(String url) {
//        this.url = url;
//    }
//
//    @Override
//    protected Drawable doInBackground(Void... voids) {
//        Bitmap bitmap = null;
//        Drawable drawable = null;
//        ImageView imageView = null;
//
//        try {
//            //bitmap = Picasso.get().load(url).get();
//            //Picasso.get().load(url).into(imageView);
//            //drawable = Glide.with(v).load(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return drawable;
//    }
//}