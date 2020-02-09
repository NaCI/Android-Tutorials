package com.naci.daggerditutorial.di;

import com.naci.daggerditutorial.di.module.Main.FirstModule;
import com.naci.daggerditutorial.di.module.Main.MainModule;
import com.naci.daggerditutorial.di.module.Main.SecondModule;
import com.naci.daggerditutorial.di.scope.MainScope;
import com.naci.daggerditutorial.ui.main.MainFragment;

import dagger.Subcomponent;

@MainScope
@Subcomponent(modules = {MainModule.class, FirstModule.class, SecondModule.class})
public interface MainComponent {

    @Subcomponent.Builder
    interface Builder {
        MainComponent.Builder mainModule(MainModule mainModule);

        MainComponent.Builder firstModule(FirstModule firstModule);

        MainComponent.Builder secondModule(SecondModule secondModule);

        MainComponent build();
    }

    void inject(MainFragment mainFragment);
}
