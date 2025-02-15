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
        public Boolean ALLOW_PRESSURE_PLATES_ON_FENCES = true;

        @ConfigEntry(
                name = "Allow Placing Sugar Canes On Sand",
                multiplayerSynced = true
        )
        public Boolean ALLOW_SUGAR_CANE_ON_SAND = true;

        @ConfigEntry(
                name = "Allow Placing Trapdoors Without Support",
                multiplayerSynced = true
        )
        public Boolean ALLOW_TRAPDOORS_WITHOUT_SUPPORTS = true;

        @ConfigEntry(
                name = "Bed Behavior When Used",
                multiplayerSynced = true
        )
        public BedBehaviorEnum BED_BEHAVIOR_ENUM = BedBehaviorEnum.VANILLA;

        @ConfigEntry(
                name = "Disable Block Interactions With Keybind",
                description = "Multiplayer will always use sneak keybinding",
                multiplayerSynced = true
        )
        public Boolean DISABLE_BLOCK_INTERACTIONS_WITH_KEYBIND = true;

        @ConfigEntry(
                name = "Disable Eating At Max Health",
                multiplayerSynced = true
        )
        public Boolean DISABLE_EATING_AT_MAX_HEALTH = false;

        @ConfigEntry(
                name = "Fix Caught Fish Going Above Player Head",
                multiplayerSynced = true
        )
        public Boolean FIX_FISHING = false;

        @ConfigEntry(
                name = "Fix Lava Bucket Being Consumed In Furnace",
                multiplayerSynced = true
        )
        public Boolean FIX_FURNACE_LAVA_BUCKET = true;

        @ConfigEntry(
                name = "Fix Minecart Stopping On Items",
                multiplayerSynced = true
        )
        public Boolean FIX_MINECART_STOPPING_ON_ITEMS = true;

        @ConfigEntry(
                name = "Fix Slime Drops",
                multiplayerSynced = true
        )
        public Boolean FIX_SLIME_DROPS = true;

        @ConfigEntry(
                name = "Shapeless Jack o’ Lantern Recipe",
                description = "Restart required for changes to take effect",
                multiplayerSynced = true
        )
        public Boolean SHAPELESS_JACKOLANTERN_RECIPE = true;

        @ConfigEntry(
                name = "Stairs Crafting Recipe Output: 1-16",
                description = "Restart required for changes to take effect",
                multiplayerSynced = true,
                maxLength = 16
        )
        public Integer STAIRS_OUTPUT = 4;

        @ConfigEntry(
                name = "Trapdoor Crafting Recipe Output: 1-8",
                description = "Restart required for changes to take effect",
                multiplayerSynced = true,
                maxLength = 8
        )
        public Integer TRAPDOOR_OUTPUT = 2;

        @ConfigEntry(
                name = "Use Right Click To Equip Armor",
                multiplayerSynced = true
        )
        public Boolean RIGHT_CLICK_ARMOR_EQUIP = true;
    }
}
