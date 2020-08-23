package com.rodolfo.mtgarenasettracker;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.viewmodel.SetViewModel;
import com.rodolfo.mtgarenasettracker.view.adapter.AllSetsAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private SetViewModel mSetViewModel;
    public static final int ALL_SETS_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSetViewModel = new ViewModelProvider(this).get(SetViewModel.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AllSetsActivity.class);
                startActivityForResult(intent, ALL_SETS_ACTIVITY_REQUEST_CODE);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ALL_SETS_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            String code = data.getStringExtra(AllSetsAdapter.EXTRA_REPLY);

            mSetViewModel.getSets(code).observe(this, new Observer<Set>() {
                @Override
                public void onChanged(Set set) {
                    mSetViewModel.insert(set);
                    Toast.makeText(getApplication(), code, Toast.LENGTH_SHORT).show();
                }
            });

            mSetViewModel.getRarity(code, "common").observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    mSetViewModel.updateCommon(code, integer);
                }
            });

            mSetViewModel.getRarity(code, "uncommon").observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    mSetViewModel.updateCommon(code, integer);
                }
            });

            mSetViewModel.getRarity(code, "rare").observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    mSetViewModel.updateCommon(code, integer);
                }
            });

            mSetViewModel.getRarity(code, "mythic").observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    mSetViewModel.updateCommon(code, integer);
                }
            });
        }
    }
}