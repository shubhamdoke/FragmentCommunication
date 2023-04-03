package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentcommunication.Fragment.Fragment_1;
import com.example.fragmentcommunication.Fragment.Fragment_2;
import com.example.fragmentcommunication.Fragment.Fragment_3;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3;
    String value;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        textView = findViewById(R.id.tv);


        btn1.setOnClickListener(v -> {
            Fragment_1 frag1=new Fragment_1();
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ll, frag1);
            transaction.commit();

        });
        btn2.setOnClickListener(v -> {
            Fragment_2 frag2=new Fragment_2();
            SendValueToFragment(frag2);
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ll,frag2);
            transaction.commit();

        });
        btn3.setOnClickListener(v -> {
            Fragment_3 frag3=new Fragment_3();
            SendValueToFragment(frag3);
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ll,frag3);
            transaction.commit();

        });

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            value = bundle.getString("a");
            textView.setText(value);
        }
               // Toast.makeText(this, ""+a1, Toast.LENGTH_SHORT).show();
    }

    private void SendValueToFragment(Fragment frag) {
        Bundle bundle = new Bundle();
        bundle.putString("previous-value",value);
        frag.setArguments(bundle);
    }

}