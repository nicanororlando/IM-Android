package com.institutomisionero.IM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class PDF extends AppCompatActivity {

    PDFView mPDFView;
    Bundle dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        //Boton Atras
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Coritario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dato = getIntent().getExtras();
        int i = dato.getInt("id");

        mPDFView = findViewById(R.id.pdfView);

        if(i == 17 || i == 28 || i == 40 || i == 61 || i == 68 || i == 148) {
            if (i == 17) {
                mPDFView.fromAsset("coritario.nuevo.pdf")
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(false)
                        .pages(i, i + 1)
                        .enableAnnotationRendering(false)           //FALTA ACOMODAR ESPACIOSEFSFVDSA
                        .scrollHandle(null)
                        .enableAntialiasing(true)
                        .spacing(0)
                        .autoSpacing(true)
                        .pageFitPolicy(FitPolicy.WIDTH)             //FLASDADVWEKFVJWEFV NWRJTHBJ
                        .fitEachPage(false)
                        .nightMode(false)
                        .load();
            }
            else if (i == 28) {
                mPDFView.fromAsset("coritario.nuevo.pdf")
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(false)
                        .pages(i + 1, i + 2)
                        .enableAnnotationRendering(false)
                        .scrollHandle(null)
                        .enableAntialiasing(true)
                        .spacing(0)
                        .autoSpacing(true)
                        .pageFitPolicy(FitPolicy.WIDTH)
                        .fitEachPage(false)
                        .nightMode(false)
                        .load();
            }
            else if (i == 40){
                mPDFView.fromAsset("coritario.nuevo.pdf")
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(false)
                        .pages(i + 2, i + 3)
                        .enableAnnotationRendering(false)
                        .scrollHandle(null)
                        .enableAntialiasing(true)
                        .spacing(0)
                        .autoSpacing(true)
                        .pageFitPolicy(FitPolicy.WIDTH)
                        .fitEachPage(false)
                        .nightMode(false)
                        .load();
            }
            else if (i == 61){
                mPDFView.fromAsset("coritario.nuevo.pdf")
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(false)
                        .pages(i + 3, i + 4)
                        .enableAnnotationRendering(false)
                        .scrollHandle(null)
                        .enableAntialiasing(true)
                        .spacing(0)
                        .autoSpacing(true)
                        .pageFitPolicy(FitPolicy.WIDTH)
                        .fitEachPage(false)
                        .nightMode(false)
                        .load();
            }
            else if(i == 68){
                mPDFView.fromAsset("coritario.nuevo.pdf")
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(false)
                        .pages(i + 4, i + 5)
                        .enableAnnotationRendering(false)
                        .scrollHandle(null)
                        .enableAntialiasing(true)
                        .spacing(0)
                        .autoSpacing(true)
                        .pageFitPolicy(FitPolicy.WIDTH)
                        .fitEachPage(false)
                        .nightMode(false)
                        .load();
            }
            else {
                mPDFView.fromAsset("coritario.nuevo.pdf")
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(false)
                        .pages(i + 5, i + 6)
                        .enableAnnotationRendering(false)
                        .scrollHandle(null)
                        .enableAntialiasing(true)
                        .spacing(0)
                        .autoSpacing(true)
                        .pageFitPolicy(FitPolicy.WIDTH)
                        .fitEachPage(false)
                        .nightMode(false)
                        .load();
            }
        }
        else if(i >= 18 && i <= 27) {
            mPDFView.fromAsset("coritario.nuevo.pdf")
                    .enableSwipe(false)
                    .swipeHorizontal(true)
                    .enableDoubletap(true)
                    .pages(i+1)
                    .enableAnnotationRendering(false)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .autoSpacing(true)
                    .pageFitPolicy(FitPolicy.BOTH)
                    .fitEachPage(false)
                    .pageSnap(true)
                    .pageFling(true)
                    .nightMode(false)
                    .load();
        }
        else if(i >= 29 && i <= 39){
            mPDFView.fromAsset("coritario.nuevo.pdf")
                    .enableSwipe(false)
                    .swipeHorizontal(true)
                    .enableDoubletap(true)
                    .pages(i+2)
                    .enableAnnotationRendering(false)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .autoSpacing(true)
                    .pageFitPolicy(FitPolicy.BOTH)
                    .fitEachPage(false)
                    .pageSnap(true)
                    .pageFling(true)
                    .nightMode(false)
                    .load();
        }
        else if(i >= 41 && i <= 60) {
            mPDFView.fromAsset("coritario.nuevo.pdf")
                    .enableSwipe(false)
                    .swipeHorizontal(true)
                    .enableDoubletap(true)
                    .pages(i+3)
                    .enableAnnotationRendering(false)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .autoSpacing(true)
                    .pageFitPolicy(FitPolicy.BOTH)
                    .fitEachPage(false)
                    .pageSnap(true)
                    .pageFling(true)
                    .nightMode(false)
                    .load();
        }
        else if(i >= 62 && i <= 67) {
            mPDFView.fromAsset("coritario.nuevo.pdf")
                    .enableSwipe(false)
                    .swipeHorizontal(true)
                    .enableDoubletap(true)
                    .pages(i+4)
                    .enableAnnotationRendering(false)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .autoSpacing(true)
                    .pageFitPolicy(FitPolicy.BOTH)
                    .fitEachPage(false)
                    .pageSnap(true)
                    .pageFling(true)
                    .nightMode(false)
                    .load();
        }
        else if(i >= 69 && i <= 148) {
            mPDFView.fromAsset("coritario.nuevo.pdf")
                    .enableSwipe(false)
                    .swipeHorizontal(true)
                    .enableDoubletap(true)
                    .pages(i+5)
                    .enableAnnotationRendering(false)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .autoSpacing(true)
                    .pageFitPolicy(FitPolicy.BOTH)
                    .fitEachPage(false)
                    .pageSnap(true)
                    .pageFling(true)
                    .nightMode(false)
                    .load();
        }
        else if (i >= 149){
            mPDFView.fromAsset("coritario.nuevo.pdf")
                    .enableSwipe(false)
                    .swipeHorizontal(true)
                    .enableDoubletap(true)
                    .pages(i+6)
                    .enableAnnotationRendering(false)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .autoSpacing(true)
                    .pageFitPolicy(FitPolicy.BOTH)
                    .fitEachPage(false)
                    .pageSnap(true)
                    .pageFling(true)
                    .nightMode(false)
                    .load();
        }
        else{
            mPDFView.fromAsset("coritario.nuevo.pdf")
                    .enableSwipe(false)
                    .swipeHorizontal(true)
                    .enableDoubletap(true)
                    .pages(i)
                    .enableAnnotationRendering(false)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .autoSpacing(true)
                    .pageFitPolicy(FitPolicy.BOTH)
                    .fitEachPage(false)
                    .pageSnap(true)
                    .pageFling(true)
                    .nightMode(false)
                    .load();
        }
    }
}

