package com.rd.asynchttpclient.AsyncHttpClient.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rd.asynchttpclient.AsyncHttpClient.model.SampleModel;
import com.rd.asynchttpclient.AsyncHttpClient.model.SampleModel_;
import com.rd.asynchttpclient.MainActivity;
import com.rd.asynchttpclient.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView; // import butterknife to graddle for binding the view of fragment
import butterknife.ButterKnife;


public class LoginFragment extends Fragment {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.loginBtn)
    Button loginBtn;

    @BindView(R.id.signUp)
    TextView signUp;

    List <SampleModel> sampleModelList = new ArrayList();
    SampleModel sampleModel = null;

    public static LoginFragment newInstance(){
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private MainActivity getParent(){return ((MainActivity) getActivity());}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView( LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signin, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents();
    }
    private void initComponents(){
        loginBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            if(TextUtils.isEmpty(username.getText().toString().trim()) && TextUtils.isEmpty(password.getText().toString().trim())){
                Toast.makeText(getContext(), "Please provide data!", Toast.LENGTH_LONG).show();
                return;
            }
            sampleModelList = getParent().getSampleInfo().query().equal(SampleModel_.username, username.getText().toString().trim().toLowerCase()).equal(SampleModel_.password, password.getText().toString().trim()).build().find();
            if(sampleModelList.size() > 0) {

                for(SampleModel item : sampleModelList){
                    sampleModel = new SampleModel();
                    sampleModel = item;
                }
                builder.setTitle("Success");
                builder.setMessage("Data Found!");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", (dialog, which) -> {
                   Profile profileFragment = Profile.newInstance(sampleModel);
                   getFragmentManager().beginTransaction().replace(R.id.content_view, profileFragment).commit();
                });
            }
            else{
                builder.setTitle("Error");
                builder.setMessage("No data found in Object Box Store");
                builder.setPositiveButton("OK", null);
            }
            builder.show();
        });

        signUp.setOnClickListener(v -> {
            RegisterFragment registerFragment  = RegisterFragment.newInstance();
          getFragmentManager().beginTransaction().replace(R.id.content_view, registerFragment).commit();
        });
    }
}
