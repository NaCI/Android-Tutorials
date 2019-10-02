package com.example.naci.daggertutorial_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * Fundamental DI Techniques
     * - Constructor Injection
     * - Method Injection
     * - Field Injection
     * - Reflection (kinda backdoor)
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
