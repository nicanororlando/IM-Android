/*
 * Created by Nicanor Orlando.
 * Copyright (c) 7/12/21 09:33.
 * All rights reserved.
 */

package com.institutomisionero.IM.ui.secundario;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.institutomisionero.IM.R;

public class FacebookFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.facebook_fragment, container, false);

        Uri uri = Uri.parse("https://www.facebook.com/IM.FCS.UAP");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.facebook.android");

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            //No encontró la aplicación, abre la versión web.
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }

        getActivity().onBackPressed();
        return view;
    }
}