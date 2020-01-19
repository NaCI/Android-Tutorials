package com.naci.daggerditutorial.ui.base;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    private final String TAG = getClass().getSimpleName();

    @LayoutRes
    protected abstract int getLayoutResID();

    private ProgressDialog progressDialog;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.wtf("Fragment Created", String.format("Class Name : %s", TAG));

    }

    @Override
    public void onDestroy() {
        Log.wtf("Fragment Destroyed", String.format("Class Name : %s", TAG));
        super.onDestroy();
    }

    /*@Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutResID(), container, false);
        if (viewDataBinding == null) {
            View rootView = inflater.inflate(getLayoutResID(), container, false);
            if (shouldUseButterKnife()) {
                unbinder = ButterKnife.bind(this, rootView);
            }
            return rootView;
        }
        viewDataBinding.setLifecycleOwner(this);
        return viewDataBinding.getRoot();
    }*/


    public void hideKeyboard() {
        View view = this.getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    public void showProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /*
    public void sendFirebaseLogEvent(String screenName){
        try {
            ((BaseActivity)getActivity()).sendScreenTracking(screenName);
        } catch (NullPointerException e){
            Log.e(TAG, "sendFirebaseLogEvent():NullPointerException");
        } catch(Exception e) {
            Log.e(TAG, "sendFirebaseLogEvent()");
        }
    }
    */

    /*@Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
    }*/
}
