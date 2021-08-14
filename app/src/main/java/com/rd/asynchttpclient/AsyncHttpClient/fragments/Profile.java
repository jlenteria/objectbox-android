package com.rd.asynchttpclient.AsyncHttpClient.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.rd.asynchttpclient.AsyncHttpClient.model.SampleModel;
import com.rd.asynchttpclient.MainActivity;
import com.rd.asynchttpclient.R;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.firstName)
    EditText firstName;
    @BindView(R.id.lastName)
    EditText lastName;
    @BindView(R.id.status)
    EditText status;
    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.backBtn)
    Button backButton;

    public SampleModel mSampleModel;

    public static Profile newInstance(SampleModel sampleModel) {
        Profile fragment = new Profile();
        Bundle args = new Bundle();
        String data = new Gson().toJson(sampleModel);
        args.putString("DATA", data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialView();
    }

    private void initialView(){
        String data = getArguments().getString("DATA");
        mSampleModel = new Gson().fromJson(data, SampleModel.class);
        username.setText(mSampleModel.getUsername());
        firstName.setText(mSampleModel.getFirstName());
        lastName.setText(mSampleModel.getLastName());
        status.setText(mSampleModel.getStatus());
        password.setText(mSampleModel.getPassword());
        backButton.setOnClickListener(v -> {
            LoginFragment loginFragment = LoginFragment.newInstance();
            getParentFragmentManager().beginTransaction().replace(R.id.content_view, loginFragment).commit();
        });
    }
}