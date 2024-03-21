package com.github.telvarost.gameplayessentials;

public enum BedBehaviorEnum {

    VANILLA("Vanilla"),
    DISABLE_NIGHTMARES("Disable Nightmares"),
    SET_SPAWN_POINT_ONLY("Set Spawn Point Only"),
    DISABLE_ENTIRELY("Disable Entirely");

    final String stringValue;

    BedBehaviorEnum() {
        this.stringValue = "Vanilla";
    }

    BedBehaviorEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}