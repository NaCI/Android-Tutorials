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

import com.commit451.modalbottomsheetdialogfragment.ModalBottomSheetDialogFragment;
import com.commit451.modalbottomsheetdialogfragment.Option;
import com.commit451.modalbottomsheetdialogfragment.OptionRequest;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.naci.daggerditutorial.MyApplication;
import com.naci.daggerditutorial.R;
import com.naci.daggerditutorial.data.remote.model.NumberData;
import com.naci.daggerditutorial.ui.ViewModelFactory;
import com.naci.daggerditutorial.ui.base.BaseFragment;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.inject.Named;

public class MainFragment extends BaseFragment implements ModalBottomSheetDialogFragment.Listener{

    private static final String TAG = MainFragment.class.getSimpleName();

    @Inject
    ViewModelFactory viewModelFactory;

    @Inject
    @Named("FirstModule")
    String firstModuleString;

    private MainViewModel mainViewModel;
    private Button button, buttonShowBottomSheet;
    ModalBottomSheetDialogFragment.Builder modalBottomSheetDialogFragmentBuilder;


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
        buttonShowBottomSheet = view.findViewById(R.id.button2);
        prepareBottomSheet();
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
        buttonShowBottomSheet.setOnClickListener(viewButton -> openBottomSheet());
    }

    private void prepareBottomSheet() {
        modalBottomSheetDialogFragmentBuilder =  new ModalBottomSheetDialogFragment.Builder()
                //custom option, without needing menu XML
//                .add(new OptionRequest(1, "Custom", android.R.drawable.btn_plus))
                .add(new OptionRequest(2, "Custom2", android.R.drawable.btn_minus))
                .add(new OptionRequest(3, "Custom3", null))
                .add(new OptionRequest(4, "Custom4", android.R.drawable.star_off))
                .layout(R.layout.item_custom)
//                .header("Neat", R.layout.item_custom)
                .columns(1);
    }

    private void openBottomSheet() {
        modalBottomSheetDialogFragmentBuilder.show(getChildFragmentManager(), "testBottomSheet");
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

    @Override
    public void onModalOptionSelected(@Nullable String tag, @NotNull Option option) {
        Snackbar.make(getView(), String.format("Selected option %s from fragment with tag %s", option.getTitle(), tag), BaseTransientBottomBar.LENGTH_LONG).show();
    }
}
