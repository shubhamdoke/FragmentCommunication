package com.example.fragmentcommunication.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmentcommunication.MainActivity;
import com.example.fragmentcommunication.R;


public class Fragment_1 extends Fragment {


    EditText et1;
    Button bt1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_1, container, false);
         et1 = v.findViewById(R.id.et1);
         bt1=v.findViewById(R.id.bt1);

        bt1.setOnClickListener(v1 -> {
            String a= et1.getText().toString();
            Bundle bundle=new Bundle();
            bundle.putString("a",a);
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

        });

        return v;
    }

}