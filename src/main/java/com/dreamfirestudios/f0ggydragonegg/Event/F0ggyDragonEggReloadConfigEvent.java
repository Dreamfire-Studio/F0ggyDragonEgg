package com.dreamfirestudios.f0ggydragonegg.Event;

import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class F0ggyDragonEggReloadConfigEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public F0ggyDragonEggReloadConfigEvent(){
        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggConfig.class, coreConfig -> {
            if(coreConfig.systemEnabled) return;
            Bukkit.getScheduler().runTask(F0ggyDragonEgg.GetF0ggyDragonEgg(), () -> {Bukkit.getPluginManager().callEvent(this);});
        });
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
}
