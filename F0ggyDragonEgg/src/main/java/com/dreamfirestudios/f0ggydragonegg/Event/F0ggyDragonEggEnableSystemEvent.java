package com.dreamfirestudios.\f0ggydragonegg.Event;

import com.dreamfirestudios.\f0ggydragonegg.\F0ggyDragonEgg;
import com.dreamfirestudios.\f0ggydragonegg.PulseConfig.\F0ggyDragonEggConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class \F0ggyDragonEggEnableSystemEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final boolean oldState;
    private final boolean newState;

    public \F0ggyDragonEggEnableSystemEvent(boolean oldState, boolean newState){
        this.oldState = oldState;
        this.newState = newState;
        \F0ggyDragonEggConfig.ReturnStaticAsync(\F0ggyDragonEggConfig.class, coreConfig -> {
            if(coreConfig.systemEnabled) return;
            Bukkit.getScheduler().runTask(\F0ggyDragonEgg.Get\F0ggyDragonEgg(), () -> {Bukkit.getPluginManager().callEvent(this);});
        }, Throwable::printStackTrace);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
}
