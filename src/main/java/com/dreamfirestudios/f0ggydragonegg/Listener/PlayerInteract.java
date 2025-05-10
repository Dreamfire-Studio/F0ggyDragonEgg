package com.dreamfirestudios.f0ggydragonegg.Listener;

import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.dreamCore.DreamfirePersistentData.DreamfirePersistentItemStack;
import com.dreamfirestudios.f0ggydragonegg.Enum.Permissions;
import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggConfig;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggPermissions;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataType;

@PulseAutoRegister
public class PlayerInteract implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        var action = event.getAction();
        var player = event.getPlayer();
        var itemStack = event.getItem();
        if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, F0ggyDragonEggConfig.DRAGON_EGG)) return;

        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEggConfig.class, f0ggyDragonEggConfig -> {
            var playerLocation = player.getLocation().clone().subtract(0, 0.1, 0);
            var blockBelow = playerLocation.getBlock();
            if(!f0ggyDragonEggConfig.systemEnabled) return;
            if(f0ggyDragonEggConfig.riptideRequiresGrounded && blockBelow.getType() == Material.AIR) return;

            if(event.getHand() != EquipmentSlot.HAND) return;
            if(itemStack.getType() != Material.DRAGON_EGG) return;

            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
                F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEggPermissions.class, f0ggyDragonEggPermissions -> {
                    if(!f0ggyDragonEggPermissions.DoesPlayerHavePermission(Permissions.RiptideEffect, player, true)) return;
                    var dir = player.getLocation().getDirection().normalize();
                    player.setVelocity(dir.multiply(f0ggyDragonEggConfig.riptideDistance));
                }, Throwable::printStackTrace);
            }else if((action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) && player.isSneaking()){
                F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEggPermissions.class, f0ggyDragonEggPermissions -> {
                    if(!f0ggyDragonEggPermissions.DoesPlayerHavePermission(Permissions.CycleDragonEffEffect, player, true)) return;
                    f0ggyDragonEggConfig.CyclePotionEffectOnDragonEgg(itemStack);
                }, Throwable::printStackTrace);
            }
        }, Throwable::printStackTrace);
    }
}
