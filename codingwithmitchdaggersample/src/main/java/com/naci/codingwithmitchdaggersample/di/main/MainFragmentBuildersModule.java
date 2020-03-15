package com.naci.codingwithmitchdaggersample.di.main;

import com.naci.codingwithmitchdaggersample.ui.main.posts.PostsFragment;
import com.naci.codingwithmitchdaggersample.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();
}
