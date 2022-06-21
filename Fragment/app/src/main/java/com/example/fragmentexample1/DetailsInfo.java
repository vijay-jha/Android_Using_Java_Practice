package com.example.fragmentexample1;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class DetailsInfo extends Fragment {

    TextView name, location;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_info, container, false);
        name = view.findViewById(R.id.name);
        location = view.findViewById(R.id.location);
        return view;
    }

    public void change(String uname, String ulocation) {
        name.setText(uname);
        location.setText(ulocation);
    }
}
