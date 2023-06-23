package com.example.myrlgarage.models;

import com.google.firebase.Timestamp;

import java.text.SimpleDateFormat;

public class TimestampUtility {

    public static String timestampToString(Timestamp timestamp){
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(timestamp.toDate());
    }
}
