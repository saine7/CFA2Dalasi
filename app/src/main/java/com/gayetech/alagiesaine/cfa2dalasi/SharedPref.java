package com.gayetech.alagiesaine.cfa2dalasi;


import android.content.Context;
import android.content.SharedPreferences;

//class to set rate of CFA
public class SharedPref{
    static String RATE = "";
    static String SHARED_PREF = "shared_pref";
    static Context ctx;

    public SharedPref(Context context){
        ctx = context;
    }

    public boolean setRate(int rate){
        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(RATE,rate);
        editor.commit();
        return true;
    }

    public int getRate(){
        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE);
            return preferences.getInt(RATE,0);
    }
}

