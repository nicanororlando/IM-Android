package com.institutomisionero.IM.ui.secundario;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.institutomisionero.IM.R;

public class AcercaDeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_acerca_de, container, false);

        TextView gmailMio =  (TextView) view.findViewById(R.id.correo);
        gmailMio.setMovementMethod(LinkMovementMethod.getInstance());

        TextView emailIm =  (TextView) view.findViewById(R.id.linkim);
        emailIm.setMovementMethod(LinkMovementMethod.getInstance());

        Button calificarApp = (Button) view.findViewById(R.id.button);
        calificarApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent((Intent.ACTION_VIEW), Uri.parse("market://details?id=" + getContext().getPackageName() )));
                }
                catch (ActivityNotFoundException e){
                    startActivity(new Intent((Intent.ACTION_VIEW), Uri.parse("http://play.google.com/store/apps/details?id=" + getContext().getPackageName() )));
                }
            }
        });

        return view;
    }
}