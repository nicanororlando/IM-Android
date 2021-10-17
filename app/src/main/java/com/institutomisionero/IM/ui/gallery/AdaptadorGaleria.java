 package com.institutomisionero.IM.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.institutomisionero.IM.R;

public class AdaptadorGaleria extends BaseAdapter {

    Context mContext;
    public int[] imageArray ={
            R.drawable._uno,
            R.drawable._dos,
            R.drawable._tres,
            R.drawable._cuatro,
            R.drawable._cinco,
            R.drawable._seis,
            R.drawable._siete,
            R.drawable._ocho,
            R.drawable._nueve,
            R.drawable._diez,
            R.drawable._once,
            R.drawable._doce,
            R.drawable._trece,
            R.drawable._catorce,
            R.drawable._quince
    };

    public int[] imageGrandeArray ={
            R.drawable.uno,
            R.drawable.dos,
            R.drawable.tres,
            R.drawable.cuatro,
            R.drawable.cinco,
            R.drawable.seis,
            R.drawable.siete,
            R.drawable.ocho,
            R.drawable.nueve,
            R.drawable.diez,
            R.drawable.once,
            R.drawable.doce,
            R.drawable.trece,
            R.drawable.catorce,
            R.drawable.quince
    };

    public AdaptadorGaleria(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(350, 350));

    return imageView;
    }
}

