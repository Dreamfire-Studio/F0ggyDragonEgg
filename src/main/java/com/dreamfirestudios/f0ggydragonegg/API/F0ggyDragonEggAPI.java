package com.dreamfirestudios.f0ggydragonegg.API;

import com.dreamfirestudios.dreamConfig.DreamConfig;
import com.dreamfirestudios.f0ggydragonegg.Enum.InventoryItems;
import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;
import com.dreamfirestudios.f0ggydragonegg.Event.F0ggyDragonEggReloadConfigEvent;
import com.dreamfirestudios.f0ggydragonegg.Event.F0ggyDragonEggResetConfigEvent;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggConfig;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggInventoryItems;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggSerilizableItems;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class F0ggyDragonEggAPI {
    public static void F0ggyDragonEggEnableSystem(Consumer<F0ggyDragonEggConfig> onSuccess, boolean state){
        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEggConfig.class, coreConfig -> {
            coreConfig.systemEnabled = state;
            coreConfig.SaveConfig(onSuccess, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    public static void F0ggyDragonEggEnableSystem(Consumer<F0ggyDragonEggConfig> onSuccess){
        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEggConfig.class, coreConfig -> {
            coreConfig.systemEnabled = !coreConfig.systemEnabled;
            coreConfig.SaveConfig(onSuccess, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    public static void F0ggyDragonEggSerializeItem(Consumer<F0ggyDragonEggSerilizableItems> onSuccess, String id, ItemStack itemStack){
        F0ggyDragonEggSerilizableItems.ReturnStaticAsync(F0ggyDragonEggSerilizableItems.class, coreConfig -> {
            coreConfig.AddItemStack(id, itemStack);
            coreConfig.SaveConfig(onSuccess, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    public static void F0ggyDragonEggResetConfigs(){
        F0ggyDragonEggConfig.ReturnStaticAsync( F0ggyDragonEggConfig.class, coreConfig -> {
            if(!coreConfig.systemEnabled) return;
            DreamConfig.GetDreamfireConfig().RegisterStatic(F0ggyDragonEgg.GetF0ggyDragonEgg(), true);
            new F0ggyDragonEggResetConfigEvent();
        }, Throwable::printStackTrace);
    }

    public static void F0ggyDragonEggReloadConfigs(){
        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEggConfig.class, coreConfig -> {
            if(!coreConfig.systemEnabled) return;
            DreamConfig.GetDreamfireConfig().RegisterStatic(F0ggyDragonEgg.GetF0ggyDragonEgg(), false);
            new F0ggyDragonEggReloadConfigEvent();
        }, Throwable::printStackTrace);
    }

    public static void GivePlayerDragonEgg(Player player){
        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEggConfig.class, coreConfig -> {
            if(!coreConfig.systemEnabled) return;
            F0ggyDragonEggInventoryItems.ReturnStaticAsync(F0ggyDragonEggInventoryItems.class, f0ggyDragonEggInventoryItems -> {
                var itemStack = f0ggyDragonEggInventoryItems.saveableHashmap.getHashMap().getOrDefault(InventoryItems.DragonEggItem, InventoryItems.DragonEggItem.ReturnItemStack());
                player.getInventory().addItem(itemStack);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }
}
