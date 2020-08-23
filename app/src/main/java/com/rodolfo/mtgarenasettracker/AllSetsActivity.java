package com.rodolfo.mtgarenasettracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.View;

import com.rodolfo.mtgarenasettracker.viewmodel.SetViewModel;
import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.view.adapter.AllSetsAdapter;


import java.util.List;

public class AllSetsActivity extends AppCompatActivity {

    private RecyclerView allSetsRecyclerView;
    private List<Set> listSets;

    private SetViewModel mSetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_sets);

        RecyclerView recyclerView = findViewById(R.id.setsRecyclerView);
        final AllSetsAdapter adapter = new AllSetsAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSetViewModel = new ViewModelProvider(this).get(SetViewModel.class);

        mSetViewModel.getHttpSet().observe(this, new Observer<List<Set>>() {
            @Override
            public void onChanged(List<Set> sets) {
                adapter.setSets(sets);
                findViewById(R.id.progressBar).setVisibility(View.GONE);
            }
        });


    }
}

