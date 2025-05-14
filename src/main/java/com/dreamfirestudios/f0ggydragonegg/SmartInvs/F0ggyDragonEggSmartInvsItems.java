package com.dreamfirestudios.f0ggydragonegg.SmartInvs;

import com.dreamfirestudios.dreamCore.DreamfireSmartInvs.ClickableItem;
import com.dreamfirestudios.f0ggydragonegg.Enum.InventoryItems;
import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggInventoryItems;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggSerilizableItems;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class F0ggyDragonEggSmartInvsItems {
    public static void SerializedItem(Player player, String itemID, Function<ItemStack, ItemStack> testFunction, Consumer<ClickableItem> clickableItemConsumer, BiConsumer<Player, InventoryClickEvent> inventoryClickEventConsumer) {
        F0ggyDragonEggSerilizableItems.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(),F0ggyDragonEggSerilizableItems.class, craftLegendsCoreSerilizableItems -> {
            var itemStack = testFunction.apply(craftLegendsCoreSerilizableItems.GetItemStack(itemID).clone());
            clickableItemConsumer.accept(ClickableItem.of(itemStack, event -> inventoryClickEventConsumer.accept(player, event)));
        });
    }

    public static void InventoryItemWithFeedback(Player player, InventoryItems inventoryItems, Function<ItemStack, ItemStack> testFunction, Consumer<ClickableItem> clickableItemConsumer, BiConsumer<Player, InventoryClickEvent> inventoryClickEventConsumer) {
        F0ggyDragonEggInventoryItems.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(),F0ggyDragonEggInventoryItems.class, craftLegendsCoreInventoryItems -> {
            var itemStack = testFunction.apply(craftLegendsCoreInventoryItems.GetValue(inventoryItems).clone());
            clickableItemConsumer.accept(ClickableItem.of(itemStack, event -> inventoryClickEventConsumer.accept(player, event)));
        });
    }

    public static void InventoryItem(Player player, InventoryItems inventoryItems, Consumer<ClickableItem> clickableItemConsumer, BiConsumer<Player, InventoryClickEvent> inventoryClickEventConsumer) {
        F0ggyDragonEggInventoryItems.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(),F0ggyDragonEggInventoryItems.class, craftLegendsCoreInventoryItems -> {
            var itemStack = craftLegendsCoreInventoryItems.GetValue(inventoryItems).clone();
            clickableItemConsumer.accept(ClickableItem.of(itemStack, event -> inventoryClickEventConsumer.accept(player, event)));
        });
    }

    public static void SystemEnabled(Player player, boolean isEnabled, Consumer<ClickableItem> clickableItemConsumer, BiConsumer<Player, InventoryClickEvent> inventoryClickEventConsumer){
        F0ggyDragonEggInventoryItems.ReturnStaticAsync(F0ggyDragonEgg.GetF0ggyDragonEgg(),F0ggyDragonEggInventoryItems.class, craftLegendsCoreInventoryItems -> {
            var itemStack = craftLegendsCoreInventoryItems.GetValue(InventoryItems.SystemEnabled).clone();
            clickableItemConsumer.accept(ClickableItem.of(itemStack, event -> inventoryClickEventConsumer.accept(player, event)));
        });
    }
}
