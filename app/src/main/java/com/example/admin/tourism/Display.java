package com.example.admin.tourism;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ADMIN on 26/06/2016.
 */
public class Display extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username=getIntent().getStringExtra("Username");
        TextView tv=(TextView)findViewById(R.id.tv_display_username);
        tv.setText(username);
    }
}
