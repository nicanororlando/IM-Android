package com.institutomisionero.IM.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.institutomisionero.IM.ImagenCompleta;
import com.institutomisionero.IM.R;

public class GalleryFragment extends Fragment {

    GridView gridView;
    AdaptadorGaleria adaptadorGaleria;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        gridView =  view.findViewById(R.id.gv_imagenes);

        adaptadorGaleria = new AdaptadorGaleria(getActivity().getApplicationContext());
        gridView.setAdapter(adaptadorGaleria);

        //Imagen Completa
        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent = new Intent(getActivity().getApplicationContext(), ImagenCompleta.class);
            intent.putExtra("misImagenes", position);
            startActivity(intent);
        });

        return view;
    }

}