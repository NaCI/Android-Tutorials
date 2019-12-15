package com.naci.daggerditutorial.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.naci.daggerditutorial.MyApplication;
import com.naci.daggerditutorial.R;
import com.naci.daggerditutorial.data.remote.model.NumberData;
import com.naci.daggerditutorial.ui.base.BaseFragment;

import javax.inject.Inject;

public class MainFragment extends BaseFragment {

    @Inject
    MainViewModel mainViewModel;

    private Button button;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.main_fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        if (getActivity() != null && getActivity().getApplication() != null) {
            ((MyApplication) getActivity().getApplication()).applicationComponent.inject(MainFragment.this);
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        button = view.findViewById(R.id.button);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
        String appName = mainViewModel.getAppName();
        Toast.makeText(getContext(), appName, Toast.LENGTH_SHORT).show();
        setLiveDataObserver();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.fetchNumberData();
            }
        });
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
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
