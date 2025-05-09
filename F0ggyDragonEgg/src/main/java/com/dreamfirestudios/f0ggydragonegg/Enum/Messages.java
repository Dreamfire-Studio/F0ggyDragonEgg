package com.dreamfirestudios.\f0ggydragonegg.Enum;

import com.dreamfirestudios.\f0ggydragonegg.\F0ggyDragonEgg;

public enum Messages {
    ConsoleEnabledSystem(String.format("#7fff36%s has been enabled!", \F0ggyDragonEgg.Get\F0ggyDragonEgg().getName())),
    ConsoleDisableSystem(String.format("#7fff36%s has been disabled!", \F0ggyDragonEgg.Get\F0ggyDragonEgg().getName())),
    PlayerReloadedConfig(String.format("#7fff36%s configs have been reloaded!", \F0ggyDragonEgg.Get\F0ggyDragonEgg().getName())),
    PlayerSerlizedItem("#7fff36You have added a item to the serialized items: #ffffff%s"),
    PlayerResetConfig(String.format("#7fff36%s configs have been reset!", \F0ggyDragonEgg.Get\F0ggyDragonEgg().getName())),
    SystemIsntEnabled(String.format("#7fff36%s Isn't Enabled!", \F0ggyDragonEgg.Get\F0ggyDragonEgg().getName()));

    public final String message;
    Messages(String message){
        this.message = message;
    }
}
