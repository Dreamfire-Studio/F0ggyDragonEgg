package com.dreamfirestudios.\f0ggydragonegg.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticPulseConfig;
import com.dreamfirestudios.dreamConfig.Interface.StorageComment;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.\f0ggydragonegg.\F0ggyDragonEgg;
import com.dreamfirestudios.\f0ggydragonegg.Event.\F0ggyDragonEggEnableSystemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Consumer;

@PulseAutoRegister
public class \F0ggyDragonEggConfig extends StaticPulseConfig<\F0ggyDragonEggConfig> {
    @Override
    public JavaPlugin mainClass() {return \F0ggyDragonEgg.Get\F0ggyDragonEgg();}
    @StorageComment("WARNING: SYSTEM WONT RUN IF FALSE!")
    public boolean systemEnabled = true;
    @StorageComment("Display debugs in the console logs for changes in this config!")
    public boolean debugConfig = false;

    public void ToggleSystemEnabled(Consumer<\F0ggyDragonEggConfig> onSuccess, boolean newState){
        new \F0ggyDragonEggEnableSystemEvent(systemEnabled, newState);
        systemEnabled = newState;
        SaveConfig(onSuccess, Throwable::printStackTrace);
    }
}
