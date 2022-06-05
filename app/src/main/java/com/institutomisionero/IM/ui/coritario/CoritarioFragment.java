/*
 * Created by Nicanor Orlando. 
 * Copyright (c) 7/12/21 09:33. 
 * All rights reserved. 
 */

package com.institutomisionero.IM.ui.coritario;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import com.institutomisionero.IM.PDF;
import com.institutomisionero.IM.R;

import java.util.ArrayList;

public class CoritarioFragment extends Fragment {

    ListView dataList;
    ArrayList<SongModel> List = new ArrayList<SongModel>();

    Songs songs;
    CoritarioAdapter coritarioAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.coritario_fragment, container, false);

        dataList = view.findViewById(R.id.lstDatos);

        // LISTA DE CANCIONES
        songs = new Songs(List);
        songs.setLista();

        // ADAPTADOR
        coritarioAdapter = new CoritarioAdapter(getActivity().getApplicationContext(), List);
        dataList.setAdapter(coritarioAdapter);

        // PDF
        dataList.setOnItemClickListener((parent, view1, position, id) -> {

            int pos = List.indexOf(coritarioAdapter.getItem(position));

            Intent paso = new Intent(getActivity().getApplicationContext(), PDF.class);
            paso.putExtra("id", pos);
            startActivity(paso);
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // Agregar items al action bar
        inflater.inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem((R.id.search_view));
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                coritarioAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.search_view){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
