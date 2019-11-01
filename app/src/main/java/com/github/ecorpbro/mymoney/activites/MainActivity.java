package com.github.ecorpbro.mymoney.activites;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

import com.github.ecorpbro.mymoney.R;
import com.github.ecorpbro.mymoney.gui.MenuExpandableList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    public static final String TEST_CONTENT = "TEST_CONTENT";

    private static MenuExpandableList sMenuExpandableList;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (sMenuExpandableList == null) {
            sMenuExpandableList = new MenuExpandableList(this);
            Log.d(TAG, "onCreate " + sMenuExpandableList);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }
}
