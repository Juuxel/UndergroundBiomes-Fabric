package com.aang23.undergroundbiomes.api.event;

import net.minecraftforge.eventbus.api.Event;

/**
 * Fired when UBC is registering its ore compatibility. Mods which wants to
 * register ores should do it here through UBOreConfigManager#registerOre
 */
public class UBRegistrarRegisterOresEvent extends Event {
    public UBRegistrarRegisterOresEvent() {
    }
}