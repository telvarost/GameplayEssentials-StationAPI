package com.github.telvarost.gameplayessentials;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "GameplayEssentials")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigEntry(
                name = "Allow Placing Pressure Plates On Fences",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean ALLOW_PRESSURE_PLATES_ON_FENCES = true;

        @ConfigEntry(
                name = "Allow Placing Sugar Canes On Sand",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean ALLOW_SUGAR_CANE_ON_SAND = true;

        @ConfigEntry(
                name = "Allow Placing Trapdoors Without Support",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean ALLOW_TRAPDOORS_WITHOUT_SUPPORTS = true;

        @ConfigEntry(
                name = "Bed Behavior When Used",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(integerValue = 0)
        public BedBehaviorEnum BED_BEHAVIOR_ENUM = BedBehaviorEnum.VANILLA;

        @ConfigEntry(
                name = "Disable Block Interactions With Keybind",
                description = "Multiplayer will always use sneak keybinding",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean DISABLE_BLOCK_INTERACTIONS_WITH_KEYBIND = true;

        @ConfigEntry(
                name = "Disable Eating At Max Health",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean DISABLE_EATING_AT_MAX_HEALTH = false;

        @ConfigEntry(
                name = "Fix Caught Fish Going Above Player Head",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_FISHING = false;

        @ConfigEntry(
                name = "Fix Lava Bucket Being Consumed In Furnace",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_FURNACE_LAVA_BUCKET = true;

        @ConfigEntry(
                name = "Fix Minecart Stopping On Items",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_MINECART_STOPPING_ON_ITEMS = true;

        @ConfigEntry(
                name = "Fix Slime Drops",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean FIX_SLIME_DROPS = true;

        @ConfigEntry(
                name = "Shapeless Jack o’ Lantern Recipe",
                description = "Restart required for changes to take effect",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean SHAPELESS_JACKOLANTERN_RECIPE = true;

        @ConfigEntry(
                name = "Stairs Crafting Recipe Output: 1-16",
                description = "Restart required for changes to take effect",
                multiplayerSynced = true,
                maxLength = 16
        )
        @ValueOnVanillaServer(integerValue = 4)
        public Integer STAIRS_OUTPUT = 4;

        @ConfigEntry(
                name = "Use Right Click To Equip Armor",
                multiplayerSynced = true
        )
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean RIGHT_CLICK_ARMOR_EQUIP = true;
    }
}
