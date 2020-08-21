package com.rodolfo.mtgarenasettracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rodolfo.mtgarenasettracker.adapter.MySetsListAdapter;
import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.room.SetViewModel;

import java.util.List;

public class MySetsFragment extends Fragment {

    private SetViewModel mSetViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.mySetsRecyclerView);
        final MySetsListAdapter adapter = new MySetsListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mSetViewModel = new ViewModelProvider(this).get(SetViewModel.class);

        mSetViewModel.getMySets().observe(getActivity(), new Observer<List<Set>>() {
            @Override
            public void onChanged(List<Set> sets) {
                adapter.setSets(sets);
            }
        });

        return rootView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "1", Toast.LENGTH_LONG).show();
                NavHostFragment.findNavController(MySetsFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}