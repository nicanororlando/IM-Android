/*
 * Created by Nicanor Orlando.
 * Copyright (c) 7/12/21 09:33.
 * All rights reserved.
 */

package com.institutomisionero.IM;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends loginActivity {

    private static final String MY_PREFERENCES = "my_preferences";

    public static boolean isFirst(Context context){
        final SharedPreferences reader = context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        final boolean first = reader.getBoolean("is_first", true);

        if(first) {
            final SharedPreferences.Editor editor = reader.edit();
            editor.putBoolean("is_first", false);
            editor.apply();
        }
        return first;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isFirstTime = MainActivity.isFirst(MainActivity.this);

        if(isFirstTime) {
            Intent intent = new Intent(MainActivity.this, loginActivity.class);
            startActivity(intent);
            MainActivity.this.finish();
        }
        else {
            TimerTask tarea = new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, MenuSlideActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
            };

            Timer tiempo = new Timer();
            tiempo.schedule(tarea, 1000);
        }
    }
}
