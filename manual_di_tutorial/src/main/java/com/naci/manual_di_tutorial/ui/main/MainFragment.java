package com.naci.manual_di_tutorial.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.naci.manual_di_tutorial.App;
import com.naci.manual_di_tutorial.R;
import com.naci.manual_di_tutorial.data.local.entities.Note;
import com.naci.manual_di_tutorial.di.AppContainer;

import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private Button button1, button2;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        button1 = view.findViewById(R.id.button);
        button2 = view.findViewById(R.id.button2);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AppContainer appContainer = ((App) getActivity().getApplication()).appContainer;
        mViewModel = appContainer.mainViewModelFactory.create();
        //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.addSomeData();
                Toast.makeText(getContext(), "Data Added", Toast.LENGTH_LONG).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Note> listOfNotes = mViewModel.getSomeData().getValue();
                Toast.makeText(getContext(), String.valueOf(listOfNotes), Toast.LENGTH_LONG).show();
            }
        });
    }
}
