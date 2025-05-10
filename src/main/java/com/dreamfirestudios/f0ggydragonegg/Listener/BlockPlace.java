package com.dreamfirestudios.f0ggydragonegg.Listener;

import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.dreamCore.DreamfirePersistentData.DreamfirePersistentItemStack;
import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggConfig;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataType;

@PulseAutoRegister
public class BlockPlace implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        var itemStack = event.getItemInHand();
        if(itemStack.getType() != Material.DRAGON_EGG) return;
        if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, F0ggyDragonEggConfig.DRAGON_EGG)) return;
        if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, F0ggyDragonEggConfig.DRAGON_EGG_EFFECT)) return;
        if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, F0ggyDragonEggConfig.DRAGON_EGG_STRENGTH)) return;
        event.setCancelled(true);
    }
}
