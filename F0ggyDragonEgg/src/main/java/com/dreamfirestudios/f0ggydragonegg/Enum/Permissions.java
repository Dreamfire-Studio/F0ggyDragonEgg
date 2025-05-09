package com.dreamfirestudios.\f0ggydragonegg.Enum;

import com.dreamfirestudios.\f0ggydragonegg.\F0ggyDragonEgg;

public enum Permissions {
    ReloadConfigs("TimeStealCore.Admin.ReloadConfigs", String.format("#7fff36%s: You do not have the permission to use this command!", \F0ggyDragonEgg.class.getSimpleName())),
    ResetConfigs("TimeStealCore.Admin.ResetConfigs", String.format("#7fff36%s: You do not have the permission to use this command!", \F0ggyDragonEgg.class.getSimpleName())),
    EnableSystem("TimeStealCore.Admin.EnableSystem", String.format("#7fff36%s: You do not have the permission to use this command!", \F0ggyDragonEgg.class.getSimpleName())),
    SerializeItem("TimeStealCore.Admin.SerilizeItem", String.format("#7fff36%s: You do not have the permission to use this command!", \F0ggyDragonEgg.class.getSimpleName())),
    AdminConsole("CraftLegendsPaper.Admin.SerilizeItem", String.format("#7fff36%s: You do not have the permission to use this command!", \F0ggyDragonEgg.class.getSimpleName())),
    RedrawRegions("TimeStealCore.Admin.RedrawRegions", String.format("#7fff36%s: You do not have the permission to use this command!", \F0ggyDragonEgg.class.getSimpleName()));

    public final String permission;
    public final String error;
    Permissions(String permission, String error){
        this.permission = permission;
        this.error = error;
    }
}
