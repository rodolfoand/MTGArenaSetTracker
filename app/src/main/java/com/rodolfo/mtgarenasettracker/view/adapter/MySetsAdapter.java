package com.rodolfo.mtgarenasettracker.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rodolfo.mtgarenasettracker.R;
import com.rodolfo.mtgarenasettracker.model.Set;

import java.util.List;

public class MySetsAdapter extends RecyclerView.Adapter<MySetsAdapter.MySetViewHolder> {

    class MySetViewHolder extends RecyclerView.ViewHolder {
        private final TextView setNameTextView;
        private final TextView setCardCountTextView;

        private MySetViewHolder(View itemView) {
            super(itemView);
            setNameTextView = itemView.findViewById(R.id.setNameTextView);
            setCardCountTextView = itemView.findViewById(R.id.setCardCountTextView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Set> mSets; // Cached copy of words

    public MySetsAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public MySetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.card_my_sets, parent, false);
        return new MySetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MySetViewHolder holder, int position) {
        if (mSets != null) {
            Set current = mSets.get(position);
            holder.setNameTextView.setText(current.getName());
            holder.setCardCountTextView.setText(String.valueOf(current.getCommon()));
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
