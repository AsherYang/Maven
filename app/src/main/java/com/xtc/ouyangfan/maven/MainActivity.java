package com.xtc.ouyangfan.maven;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.xtc.ouyangfan.utillibrary.UserUtil;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, UserUtil.getUserName(), Toast.LENGTH_SHORT).show();
    }
}
