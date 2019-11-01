package com.github.ecorpbro.mymoney.activites;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.ecorpbro.mymoney.R;

public class ContentFragment extends Fragment {
    public static final String TAG = "ContentFragment";

    private TextView txtContent;

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        txtContent = (TextView) view.findViewById(R.id.txt_content);
        txtContent.setText(String.valueOf(getArguments().getInt(MainActivity.TEST_CONTENT)));

        return view;
    }
}
