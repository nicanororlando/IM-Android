package com.institutomisionero.IM.ui.secundario;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.institutomisionero.IM.R;

public class DonacionesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_donaciones, container, false);

        TextView text =  (TextView) view.findViewById(R.id.linkpago);
        text.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}