package com.rodolfo.mtgarenasettracker.view.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.rodolfo.mtgarenasettracker.MainActivity;
import com.rodolfo.mtgarenasettracker.R;
import com.rodolfo.mtgarenasettracker.model.Set;

import java.util.List;

public class MySetsAdapter extends RecyclerView.Adapter<MySetsAdapter.MySetViewHolder> {

    class MySetViewHolder extends RecyclerView.ViewHolder {
        private final TextView setNameTextView;
        private final TextView totalTextView;
        private final TextView totalRareTextView;
        private final TextView totalMythicTextView;
        private final TextView totalCommonTextView;
        private final TextView totalUncommunTextView;
        private final MaterialCardView mySetCardView;

        private MySetViewHolder(View itemView) {
            super(itemView);
            setNameTextView = itemView.findViewById(R.id.setNameTextView);
            totalTextView = itemView.findViewById(R.id.totalTextView);
            totalRareTextView = itemView.findViewById(R.id.totalRareTextView);
            totalMythicTextView = itemView.findViewById(R.id.totalMythicTextView);
            totalCommonTextView = itemView.findViewById(R.id.totalCommonTextView);
            totalUncommunTextView = itemView.findViewById(R.id.totalUncommunTextView);
            mySetCardView = itemView.findViewById(R.id.mySetCardView);
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
            holder.totalTextView.setText(String.valueOf(current.getTotal_cards()));
            holder.totalRareTextView.setText(String.valueOf(current.getRare()));
            holder.totalMythicTextView.setText(String.valueOf(current.getMythic()));
            holder.totalCommonTextView.setText(String.valueOf(current.getCommon()));
            holder.totalUncommunTextView.setText(String.valueOf(current.getUncommon()));

            holder.mySetCardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    new MaterialAlertDialogBuilder(v.getContext())
                            .setTitle(R.string.deleteSet)
                            .setMessage(R.string.deleteConfirm)
                            .setNegativeButton(R.string.cancel, null)
                            .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ((MainActivity) v.getContext()).deleteSet(current);
                                }
                            })
                            .show();
                    return false;
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
