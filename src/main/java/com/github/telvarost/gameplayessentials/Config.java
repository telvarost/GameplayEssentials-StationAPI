package com.github.telvarost.gameplayessentials;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.*;

public class Config {

    @GConfig(value = "config", visibleName = "GameplayEssentials")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigName("Allow Placing Pressure Plates On Fences")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean ALLOW_PRESSURE_PLATES_ON_FENCES = true;

        @ConfigName("Allow Placing Sugar Canes On Sand")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean ALLOW_SUGAR_CANE_ON_SAND = true;

        @ConfigName("Allow Placing Trapdoors Without Support")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean ALLOW_TRAPDOORS_WITHOUT_SUPPORTS = true;

        @ConfigName("Bed Behavior When Used")
        @MultiplayerSynced
        @ValueOnVanillaServer(integerValue = 0)
        public BedBehaviorEnum BED_BEHAVIOR_ENUM = BedBehaviorEnum.VANILLA;

        @ConfigName("Disable Eating At Max Health")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean DISABLE_EATING_AT_MAX_HEALTH = true;

        @ConfigName("Fix Caught Fish Going Above Player Head")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_FISHING = false;

        @ConfigName("Fix Lava Bucket Being Consumed In Furnace")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_FURNACE_LAVA_BUCKET = true;

        @ConfigName("Fix Minecart Stopping On Items")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_MINECART_STOPPING_ON_ITEMS = true;

        @ConfigName("Fix Slime Drops")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_SLIME_DROPS = true;
    }
}
