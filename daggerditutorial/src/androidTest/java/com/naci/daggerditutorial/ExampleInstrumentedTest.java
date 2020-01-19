package com.naci.daggerditutorial;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.naci.daggerditutorial.data.UserRepository;
import com.naci.daggerditutorial.ui.main.MainViewModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.naci.daggerditutorial", appContext.getPackageName());
    }
}

public class LoginViewModelTest {

    @Test
    public void happyPath() {
        // You don't need Dagger to create an instance of LoginViewModel
        // You can pass a fake or mock UserRepository
        MainViewModel viewModel = new MainViewModel(asd);
        assertNull(viewModel.numberDataResponse);
    }
}
