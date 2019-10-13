package com.example.naci.retrofitsample.ui.anime;

import android.os.Bundle;

import com.example.naci.retrofitsample.R;
import com.example.naci.retrofitsample.ui.base.BaseActivity;

public class AnimeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AnimeFragment.newInstance())
                    .commitNow();
        }
    }
}
