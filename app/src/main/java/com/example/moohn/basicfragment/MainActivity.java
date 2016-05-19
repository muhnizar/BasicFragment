package com.example.moohn.basicfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "MainActivity onCreate()", Toast.LENGTH_SHORT);
        setContentView(R.layout.fragment_layout);
    }
}
