package com.dreamfirestudios.f0ggydragonegg.Enum;

import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;

public enum Permissions {
    ReloadConfigs("F0ggyDragonEgg.Admin.ReloadConfigs", String.format("#7fff36%s: You do not have the permission to use this command!", F0ggyDragonEgg.class.getSimpleName())),
    ResetConfigs("F0ggyDragonEgg.Admin.ResetConfigs", String.format("#7fff36%s: You do not have the permission to use this command!", F0ggyDragonEgg.class.getSimpleName())),
    EnableSystem("F0ggyDragonEgg.Admin.EnableSystem", String.format("#7fff36%s: You do not have the permission to use this command!", F0ggyDragonEgg.class.getSimpleName())),
    SerializeItem("F0ggyDragonEgg.Admin.SerilizeItem", String.format("#7fff36%s: You do not have the permission to use this command!", F0ggyDragonEgg.class.getSimpleName())),
    AdminConsole("F0ggyDragonEgg.Admin.SerilizeItem", String.format("#7fff36%s: You do not have the permission to use this command!", F0ggyDragonEgg.class.getSimpleName())),
    RiptideEffect("F0ggyDragonEgg.Player.RiptideEffect", String.format("#7fff36%s: You do not have the permission to use this command!", F0ggyDragonEgg.class.getSimpleName())),
    GetDragonEgg("F0ggyDragonEgg.Player.GetDragonEgg", String.format("#7fff36%s: You do not have the permission to use this command", F0ggyDragonEgg.class.getSimpleName())),
    CycleDragonEffEffect("F0ggyDragonEgg.Player.CycleDragonEffEffect", String.format("#7fff36%s: You do not have the permission to use this command", F0ggyDragonEgg.class.getSimpleName()));

    public final String permission;
    public final String error;
    Permissions(String permission, String error){
        this.permission = permission;
        this.error = error;
    }
}
