package com.ps.citizen3.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ps.citizen3.R;

/**
 * Created by yusuf on 12/1/2017.
 */

public class Elections extends AppCompatActivity{
    private TextView title, election1,election2,election3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elections);
        title = (TextView) findViewById(R.id.textView2);
        election1 = (TextView) findViewById(R.id.textView3);
        election2 = (TextView) findViewById(R.id.textView4);
        election3 = (TextView) findViewById(R.id.textView5);
        title.setText("RepsNow");
        election1.setText("VIP Test Election");
        election2.setText("Special Senate Election in Alabama");
        election3.setText("Special Election in California, Assembly District 51");
    }

}
