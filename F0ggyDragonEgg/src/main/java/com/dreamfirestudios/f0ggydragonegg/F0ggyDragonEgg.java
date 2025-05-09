package com.dreamfirestudios.\f0ggydragonegg;

import com.dreamfirestudios.dreamCommand.DreamCommand;
import com.dreamfirestudios.dreamCore.DreamfireJava.DreamfireClassAPI;
import com.dreamfirestudios.\f0ggydragonegg.API.\F0ggyDragonEggAPI;
import com.dreamfirestudios.\f0ggydragonegg.DreamfireVariableTest.\F0ggyDragonEggInventoryItemsVariableTest;
import com.dreamfirestudios.\f0ggydragonegg.DreamfireVariableTest.\F0ggyDragonEggMessagesVariableTest;
import com.dreamfirestudios.\f0ggydragonegg.DreamfireVariableTest.\F0ggyDragonEggPermissionsVariableTest;
import org.bukkit.plugin.java.JavaPlugin;

public final class \F0ggyDragonEgg extends JavaPlugin {
    private static \F0ggyDragonEgg craftLegendsCore;
    public static \F0ggyDragonEgg Get\F0ggyDragonEgg(){return craftLegendsCore;}

    @Override
    public void onEnable() {
        craftLegendsCore = this;
        DreamfireClassAPI.RegisterPulseVariableTest(craftLegendsCore, new \F0ggyDragonEggMessagesVariableTest());
        DreamfireClassAPI.RegisterPulseVariableTest(craftLegendsCore, new \F0ggyDragonEggInventoryItemsVariableTest());
        DreamfireClassAPI.RegisterPulseVariableTest(craftLegendsCore, new \F0ggyDragonEggPermissionsVariableTest());
        \F0ggyDragonEggAPI.\F0ggyDragonEggReloadConfigs();
        DreamfireClassAPI.RegisterClasses(this);
        DreamCommand.RegisterRaw(this);
    }
}
