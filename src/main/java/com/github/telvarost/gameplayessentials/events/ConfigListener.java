package com.github.telvarost.gameplayessentials.events;

import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;
import net.glasslauncher.mods.api.gcapi.api.PreConfigSavedListener;
import net.glasslauncher.mods.api.gcapi.impl.ConfigFactories;
import net.mine_diver.unsafeevents.listener.EventListener;

import java.lang.reflect.Field;

import static com.github.telvarost.gameplayessentials.Config.config;

@EventListener
public class ConfigListener implements PreConfigSavedListener {

    @Override
    public void onPreConfigSaved(int var1, JsonObject jsonObject0, JsonObject jsonObject1) {
        /** - Ensure stairs crafting recipe output is an integer value between 1 and 16 */
        if (16 < config.STAIRS_OUTPUT)
        {
            config.STAIRS_OUTPUT = 16;
            try {
                for (Field field : com.github.telvarost.gameplayessentials.Config.ConfigFields.class.getDeclaredFields()) {
                    jsonObject1.put(field.getName(), ConfigFactories.saveFactories.get(field.getType()).apply(field.get(config)));
                }
                jsonObject1.put("STAIRS_OUTPUT", new JsonPrimitive(16));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else if (1 > config.STAIRS_OUTPUT)
        {
            config.STAIRS_OUTPUT = 1;
            try {
                for (Field field : com.github.telvarost.gameplayessentials.Config.ConfigFields.class.getDeclaredFields()) {
                    jsonObject1.put(field.getName(), ConfigFactories.saveFactories.get(field.getType()).apply(field.get(config)));
                }
                jsonObject1.put("STAIRS_OUTPUT", new JsonPrimitive(1));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
