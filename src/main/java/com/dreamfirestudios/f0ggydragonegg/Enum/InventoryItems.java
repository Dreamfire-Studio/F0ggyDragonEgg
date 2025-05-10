package com.dreamfirestudios.f0ggydragonegg.Enum;

import com.dreamfirestudios.dreamCore.DreamfireChat.DreamfireMessage;
import com.dreamfirestudios.dreamCore.DreamfirePersistentData.DreamfirePersistentItemStack;
import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggConfig;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.List;

public enum InventoryItems {
    BlankTile(" ",Material.BLACK_STAINED_GLASS_PANE, List.of(), List.of(), 0),
    SystemEnabled("#38b227System Enabled!", Material.GREEN_CONCRETE, List.of(), List.of(), 0),
    ResetConfigs("#38b227Reset Configs!", Material.GREEN_CONCRETE, List.of(), List.of(), 0),
    ReloadConfigs("#38b227Reload Configs!", Material.GREEN_CONCRETE, List.of(), List.of(), 0),
    DragonEggItem("#38b227Dragon Egg", Material.DRAGON_EGG, List.of(), List.of(
            new InventoryItemsRecord(F0ggyDragonEggConfig.DRAGON_EGG, F0ggyDragonEggConfig.DRAGON_EGG, PersistentDataType.STRING),
            new InventoryItemsRecord(F0ggyDragonEggConfig.DRAGON_EGG_EFFECT, "", PersistentDataType.STRING),
            new InventoryItemsRecord(F0ggyDragonEggConfig.DRAGON_EGG_STRENGTH, "0", PersistentDataType.STRING)), 0);

    public final String displayName;
    public final Material itemMaterial;
    public final List<String> itemLore;
    public final List<InventoryItemsRecord> inventoryItemsRecords;
    public final int modelData;

    public static record InventoryItemsRecord(String key, String value, PersistentDataType persistentDataType){}

    InventoryItems(String displayName, Material itemMaterial, List<String> itemLore, List<InventoryItemsRecord> inventoryItemsRecords, int modelData){
        this.displayName = displayName;
        this.itemMaterial = itemMaterial;
        this.itemLore = itemLore;
        this.inventoryItemsRecords = inventoryItemsRecords;
        this.modelData = modelData;
    }

    public ItemStack ReturnItemStack(){
        var itemStack = new ItemStack(itemMaterial);
        var itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(DreamfireMessage.formatMessage(displayName));
        var lore = new ArrayList<Component>();
        for(var x : itemLore) lore.add(DreamfireMessage.formatMessage(x));
        itemMeta.lore(lore);
        itemMeta.setCustomModelData(modelData);
        itemStack.setItemMeta(itemMeta);
        for(var item : inventoryItemsRecords){
            DreamfirePersistentItemStack.Add(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, item.persistentDataType(), item.key(), item.value());
        }
        return itemStack;
    }
}
