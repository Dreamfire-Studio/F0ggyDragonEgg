package com.dreamfirestudios.\f0ggydragonegg.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticEnumPulseConfig;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.\f0ggydragonegg.\F0ggyDragonEgg;
import com.dreamfirestudios.\f0ggydragonegg.Enum.InventoryItems;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

@PulseAutoRegister
public class \F0ggyDragonEggInventoryItems extends StaticEnumPulseConfig<\F0ggyDragonEggInventoryItems, InventoryItems, ItemStack> {
    @Override
    public JavaPlugin mainClass() {return \F0ggyDragonEgg.Get\F0ggyDragonEgg();}
    @Override
    protected Class<InventoryItems> getKeyClass () {return InventoryItems.class;}
    @Override
    protected Class<ItemStack> getValueClass () {return ItemStack.class;}
    @Override
    protected ItemStack getDefaultValueFor (InventoryItems craftLegendsCoreInventoryItem) {return craftLegendsCoreInventoryItem.ReturnItemStack();}
}
