package com.github.telvarost.gameplayessentials.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.options.KeyBinding;
import net.modificationstation.stationapi.api.client.event.option.KeyBindingRegisterEvent;
import org.lwjgl.input.Keyboard;

/** - All credit for the code in this class goes to Dany and his mod UniTweaks
 *  See: https://github.com/DanyGames2014/UniTweaks
 */
public class KeyBindingListener {
    public static KeyBinding disableBlockInteractions;

    @EventListener
    public void registerKeyBindings(KeyBindingRegisterEvent event) {
        event.keyBindings.add(disableBlockInteractions = new KeyBinding("No Interactions", Keyboard.KEY_LSHIFT));
    }
}
