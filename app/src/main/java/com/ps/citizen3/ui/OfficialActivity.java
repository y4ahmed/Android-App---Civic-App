package com.ps.citizen3.ui;

/**
 * Created by yusuf on 12/1/2017.
 */

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.ps.citizen3.R;
import com.squareup.picasso.Picasso;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import java.io.FileInputStream;

public class OfficialActivity extends AppCompatActivity {

    private TextView tvinfoOffice;
    private TextView tvinfoName;
    private ImageView tvinfoPicture;
    DatabaseHelper mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official_info);
        String FILENAME = "RepsNow.db";
        try {
            FileInputStream fis = openFileInput(FILENAME);
            StringBuilder builder = new StringBuilder();
            int ch;
            while((ch = fis.read()) != -1){
                builder.append((char)ch);
            }
            fis.close();
        }catch(Exception e) {
            Log.e("StorageExample", e.getMessage());
        }

        Bundle b = getIntent().getExtras();

        tvinfoOffice = (TextView) findViewById(R.id.tvinfoOffice);
        tvinfoName = (TextView) findViewById(R.id.tvinfoName);
        tvinfoPicture = (ImageView) findViewById(R.id.tvinfoPicture);

        tvinfoOffice.setText(b.getString("office"));
        tvinfoName.setText(b.getString("name"));
        String photo = b.getString("photoURL");
        if (photo != null) {
            Picasso.with(this).load(photo).into(this.tvinfoPicture);
        }
    }
}
