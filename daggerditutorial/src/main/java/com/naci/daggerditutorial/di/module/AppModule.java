package com.naci.daggerditutorial.di.module;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.naci.daggerditutorial.Constants;
import com.naci.daggerditutorial.MyApplication;
import com.naci.daggerditutorial.R;
import com.naci.daggerditutorial.data.remote.LoginRetrofitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// @Module informs Dagger that this class is a Dagger Module
@Module
public class AppModule {

    Application mApplication;

    public AppModule(MyApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions
                .placeholderOf(R.drawable.ic_donut_large)
                .error(R.drawable.ic_donut_large);
    }

    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions) {
        return Glide.with(application).setDefaultRequestOptions(requestOptions);
    }
}
