package com.example.myrlgarage.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrlgarage.R;
import com.example.myrlgarage.activities.PresetDetailsActivity;
import com.example.myrlgarage.models.Preset;
import com.example.myrlgarage.models.TimestampUtility;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PresetReverseDateAdapter extends FirestoreRecyclerAdapter<Preset, PresetReverseDateAdapter.PresetViewHolder> {

    Context context;

    public PresetReverseDateAdapter(@NonNull FirestoreRecyclerOptions<Preset> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull PresetViewHolder holder, int position, @NonNull Preset preset) {
        holder.presetNameTextView.setText(preset.getPresetName());
        holder.teamNameTextView.setText(preset.getTeam());
        holder.bodyTextView.setText(preset.getBody());
        holder.decalTextView.setText(preset.getDecal());
        holder.timestampTextView.setText(TimestampUtility.timestampToString(preset.getTimestamp()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PresetDetailsActivity.class);
            intent.putExtra("presetName", preset.getPresetName());
            intent.putExtra("team", preset.getTeam());
            intent.putExtra("body", preset.getBody());
            intent.putExtra("decal", preset.getDecal());
            intent.putExtra("primaryColorPaintFinish", preset.getPrimaryColorPaintFinish());
            intent.putExtra("accentColorPaintFinish", preset.getAccentColorPaintFinish());
            intent.putExtra("wheels", preset.getWheels());
            intent.putExtra("rocketBoost", preset.getRocketBoost());
            intent.putExtra("trail", preset.getTrail());
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId", docId);

            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public PresetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_preset_item, parent, false);
        return new PresetViewHolder(view);
    }

    class PresetViewHolder extends RecyclerView.ViewHolder{

        TextView presetNameTextView, teamNameTextView, bodyTextView, decalTextView, timestampTextView;

        public PresetViewHolder(@NonNull View itemView) {
            super(itemView);

            presetNameTextView = itemView.findViewById(R.id.preset_name_text_view);
            teamNameTextView = itemView.findViewById(R.id.team_name_text_view);
            bodyTextView = itemView.findViewById(R.id.body_text_view);
            decalTextView = itemView.findViewById(R.id.decal_text_view);
            timestampTextView = itemView.findViewById(R.id.timestamp_text_view);
        }
    }
}