package com.rodolfo.mtgarenasettracker.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.google.android.material.button.MaterialButton;
import com.rodolfo.mtgarenasettracker.AllSetsActivity;
import com.rodolfo.mtgarenasettracker.R;
import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.service.util.SvgDecoder;
import com.rodolfo.mtgarenasettracker.service.util.SvgDrawableTranscoder;
import com.rodolfo.mtgarenasettracker.service.util.SvgSoftwareLayerSetter;
import com.rodolfo.mtgarenasettracker.viewmodel.SetViewModel;

import java.io.InputStream;
import java.util.List;

public class AllSetsAdapter extends RecyclerView.Adapter<AllSetsAdapter.AllSetViewHolder> {

    class AllSetViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView setCardCountTextView;
        ImageView setImageView;
        MaterialButton addSetButton;



        public AllSetViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nameTextView =
                    itemView.findViewById(R.id.setNameTextView);
            this.setCardCountTextView =
                    itemView.findViewById(R.id.totalCardsTextView);
            this.setImageView =
                    itemView.findViewById(R.id.setImageView);
            this.setImageView =
                    itemView.findViewById(R.id.setImageView);
            this.addSetButton =
                    itemView.findViewById(R.id.addSetButton);

        }
    }

    private final LayoutInflater mInflater;
    private List<Set> mSets; // Cached copy of words
    private Context context;
    public static final String EXTRA_REPLY = "com.rodolfo.mtgarenasettracker.REPLY";
    private SetViewModel mSetViewModel;
    private List<Set> mySets;


    public AllSetsAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        mySets = new ViewModelProvider((AllSetsActivity)context)
                .get(SetViewModel.class)
                .getMySets()
                .getValue();
    }

    @Override
    public AllSetsAdapter.AllSetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.card_all_sets, parent, false);
        return new AllSetsAdapter.AllSetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AllSetsAdapter.AllSetViewHolder holder, int position) {
        if (mSets != null) {
            Set current = mSets.get(position);

//            if (mySets.contains(current)) {
//                holder.addSetButton.setChecked(false);
//                holder.addSetButton.setText("1");
//            }

            //holder.setNameTextView.setText(current.getName());

            //Set m = sets.get(position);
            holder.nameTextView.setText(current.getName());

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
                    .load(Uri.parse(current.getIcon_svg_uri()))
                    .into(holder.setImageView);

            Log.d("HTTPVolley", current.getReleased_at());

            holder.setCardCountTextView.setText(String.valueOf(current.getCard_count()) + " cards.");


            holder.addSetButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, "ADD" + m.getName(), Toast.LENGTH_LONG).show();

                    //mSetViewModel.insert(m);


                    Intent replyIntent = new Intent();
                    replyIntent.putExtra(EXTRA_REPLY, current.getCode());
                    ((AllSetsActivity)context).setResult(((AllSetsActivity)context).RESULT_OK, replyIntent);
                    ((AllSetsActivity)context).finish();
                }
            });


        } else {
            // Covers the case of data not being ready yet.
            //holder.wordItemView.setText("No Word");
        }
    }

    public void setSets(List<Set> sets){
        mSets = sets;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mSets != null)
            return mSets.size();
        else return 0;
    }


}