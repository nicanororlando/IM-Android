/*
 * Created by Nicanor Orlando. 
 * Copyright (c) 7/12/21 09:33. 
 * All rights reserved. 
 */

package com.institutomisionero.IM.ui.coritario;

public class Datos{

    private int posicion;
    private String cancion;

    public Datos(int i, String cancion) {
        this.posicion = i;
        this.cancion = cancion;
    }

    public int getId() { return this.posicion; }

    public Object getTitulo() {
        return this.cancion;
    }
}
