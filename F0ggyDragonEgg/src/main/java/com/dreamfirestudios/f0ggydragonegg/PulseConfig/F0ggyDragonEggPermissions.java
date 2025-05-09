package com.dreamfirestudios.\f0ggydragonegg.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticEnumPulseConfig;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.\f0ggydragonegg.\F0ggyDragonEgg;
import com.dreamfirestudios.\f0ggydragonegg.Enum.Permissions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@PulseAutoRegister
public class \F0ggyDragonEggPermissions extends StaticEnumPulseConfig<\F0ggyDragonEggPermissions, Permissions, String> {
    @Override
    public JavaPlugin mainClass() {return \F0ggyDragonEgg.Get\F0ggyDragonEgg();}
    @Override
    protected Class<Permissions> getKeyClass() {return Permissions.class;}
    @Override
    protected Class<String> getValueClass() {return String.class;}
    @Override
    protected String getDefaultValueFor(Permissions craftLegendsCorePermission) {return craftLegendsCorePermission.permission;}

    public boolean DoesPlayerHavePermission(Permissions permission, Player player, boolean sendError){
        if(permission == null || player == null) return false;
        var user = com.dreamfirestudios.dreamCore.DreamfireLuckPerms.DreamfireLuckPerms.getUser(player);
        var permissionState = com.dreamfirestudios.dreamCore.DreamfireLuckPerms.DreamfireLuckPerms.hasPermission(user, getDefaultValueFor(permission));
        if(!permissionState && sendError) com.dreamfirestudios.dreamCore.DreamfireChat.DreamfireChat.SendMessageToPlayer(player, permission.error);
        return permissionState;
    }
}
