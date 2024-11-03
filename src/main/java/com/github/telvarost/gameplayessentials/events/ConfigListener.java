package com.github.telvarost.gameplayessentials.events;

import net.glasslauncher.mods.gcapi3.api.PreConfigSavedListener;
import net.glasslauncher.mods.gcapi3.impl.GlassYamlFile;
import net.mine_diver.unsafeevents.listener.EventListener;

import java.lang.reflect.Field;

import static com.github.telvarost.gameplayessentials.Config.config;

@EventListener
public class ConfigListener implements PreConfigSavedListener {

    @Override
    public void onPreConfigSaved(int source, GlassYamlFile oldValues, GlassYamlFile newValues)
    {
        /** - Ensure stairs crafting recipe output is an integer value between 1 and 16 */
        if (16 < config.STAIRS_OUTPUT)
        {
            config.STAIRS_OUTPUT = 16;
            newValues.set("STAIRS_OUTPUT", 16);
        }
        else if (1 > config.STAIRS_OUTPUT)
        {
            config.STAIRS_OUTPUT = 1;
            newValues.set("STAIRS_OUTPUT", 1);
        }
    }
}
