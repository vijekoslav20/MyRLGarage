// Generated by view binder compiler. Do not edit!
package com.example.myrlgarage.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myrlgarage.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPresetDetailsBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText accentColorEditText;

  @NonNull
  public final EditText bodyEditText;

  @NonNull
  public final EditText decalEditText;

  @NonNull
  public final ImageButton deletePresetBtn;

  @NonNull
  public final TextView pageTitleTextView;

  @NonNull
  public final EditText presetNameEditText;

  @NonNull
  public final EditText primaryColorEditText;

  @NonNull
  public final EditText rocketBoostEditText;

  @NonNull
  public final ImageButton savePresetBtn;

  @NonNull
  public final EditText teamEditText;

  @NonNull
  public final RelativeLayout titleBarLayout;

  @NonNull
  public final EditText trailEditText;

  @NonNull
  public final EditText wheelsEditText;

  private ActivityPresetDetailsBinding(@NonNull RelativeLayout rootView,
      @NonNull EditText accentColorEditText, @NonNull EditText bodyEditText,
      @NonNull EditText decalEditText, @NonNull ImageButton deletePresetBtn,
      @NonNull TextView pageTitleTextView, @NonNull EditText presetNameEditText,
      @NonNull EditText primaryColorEditText, @NonNull EditText rocketBoostEditText,
      @NonNull ImageButton savePresetBtn, @NonNull EditText teamEditText,
      @NonNull RelativeLayout titleBarLayout, @NonNull EditText trailEditText,
      @NonNull EditText wheelsEditText) {
    this.rootView = rootView;
    this.accentColorEditText = accentColorEditText;
    this.bodyEditText = bodyEditText;
    this.decalEditText = decalEditText;
    this.deletePresetBtn = deletePresetBtn;
    this.pageTitleTextView = pageTitleTextView;
    this.presetNameEditText = presetNameEditText;
    this.primaryColorEditText = primaryColorEditText;
    this.rocketBoostEditText = rocketBoostEditText;
    this.savePresetBtn = savePresetBtn;
    this.teamEditText = teamEditText;
    this.titleBarLayout = titleBarLayout;
    this.trailEditText = trailEditText;
    this.wheelsEditText = wheelsEditText;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPresetDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPresetDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_preset_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPresetDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.accentColorEditText;
      EditText accentColorEditText = ViewBindings.findChildViewById(rootView, id);
      if (accentColorEditText == null) {
        break missingId;
      }

      id = R.id.bodyEditText;
      EditText bodyEditText = ViewBindings.findChildViewById(rootView, id);
      if (bodyEditText == null) {
        break missingId;
      }

      id = R.id.decalEditText;
      EditText decalEditText = ViewBindings.findChildViewById(rootView, id);
      if (decalEditText == null) {
        break missingId;
      }

      id = R.id.deletePresetBtn;
      ImageButton deletePresetBtn = ViewBindings.findChildViewById(rootView, id);
      if (deletePresetBtn == null) {
        break missingId;
      }

      id = R.id.pageTitleTextView;
      TextView pageTitleTextView = ViewBindings.findChildViewById(rootView, id);
      if (pageTitleTextView == null) {
        break missingId;
      }

      id = R.id.presetNameEditText;
      EditText presetNameEditText = ViewBindings.findChildViewById(rootView, id);
      if (presetNameEditText == null) {
        break missingId;
      }

      id = R.id.primaryColorEditText;
      EditText primaryColorEditText = ViewBindings.findChildViewById(rootView, id);
      if (primaryColorEditText == null) {
        break missingId;
      }

      id = R.id.rocketBoostEditText;
      EditText rocketBoostEditText = ViewBindings.findChildViewById(rootView, id);
      if (rocketBoostEditText == null) {
        break missingId;
      }

      id = R.id.savePresetBtn;
      ImageButton savePresetBtn = ViewBindings.findChildViewById(rootView, id);
      if (savePresetBtn == null) {
        break missingId;
      }

      id = R.id.teamEditText;
      EditText teamEditText = ViewBindings.findChildViewById(rootView, id);
      if (teamEditText == null) {
        break missingId;
      }

      id = R.id.titleBarLayout;
      RelativeLayout titleBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (titleBarLayout == null) {
        break missingId;
      }

      id = R.id.trailEditText;
      EditText trailEditText = ViewBindings.findChildViewById(rootView, id);
      if (trailEditText == null) {
        break missingId;
      }

      id = R.id.wheelsEditText;
      EditText wheelsEditText = ViewBindings.findChildViewById(rootView, id);
      if (wheelsEditText == null) {
        break missingId;
      }

      return new ActivityPresetDetailsBinding((RelativeLayout) rootView, accentColorEditText,
          bodyEditText, decalEditText, deletePresetBtn, pageTitleTextView, presetNameEditText,
          primaryColorEditText, rocketBoostEditText, savePresetBtn, teamEditText, titleBarLayout,
          trailEditText, wheelsEditText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
