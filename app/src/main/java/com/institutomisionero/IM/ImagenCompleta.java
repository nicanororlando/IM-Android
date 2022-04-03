/*
 * Created by Nicanor Orlando.
 * Copyright (c) 7/12/21 09:33.
 * All rights reserved.
 */

package com.institutomisionero.IM;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.institutomisionero.IM.ui.gallery.AdaptadorGaleria;

public class ImagenCompleta extends AppCompatActivity {

    ImageView imageView;
    AdaptadorGaleria adaptadorGaleria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_completa);

        imageView = findViewById(R.id.iv_foto);

        //Boton Atras
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Galeria");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle intent = getIntent().getExtras();
        int posicion = intent.getInt("misImagenes");

        adaptadorGaleria = new AdaptadorGaleria(this);
        imageView.setImageResource(adaptadorGaleria.imageGrandeArray[posicion]);
    }
}