package com.naci.codingwithmitchdaggersample.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.naci.codingwithmitchdaggersample.R;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    //TODO: retrofit instance, glide instance // other singleton objects could be declared here

    @Provides
    static String baseUrl() {
        return "https://google.com";
    }

    @Provides
    static boolean getApp(Application application) {
        return application == null;
    }

    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions
                .placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background)
                .circleCrop();
    }

    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions) {
        return Glide.with(application).setDefaultRequestOptions(requestOptions);
    }

    @Provides
    static Drawable provideAppDrawable(Application application) {
        return ContextCompat.getDrawable(application, R.drawable.logo);
    }
}
