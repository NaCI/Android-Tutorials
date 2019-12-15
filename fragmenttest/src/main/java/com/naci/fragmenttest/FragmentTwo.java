package com.naci.fragmenttest;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    public static FragmentTwo newInstance() {

        Bundle args = new Bundle();

        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_two, container, false);

        root.findViewById(R.id.btn_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTwo two = new FragmentTwo();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, FragmentThree.newInstance())
                        .addToBackStack("Fragment3")
                        .commit();
            }
        });

        return root;
    }
}
