package com.naci.daggerditutorial.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.naci.daggerditutorial.R;

public abstract class BaseActivity extends AppCompatActivity {

    private String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
/*
    public void sendScreenTracking(String screenName) {
        */
    /**
     * for event
     *//*

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "Screen_Name_" + screenName);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, screenName);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        */

    /**
     * for screen
     *//*

        mFirebaseAnalytics.setCurrentScreen(this, screenName, null */
    /* class override *//*
);
    }
*/
    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        //if (!(fragment instanceof TopupSuccessFragment)) {
        super.onBackPressed();
        //}
    }

}
