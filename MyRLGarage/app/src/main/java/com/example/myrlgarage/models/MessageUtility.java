package com.example.myrlgarage.models;

import android.content.Context;
import android.widget.Toast;

public class MessageUtility {
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
