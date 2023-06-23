package com.example.myrlgarage.models;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CollectionUtility {

    public static CollectionReference getCollectionReferenceForPreset(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("presets").document(currentUser.getUid())
                .collection("my_presets");
    }
}
