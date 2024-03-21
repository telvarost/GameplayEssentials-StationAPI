package com.github.telvarost.gameplayessentials;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.*;

public class Config {

    @GConfig(value = "config", visibleName = "GameplayEssentials")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigName("Allow placing pressure plates on fences")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean ALLOW_PRESSURE_PLATES_ON_FENCES = true;

        @ConfigName("Allow placing sugarcane on sand")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean ALLOW_SUGAR_CANE_ON_SAND = true;

        @ConfigName("Allow placing trapdoors without support")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean ALLOW_TRAPDOORS_WITHOUT_SUPPORTS = true;

        @ConfigName("Bed Behavior When Used")
        @MultiplayerSynced
        @ValueOnVanillaServer(integerValue = 0)
        public BedBehaviorEnum BED_BEHAVIOR_ENUM = BedBehaviorEnum.VANILLA;

        @ConfigName("Fix caught fish going above player head")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_FISHING = false;

        @ConfigName("Fix lava bucket being consumed in furnace")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_FURNACE_LAVA_BUCKET = true;

        @ConfigName("Fix minecart stopping on items")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_MINECART_STOPPING_ON_ITEMS = true;

        @ConfigName("Fix slime drops")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_SLIME_DROPS = true;
    }
}
