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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.rd.asynchttpclient.AsyncHttpClient.BaseActivity;
import com.rd.asynchttpclient.AsyncHttpClient.model.SampleModel;
import com.rd.asynchttpclient.AsyncHttpClient.model.SampleModel_;
import com.rd.asynchttpclient.MainActivity;
import com.rd.asynchttpclient.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterFragment extends Fragment {
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
    @BindView(R.id.logIn)
    TextView logIn;

    @BindView(R.id.registerBtn)
    Button registerBtn;


    List<SampleModel> list = new ArrayList<>();

    public static RegisterFragment newInstance(){
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private MainActivity getParent(){return ((MainActivity)getActivity());}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }
    public void initView(){
        logIn.setOnClickListener(v -> {
            LoginFragment loginFragment = LoginFragment.newInstance();
            getFragmentManager().beginTransaction().replace(R.id.content_view, loginFragment).commit();
        });

        registerBtn.setOnClickListener(v -> {
             AlertDialog.Builder builder  = new AlertDialog.Builder(getContext());
            if(TextUtils.isEmpty(username.getText().toString().trim()) || TextUtils.isEmpty(firstName.getText().toString().trim()) || TextUtils.isEmpty(lastName.getText().toString().trim()) || TextUtils.isEmpty(password.getText().toString().trim())){
                builder.setTitle("ERROR");
                builder.setMessage("Please fill up all fields!");
            }else{
                list = getParent().getSampleInfo().query().equal(SampleModel_.username, username.getText().toString().toLowerCase()).build().find();
                if(list.size() > 0){
                    builder.setTitle("Ooops");
                    builder.setMessage("Username is already taken, please try another username!");
                    builder.setPositiveButton("Ok", null);

                }else{
                    SampleModel sampleModel = new SampleModel();
                    sampleModel.setUsername(username.getText().toString().trim().toLowerCase());
                    sampleModel.setFirstName(firstName.getText().toString().trim());
                    sampleModel.setLastName(lastName.getText().toString().trim());
                    sampleModel.setStatus(status.getText().toString().trim());
                    sampleModel.setPassword(password.getText().toString().trim());
                    getParent().getSampleInfo().put(sampleModel);
                    builder.setTitle("Success");
                    builder.setMessage("Successfully Registered!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", ((dialog, which) -> {
                        LoginFragment loginFragment = LoginFragment.newInstance();
                        getFragmentManager().beginTransaction().replace(R.id.content_view, loginFragment).commit();
                    }));
                }
            }
            builder.show();
        });
    }
}
