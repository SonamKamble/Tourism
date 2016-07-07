package com.example.admin.tourism;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ADMIN on 26/06/2016.
 */
public class Login extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final DatabaseHelper helper=new DatabaseHelper(getActivity().getApplicationContext());
        View view = inflater.inflate(R.layout.log_in, container, false);
        Button bLogin = (Button) view.findViewById(R.id.bLogin);
        Button Bsignup = (Button) view.findViewById(R.id.Bsignup);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.bLogin) {
                    EditText a = (EditText) getView().findViewById(R.id.tv_username);
                    String str = a.getText().toString();
                    EditText b = (EditText) getView().findViewById(R.id.tv_password);
                    String pass = b.getText().toString();

                    String password=helper.searchPass(str);
                    if(pass.equals(password)){
                        Intent i = new Intent(getActivity(), Display.class);
                        i.putExtra("Username", str);
                        startActivity(i);
                    }
                    else{
                        Toast temp=Toast.makeText(getActivity(),"Username and Password don't match..!!",Toast.LENGTH_SHORT);
                        temp.show();
                    }

                }
            }
        });
        Bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.Bsignup) {
                    Intent i = new Intent(getActivity(), SignUp.class);
                    startActivity(i);
                }
            }
        });
        return view;
    }

}
