package com.naci.daggerditutorial.ui.main;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.naci.daggerditutorial.MyApplication;
import com.naci.daggerditutorial.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyApplication.getInstance().getAppComponent().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ImageView imgView = findViewById(R.id.main_activity_iv_header);
        requestManager.load(R.drawable.ic_launcher_foreground)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imgView);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
