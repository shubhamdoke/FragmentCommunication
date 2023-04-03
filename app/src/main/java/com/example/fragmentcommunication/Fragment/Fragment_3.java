package com.example.fragmentcommunication.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentcommunication.MainActivity;
import com.example.fragmentcommunication.R;


public class Fragment_3 extends Fragment {

    EditText et3;
    Button bt3;
    String preval,val;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_3, container, false);
        et3 = view.findViewById(R.id.et3);
        bt3 =view.findViewById(R.id.bt3);

        Bundle b=this.getArguments();
        preval=b.getString("previous-value");
        bt3.setOnClickListener(v1 -> {
            val= et3.getText().toString();
            Bundle bundle=new Bundle();
            int balance1= Integer.parseInt(preval)+Integer.parseInt(val);
            String value=String.valueOf(balance1);
            bundle.putString("a",value);
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

        });

        return  view;
    }
}