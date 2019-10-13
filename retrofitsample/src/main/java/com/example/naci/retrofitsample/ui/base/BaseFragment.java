package com.example.naci.retrofitsample.ui.base;


import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    private final String TAG = getClass().getName();

    @LayoutRes
    protected abstract int getLayoutResID();

    protected abstract boolean shouldUseButterKnife();

    private ProgressDialog progressDialog;
    protected T viewDataBinding;
    private Unbinder unbinder;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
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
    }


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

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
    }
}
