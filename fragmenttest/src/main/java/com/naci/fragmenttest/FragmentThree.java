package com.naci.fragmenttest;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentThree extends Fragment implements IOnBackPressed {

    public static FragmentThree newInstance() {

        Bundle args = new Bundle();

        FragmentThree fragment = new FragmentThree();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_three, container, false);

        root.findViewById(R.id.btn_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getFragmentManager() != null) {
                    getFragmentManager().popBackStack("Fragment2", 0);
                }
            }
        });

        return root;
    }


    @Override
    public boolean onBackPressed() {
        getFragmentManager().popBackStack("Fragment2", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        return true;
    }
}
