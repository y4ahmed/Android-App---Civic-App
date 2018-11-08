package com.ps.citizen3.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ps.citizen3.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import timber.log.Timber;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MainActivity extends ActionBarActivity implements DrawerRecyclerView.NavigationDrawerCallbacks {
    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @InjectView(R.id.drawer_recyclerView) DrawerRecyclerView drawerRecyclerView;
    public static final String PREFS_NAME = "RepsNowPrefsFile";
    public static String loadedAddress;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.d("onCreate");
        ButterKnife.inject(this);
        SharedPreferences spAddress = getSharedPreferences(PREFS_NAME, 0);
        if (spAddress.getString("address", "") != "") {
            loadedAddress = spAddress.getString("address", "");
        } else {
            int PLACE_PICKER_REQUEST = 1;
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            try {
                startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            }
        }
        // Set toolbar as actionbar
        toolbar.setBackgroundColor(Color.parseColor("#455A64"));
        setSupportActionBar(toolbar);

        // Set status bar color - Lollipop exclusive
        drawerLayout.setStatusBarBackgroundColor(Color.parseColor("#263238"));

        // Add action bar toggle
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        // Setup drawer RecyclerView
        drawerRecyclerView.setUp(this, drawerLayout);

        // Set starting fragment
        switchFragment(RepFragment.newInstance());
    }

    public void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int PLACE_PICKER_REQUEST = 1;
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place selectedPlace = PlacePicker.getPlace(this, data);
                String resultAddress = (String)selectedPlace.getAddress();

                // Above works

                //place into shared preferences
                SharedPreferences spAddress = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = spAddress.edit();
                editor.putString("address", resultAddress);
                editor.commit();
                //now restart MainActivity
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        }
    }
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        if (position == 1) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if (position == 3) {
            int PLACE_PICKER_REQUEST = 1;
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            try {
                startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            }
        }
        else if (position == 2) {
            Intent intent = new Intent(this, Elections.class);
            startActivity(intent);
        }
    }
}
