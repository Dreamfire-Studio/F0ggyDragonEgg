package com.dreamfirestudios.f0ggydragonegg.PlayerCommand;

import com.dreamfirestudios.dreamCommand.Enums.TabType;
import com.dreamfirestudios.dreamCommand.Interface.PCAutoTab;
import com.dreamfirestudios.dreamCommand.Interface.PCMethod;
import com.dreamfirestudios.dreamCommand.Interface.PCSignature;
import com.dreamfirestudios.dreamCommand.Interface.PCTab;
import com.dreamfirestudios.dreamCommand.PlayerCommand;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.f0ggydragonegg.API.F0ggyDragonEggAPI;
import com.dreamfirestudios.f0ggydragonegg.Enum.Messages;
import com.dreamfirestudios.f0ggydragonegg.Enum.Permissions;
import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggConfig;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggMessages;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggPermissions;
import com.dreamfirestudios.f0ggydragonegg.SmartInvs.F0ggyDragonEggCoreMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;
import java.util.UUID;

@PulseAutoRegister
public class F0ggyDragonEggPlayerCommand extends PlayerCommand {
    public F0ggyDragonEggPlayerCommand() {
        super("f0ggydragonegg", false);
    }

    @Override
    public void NoMethodFound(Player player, String s, String[] strings) {}
    @Override
    public String helpMenuPrefix(Player player) {
        return "";
    }
    @Override
    public LinkedHashMap<String, String> helpMenuFormat(Player player, LinkedHashMap<String, String> linkedHashMap) {return new LinkedHashMap<>();}
    @Override
    public String helpMenuSuffix(Player player) {
        return "";
    }

    @PCMethod
    @PCSignature({})
    public void TimeStealCoreMethod(UUID playerID){
        var player = Bukkit.getPlayer(playerID);
        if(player == null) return;
        F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggPermissions.class, craftLegendsCorePermissions -> {
            if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.AdminConsole, player, true)) return;
            new F0ggyDragonEggCoreMenu(player);
        });
    }

    @PCMethod
    @PCSignature({"enable"})
    @PCAutoTab(pos = 1)
    public void TimeStealCoreEnableMethod(UUID playerID, boolean state){
        var player = Bukkit.getPlayer(playerID);
        if(player == null) return;
        F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(),F0ggyDragonEggPermissions.class, craftLegendsCorePermissions -> {
            if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.EnableSystem, player, true)) return;
            F0ggyDragonEggAPI.F0ggyDragonEggEnableSystem(dreamCoreTestTemplateConfig -> {}, state);
            F0ggyDragonEggMessages.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(),F0ggyDragonEggMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToPlayer(state ? Messages.ConsoleEnabledSystem : Messages.ConsoleDisableSystem, player);
            });
        });
    }

    @PCMethod
    @PCSignature({"serialize"})
    @PCTab(pos = 1, type = TabType.PureData, data = "ITEM ID")
    public void TimeStealCoreSerializeItemMethod(UUID playerUUID, String itemName){
        var player = Bukkit.getPlayer(playerUUID);
        if(player == null) return;
        F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggPermissions.class, craftLegendsCorePermissions -> {
            if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.SerializeItem, player, true)) return;
            F0ggyDragonEggAPI.F0ggyDragonEggSerializeItem(dreamCoreTestTemplateSerilizableItems -> {}, itemName, player.getInventory().getItemInMainHand());
            F0ggyDragonEggMessages.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToPlayer(Messages.PlayerSerlizedItem, player, itemName);
            });
        });
    }

    @PCMethod
    @PCSignature({"configs", "reset"})
    public void TimeStealCoreConfigsResetMethod(UUID playerID){
        var player = Bukkit.getPlayer(playerID);
        if(player == null) return;
        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggPermissions.class, craftLegendsCorePermissions -> {
                if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.ResetConfigs, player, true)) return;
                F0ggyDragonEggAPI.F0ggyDragonEggResetConfigs();
                F0ggyDragonEggMessages.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggMessages.class, craftLegendsCoreMessages -> {
                    craftLegendsCoreMessages.SendMessageToPlayer(Messages.PlayerResetConfig, player);
                });
            });
        });
    }

    @PCMethod
    @PCSignature({"configs", "reload"})
    public void TimeStealCoreReloadMethod(UUID playerID){
        var player = Bukkit.getPlayer(playerID);
        if(player == null) return;
        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggPermissions.class, craftLegendsCorePermissions -> {
                if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.ReloadConfigs, player, true)) return;
                F0ggyDragonEggAPI.F0ggyDragonEggReloadConfigs();
                F0ggyDragonEggMessages.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggMessages.class, craftLegendsCoreMessages -> {
                    craftLegendsCoreMessages.SendMessageToPlayer(Messages.PlayerReloadedConfig, player);
                });
            });
        });
    }

    @PCMethod
    @PCSignature({"get"})
    public void TimeStealCoreGetMethod(UUID playerID){
        var player = Bukkit.getPlayer(playerID);
        if(player == null) return;
        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(), F0ggyDragonEggPermissions.class, craftLegendsCorePermissions -> {
                if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.GetDragonEgg, player, true)) return;
                F0ggyDragonEggAPI.GivePlayerDragonEgg(player);
            });
        });
    }
}
