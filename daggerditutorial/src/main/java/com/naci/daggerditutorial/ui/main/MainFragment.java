package com.naci.daggerditutorial.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.naci.daggerditutorial.MyApplication;
import com.naci.daggerditutorial.R;
import com.naci.daggerditutorial.data.remote.model.NumberData;
import com.naci.daggerditutorial.ui.ViewModelFactory;
import com.naci.daggerditutorial.ui.base.BaseFragment;

import javax.inject.Inject;
import javax.inject.Named;

public class MainFragment extends BaseFragment {

    private static final String TAG = MainFragment.class.getSimpleName();

    @Inject
    ViewModelFactory viewModelFactory;

    @Inject
    @Named("FirstModule")
    String firstModuleString;

    private MainViewModel mainViewModel;
    private Button button;


    static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.main_fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        if (getActivity() != null && getActivity().getApplication() != null) {
            MyApplication.getInstance().getMainComponent().inject(MainFragment.this);
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        button = view.findViewById(R.id.button);
        Log.d(TAG, "onCreateView: firstModuleString "+firstModuleString);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = new ViewModelProvider(this, viewModelFactory).get(MainViewModel.class);
        String appName = mainViewModel.getAppName();
        Toast.makeText(getContext(), appName, Toast.LENGTH_SHORT).show();
        setLiveDataObserver();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button.setOnClickListener(viewButton -> mainViewModel.fetchNumberData());
    }

    private void setLiveDataObserver() {
        mainViewModel.showProgress.observe(this, isSHow -> {
            if (isSHow == null) {
                return;
            }

            if (isSHow) {
                showProgressDialog();
            } else {
                hideProgressDialog();
            }
        });

        mainViewModel.numberDataResponse.observe(this, object -> {
            if (object instanceof NumberData) {
                NumberData numberData = (NumberData) object;
                Toast.makeText(getContext(), numberData.toString(), Toast.LENGTH_LONG).show();
            } else if (object instanceof Throwable) {
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDetach() {
        MyApplication.getInstance().clearMainComponent();
        super.onDetach();
    }
}
