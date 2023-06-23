package com.example.myrlgarage.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myrlgarage.R;
import com.example.myrlgarage.databinding.ActivityLoginBinding;
import com.example.myrlgarage.databinding.ActivityPresetDetailsBinding;
import com.example.myrlgarage.models.CollectionUtility;
import com.example.myrlgarage.models.MessageUtility;
import com.example.myrlgarage.models.Preset;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class PresetDetailsActivity extends AppCompatActivity {
    String presetName, team, body, decal, primaryColorPaintFinish,
            accentColorPaintFinish, wheels, rocketBoost, trail, docId;
    ActivityPresetDetailsBinding binding;
    boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPresetDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //primanje podataka
        presetName = getIntent().getStringExtra("presetName");
        team = getIntent().getStringExtra("team");
        body = getIntent().getStringExtra("body");
        decal = getIntent().getStringExtra("decal");
        primaryColorPaintFinish = getIntent().getStringExtra("primaryColorPaintFinish");
        accentColorPaintFinish = getIntent().getStringExtra("accentColorPaintFinish");
        wheels = getIntent().getStringExtra("wheels");
        rocketBoost = getIntent().getStringExtra("rocketBoost");
        trail = getIntent().getStringExtra("trail");
        docId = getIntent().getStringExtra("docId");

        if(docId != null && !docId.isEmpty()){
            isEditMode = true;
        }

        binding.presetNameEditText.setText(presetName);
        binding.teamEditText.setText(team);
        binding.bodyEditText.setText(body);
        binding.decalEditText.setText(decal);
        binding.primaryColorEditText.setText(primaryColorPaintFinish);
        binding.accentColorEditText.setText(accentColorPaintFinish);
        binding.wheelsEditText.setText(wheels);
        binding.rocketBoostEditText.setText(rocketBoost);
        binding.trailEditText.setText(trail);
        if(isEditMode){
            binding.pageTitleTextView.setText("Edit Preset");
            binding.deletePresetBtn.setVisibility(View.VISIBLE);
        }

        binding.savePresetBtn.setOnClickListener(v -> savePreset());

        binding.deletePresetBtn.setOnClickListener(v -> deletePresetFromFirebase());
    }

    void savePreset(){
        String presetName = binding.presetNameEditText.getText().toString();
        String team = binding.teamEditText.getText().toString();
        String body = binding.bodyEditText.getText().toString();
        String decal = binding.decalEditText.getText().toString();
        String primaryColor = binding.primaryColorEditText.getText().toString();
        String accentColor = binding.accentColorEditText.getText().toString();
        String wheels = binding.wheelsEditText.getText().toString();
        String rocketBoost = binding.rocketBoostEditText.getText().toString();
        String trail = binding.trailEditText.getText().toString();

        if(presetName==null || presetName.isEmpty()){
            binding.presetNameEditText.setError("Preset name is required");
            return;
        }

        Preset preset = new Preset();
        preset.setPresetName(presetName);
        preset.setTeam(team);
        preset.setBody(body);
        preset.setDecal(decal);
        preset.setPrimaryColorPaintFinish(primaryColor);
        preset.setAccentColorPaintFinish(accentColor);
        preset.setWheels(wheels);
        preset.setRocketBoost(rocketBoost);
        preset.setTrail(trail);
        preset.setTimestamp(Timestamp.now());

        savePresetToFirebase(preset);
    }

    void savePresetToFirebase(Preset preset){
        DocumentReference documentReference;

        if(isEditMode){
            //update preseta
            documentReference = CollectionUtility.getCollectionReferenceForPreset().document(docId);
        } else{
            //stvara novi preset
            documentReference = CollectionUtility.getCollectionReferenceForPreset().document();
        }

        documentReference.set(preset).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //preset dodan u bazu
                    MessageUtility.showToast(PresetDetailsActivity.this, "Preset saved successfully");
                    finish();
                } else{
                    //preset nije dodan
                    MessageUtility.showToast(PresetDetailsActivity.this, "Failure while saving preset");
                }
            }
        });
    }

    void deletePresetFromFirebase(){
        DocumentReference documentReference;
        documentReference = CollectionUtility.getCollectionReferenceForPreset().document(docId);

        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //preset izbrisan
                    MessageUtility.showToast(PresetDetailsActivity.this, "Preset deleted successfully");
                    finish();
                } else{
                    //preset nije izbrisan
                    MessageUtility.showToast(PresetDetailsActivity.this, "Failure while deleting preset");
                }
            }
        });
    }
}