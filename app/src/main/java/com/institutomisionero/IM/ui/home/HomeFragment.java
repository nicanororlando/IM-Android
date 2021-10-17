package com.institutomisionero.IM.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.institutomisionero.IM.R;
import com.institutomisionero.IM.ui.coritario.CoritarioFragment;
import com.institutomisionero.IM.ui.gallery.GalleryFragment;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //***************************************************************************************************************************************************************

        //BOTONES
        Button galeria = view.findViewById(R.id.gallerybutton);
        Button coritario = view.findViewById(R.id.coritariobutton);

        galeria.setOnClickListener(v -> {
            // Crea el nuevo fragmento y la transacción.
            Fragment nuevoFragmento = new GalleryFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment_content_menu_slide, nuevoFragmento);
            transaction.addToBackStack(null);

            // Commit a la transacción
            transaction.commit();
        });

        coritario.setOnClickListener(v -> {
            // Crea el nuevo fragmento y la transacción.
            Fragment nuevoFragmento = new CoritarioFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment_content_menu_slide, nuevoFragmento);
            transaction.addToBackStack(null);

            // Commit a la transacción
            transaction.commit();
        });

        return view;
    }
}