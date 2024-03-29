package com.example.oblig1.modelviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView mTextView = findViewById(R.id.tvNumber);
        MainActivityViewModel model = new ViewModelProvider(this).get((MainActivityViewModel.class));
        final Observer<String> randomObserver = new Observer<String>() {
            @Override
            public void onChanged(String newRandom) {
                mTextView.setText(newRandom);
            }
        };
        model.getNumber().observe(this,randomObserver);

        Log.i(TAG, "Random Number Set");
    }
    @Override
    public void onStop() {
        super.onStop();

        Log.i(TAG, "Stopping Activity");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();

        Log.i(TAG, "Destroying Activity");
    }
}
