package com.institutomisionero.IM.ui.secundario;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.institutomisionero.IM.R;

public class InstagramFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_instagram, container, false);

        Uri uri = Uri.parse("http://instagram.com/_u/instituto.misionero");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.instagram.android");

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