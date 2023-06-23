package com.example.myrlgarage.models;

import com.google.firebase.Timestamp;

public class Preset {

    String presetName;
    String team;
    String body;
    String decal;
    String primaryColorPaintFinish;
    String accentColorPaintFinish;
    String wheels;
    String rocketBoost;
    String trail;
    Timestamp timestamp;

    public Preset() {
    }

    public String getPresetName() {
        return presetName;
    }

    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDecal() {
        return decal;
    }

    public void setDecal(String decal) {
        this.decal = decal;
    }

    public String getPrimaryColorPaintFinish() {
        return primaryColorPaintFinish;
    }

    public void setPrimaryColorPaintFinish(String primaryColorPaintFinish) {
        this.primaryColorPaintFinish = primaryColorPaintFinish;
    }

    public String getAccentColorPaintFinish() {
        return accentColorPaintFinish;
    }

    public void setAccentColorPaintFinish(String accentColorPaintFinish) {
        this.accentColorPaintFinish = accentColorPaintFinish;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getRocketBoost() {
        return rocketBoost;
    }

    public void setRocketBoost(String rocketBoost) {
        this.rocketBoost = rocketBoost;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
