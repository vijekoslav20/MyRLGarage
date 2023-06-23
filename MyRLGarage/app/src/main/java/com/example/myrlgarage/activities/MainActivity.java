package com.example.myrlgarage.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.myrlgarage.adapters.PresetAdapter;
import com.example.myrlgarage.adapters.PresetAlphabeticalAdapter;
import com.example.myrlgarage.adapters.PresetReverseAlphabeticalAdapter;
import com.example.myrlgarage.adapters.PresetReverseDateAdapter;
import com.example.myrlgarage.databinding.ActivityMainBinding;
import com.example.myrlgarage.models.CollectionUtility;
import com.example.myrlgarage.models.Preset;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {
    PresetAdapter presetAdapter;
    PresetReverseDateAdapter presetReverseDateAdapter;
    PresetAlphabeticalAdapter presetAlphabeticalAdapter;
    PresetReverseAlphabeticalAdapter presetReverseAlphabeticalAdapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.addPresetBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PresetDetailsActivity.class)));
        binding.menuBtn.setOnClickListener(v -> showMenu());
        binding.sortBtn.setOnClickListener(v -> showSortMenu());
        setupRecyclerView();
        setupRecyclerViewDateReverse();
        setupRecyclerViewAlphabetical();
        setupRecyclerViewAlphabeticalReverse();
    }

    void showMenu(){
        //logout
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, binding.menuBtn);
        popupMenu.getMenu().add("Color Guide");
        popupMenu.getMenu().add("Logout");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getTitle() == "Logout"){
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                    return true;
                } else if(menuItem.getTitle() == "Color Guide") {
                    startActivity(new Intent(MainActivity.this, ShowColorsActivity.class));
                    return true;
                }
                    return false;
            }
        });
    }

    void showSortMenu(){
        //sort
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, binding.sortBtn);
        popupMenu.getMenu().add("Alphabetically");
        popupMenu.getMenu().add("Alphabetically (Reverse)");
        popupMenu.getMenu().add("By Date");
        popupMenu.getMenu().add("By Date (Reverse)");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getTitle() == "Alphabetically"){
                    sortAlphabetical();
                    return true;
                } else if(menuItem.getTitle() == "Alphabetically (Reverse)"){
                    sortAlphabeticalReverse();
                    return true;
                } else if(menuItem.getTitle() == "By Date"){
                    sortByDate();
                    return true;
                } else if(menuItem.getTitle() == "By Date (Reverse)"){
                    sortByDateReverse();
                    return true;
                }
                return false;
            }
        });
    }

    void setupRecyclerView(){
        Query query = CollectionUtility.getCollectionReferenceForPreset().orderBy("timestamp", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Preset> options = new FirestoreRecyclerOptions.Builder<Preset>()
                .setQuery(query, Preset.class).build();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presetAdapter = new PresetAdapter(options, this);
        binding.recyclerView.setAdapter(presetAdapter);
    }

    void setupRecyclerViewDateReverse(){
        Query query = CollectionUtility.getCollectionReferenceForPreset().orderBy("timestamp", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Preset> options = new FirestoreRecyclerOptions.Builder<Preset>()
                .setQuery(query, Preset.class).build();
        binding.recyclerViewDateReverse.setLayoutManager(new LinearLayoutManager(this));
        presetReverseDateAdapter = new PresetReverseDateAdapter(options, this);
        binding.recyclerViewDateReverse.setAdapter(presetReverseDateAdapter);
    }

    void setupRecyclerViewAlphabetical(){
        Query query = CollectionUtility.getCollectionReferenceForPreset().orderBy("presetName", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Preset> options = new FirestoreRecyclerOptions.Builder<Preset>()
                .setQuery(query, Preset.class).build();
        binding.recyclerViewAlphabetical.setLayoutManager(new LinearLayoutManager(this));
        presetAlphabeticalAdapter = new PresetAlphabeticalAdapter(options, this);
        binding.recyclerViewAlphabetical.setAdapter(presetAlphabeticalAdapter);
    }

    void setupRecyclerViewAlphabeticalReverse(){
        Query query = CollectionUtility.getCollectionReferenceForPreset().orderBy("presetName", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Preset> options = new FirestoreRecyclerOptions.Builder<Preset>()
                .setQuery(query, Preset.class).build();
        binding.recyclerViewAlphabeticalReverse.setLayoutManager(new LinearLayoutManager(this));
        presetReverseAlphabeticalAdapter = new PresetReverseAlphabeticalAdapter(options, this);
        binding.recyclerViewAlphabeticalReverse.setAdapter(presetReverseAlphabeticalAdapter);
    }

    void sortAlphabetical(){
        binding.recyclerView.setVisibility(View.GONE);
        binding.recyclerViewDateReverse.setVisibility(View.GONE);
        binding.recyclerViewAlphabetical.setVisibility(View.VISIBLE);
        binding.recyclerViewAlphabeticalReverse.setVisibility(View.GONE);
    }

    void sortAlphabeticalReverse(){
        binding.recyclerView.setVisibility(View.GONE);
        binding.recyclerViewDateReverse.setVisibility(View.GONE);
        binding.recyclerViewAlphabetical.setVisibility(View.GONE);
        binding.recyclerViewAlphabeticalReverse.setVisibility(View.VISIBLE);
    }

    void sortByDate(){
        binding.recyclerView.setVisibility(View.VISIBLE);
        binding.recyclerViewDateReverse.setVisibility(View.GONE);
        binding.recyclerViewAlphabetical.setVisibility(View.GONE);
        binding.recyclerViewAlphabeticalReverse.setVisibility(View.GONE);
    }

    void sortByDateReverse(){
        binding.recyclerView.setVisibility(View.GONE);
        binding.recyclerViewDateReverse.setVisibility(View.VISIBLE);
        binding.recyclerViewAlphabetical.setVisibility(View.GONE);
        binding.recyclerViewAlphabeticalReverse.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presetAdapter.startListening();
        presetAlphabeticalAdapter.startListening();
        presetReverseDateAdapter.startListening();
        presetReverseAlphabeticalAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presetAdapter.stopListening();
        presetAlphabeticalAdapter.stopListening();
        presetReverseDateAdapter.stopListening();
        presetReverseAlphabeticalAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presetAdapter.notifyDataSetChanged();
        presetAlphabeticalAdapter.notifyDataSetChanged();
        presetReverseDateAdapter.notifyDataSetChanged();
        presetReverseAlphabeticalAdapter.notifyDataSetChanged();
    }
}