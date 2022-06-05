/*
 * Created by Nicanor Orlando.
 * Copyright (c) 5/30/22, 12:54 PM.
 * All rights reserved.
 */

package com.institutomisionero.IM.ui.gallery;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Gallery extends AppCompatActivity {
    //private final String data = "http://localhost:5000/data/";
    private final String data = "https://nubecolectiva.com/blog/tutos/demos/leer_json_android_java/datos/postres.json";
    private final int codigodatos = 1;

    List<GalleryModel> listJSON;

    public Gallery(ArrayList<GalleryModel> listJSON){
        this.listJSON = listJSON;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Llamo al método para leer el archivo JSON.
        leerJSON();
    }

    @SuppressLint("StaticFieldLeak")
    public void leerJSON(){

        // Inicio una tare Asíncrona
        new AsyncTask<Void, Void, String>(){

            // La tarea se llevará acabo de fondo
            protected String doInBackground(Void[] params) {

                String response = "";

                // Declaro un HashMap
                HashMap<String, String> map = new HashMap<>();

                // Hago la petición de los datos
                try {
                    HttpRequest req = new HttpRequest(data);
                    response = req.prepare(HttpRequest.Method.POST).reciboDatos(map).enviaryRecibirString();
                } catch (Exception e) {
                    response = e.getMessage();
                }
                return response;
            }

            // Después de realizar la petición de los datos, llamo al método tareaCompletada()
            // El método tareaCompletada() lo crearé a continuación
            protected void onPostExecute(String resultado) {
                tareaCompletada(resultado, codigodatos);
            }

        }.execute();
    }

    public void tareaCompletada(String response, int serviceCode) {
        // Uso un case y le paso la variable 'codigodatos'
        if (serviceCode == codigodatos) {

            // Verifico si los datos se recibieron.
            if (siCorrecto(response)) {

                // A mi modelo le paso el método obtenerInformacion().
                obtenerInformacion(response);
                Log.d("list", listJSON.toString());
            } else {
                // Si hubo error, lo muestro en un Toast
                Toast.makeText(Gallery.this, obtenerCodigoError(response), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void obtenerInformacion(String response) {

        // Solicito los datos al archivo JSON
        try {
            JSONObject jsonObject = new JSONObject(response);

            // En los datos que recibo verifico si obtengo el estado o 'status' con el valor 'true'
            // El dato 'status' con el valor 'true' se encuentra dentro del archivo JSON
            if (jsonObject.getString("status").equals("true")) {

                // Accedo a la fila 'gallery' del archivo JSON
                JSONArray dataArray = jsonObject.getJSONArray("postres");

                // Recorro los datos que hay en la fila 'gallery' del archivo JSON
                for (int i = 0; i < dataArray.length(); i++) {

                    // Creo la variable 'datosModelo' y le paso mi modelo 'MyAppModel'
                    GalleryModel dataModel = new GalleryModel();

                    // Creo la  variable 'objetos' y recupero los valores
                    JSONObject objetos = dataArray.getJSONObject(i);

                    // Selecciono dato por dato
                    dataModel.setId(objetos.getInt("id"));
                    dataModel.setTitle(objetos.getString("stock"));
                    dataModel.setUrl(objetos.getString("url"));
                    dataModel.setImage(objetos.getString("img"));
                    dataModel.setDescription(objetos.getString("nombre"));

                    // Meto los datos en el array que definí más arriba 'listaArray'
                    listJSON.add(dataModel);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean siCorrecto(String response) {

        // Verificamos si la petición de los datos ha sido correcta
        try {

            // Creo la variable 'objetoJson' de tipo JSONObjetc (Objeto JSON) y le
            // paso los datos que he recibido (response)
            JSONObject objetoJson = new JSONObject(response);

            // En los datos que he recibido verifico si obtengo el estado o 'status' con el valor 'true'
            // El dato 'status' con el valor 'true' se encuentra dentro del archivo JSON
            // Retorno 'true' si es correcto y 'false' si es incorrecto
            return objetoJson.optString("status").equals("true");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Si nada se lleva acabo retorno 'false'
        return false;
    }

    public String obtenerCodigoError(String response) {

        // Solicitamos el código de error que se encuentra en el archivo JSON
        try {
            // El archivo JSON contiene el dato 'message'
            JSONObject jsonObject = new JSONObject(response);

            return jsonObject.getString("message");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Si no hay datos en el archiv JSON, muestro un mensaje
        return "No hay datos";
    }
}