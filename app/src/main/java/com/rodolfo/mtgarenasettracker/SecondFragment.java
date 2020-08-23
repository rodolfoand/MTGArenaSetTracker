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

import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.viewmodel.SetViewModel;

import java.util.List;

public class SecondFragment extends Fragment {

    private SetViewModel mSetViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);


        mSetViewModel = new ViewModelProvider(this).get(SetViewModel.class);

        mSetViewModel.getSets().observe(getActivity(), new Observer<List<Set>>() {
            @Override
            public void onChanged(List<Set> sets) {
                Toast.makeText(getActivity(), sets.get(0).getName(), Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}