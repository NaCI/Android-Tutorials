package com.example.naci.retrofitsample.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naci.retrofitsample.R;
import com.example.naci.retrofitsample.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
