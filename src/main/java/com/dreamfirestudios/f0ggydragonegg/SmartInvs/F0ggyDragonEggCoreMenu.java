package com.dreamfirestudios.f0ggydragonegg.SmartInvs;

import com.dreamfirestudios.dreamCore.DreamfireSmartInvs.SmartInventory;
import com.dreamfirestudios.dreamCore.DreamfireSmartInvs.content.InventoryContents;
import com.dreamfirestudios.dreamCore.DreamfireSmartInvs.content.InventoryProvider;
import com.dreamfirestudios.f0ggydragonegg.API.F0ggyDragonEggAPI;
import com.dreamfirestudios.f0ggydragonegg.Enum.InventoryItems;
import com.dreamfirestudios.f0ggydragonegg.Enum.Permissions;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggConfig;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggPermissions;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class F0ggyDragonEggCoreMenu implements InventoryProvider {
    private final SmartInventory smartInventory;

    public F0ggyDragonEggCoreMenu(Player... players){
        smartInventory = SmartInventory.builder()
                .id("F0ggyDragonEggCoreMenu")
                .provider(this)
                .size(1, 9)
                .title(NamedTextColor.RED + "Admin Menu")
                .build();
        for(var player : players) smartInventory.open(player);
    }

    public CompletableFuture<Void> init(Player player, InventoryContents inventoryContents) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        F0ggyDragonEggConfig.ReturnStaticAsync(F0ggyDragonEggConfig.class, craftLegendsCoreConfig -> {
            F0ggyDragonEggSmartInvsItems.InventoryItem(player, InventoryItems.BlankTile, clickableItem -> {
                inventoryContents.fillRow(0, clickableItem);
            }, this::BlankTileClick);

            F0ggyDragonEggSmartInvsItems.InventoryItemWithFeedback(player, InventoryItems.SystemEnabled,
                    itemStack -> {
                        var itemMeta = itemStack.getItemMeta();
                        var lore = craftLegendsCoreConfig.systemEnabled
                                ? List.of(Component.text(NamedTextColor.WHITE + "Currently: " + NamedTextColor.GREEN + "ENABLED"))
                                : List.of(Component.text(NamedTextColor.WHITE + "Currently: " + NamedTextColor.RED + "DISABLED"));
                        itemMeta.lore(lore);
                        itemStack.setItemMeta(itemMeta);
                        return itemStack;
                    },
                    clickableItem -> {
                        inventoryContents.set(0, 2, clickableItem);
                    }, this::SystemEnabledClick);

            F0ggyDragonEggSmartInvsItems.InventoryItem(player, InventoryItems.ReloadConfigs, clickableItem -> {
                inventoryContents.set(0, 4, clickableItem);
            }, this::ReloadConfigsClick);

            F0ggyDragonEggSmartInvsItems.InventoryItem(player, InventoryItems.ResetConfigs, clickableItem -> {
                inventoryContents.set(0, 6, clickableItem);
            }, this::ResetConfigsClick);

            future.complete(null);
        }, future::completeExceptionally);
        return future;
    }

    private void BlankTileClick(Player player, InventoryClickEvent inventoryClickEvent){
        inventoryClickEvent.setCancelled(false);
    }

    private void SystemEnabledClick(Player player, InventoryClickEvent inventoryClickEvent){
        F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEggPermissions.class, craftLegendsCorePermissions -> {
            if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.EnableSystem, player, true)) return;
            F0ggyDragonEggAPI.F0ggyDragonEggEnableSystem(dreamCoreTestTemplateConfig -> {});
            smartInventory.open(player);
        }, Throwable::printStackTrace);
    }

    private void ReloadConfigsClick(Player player, InventoryClickEvent inventoryClickEvent) {
        F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEggPermissions.class, craftLegendsCorePermissions -> {
            if (!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.ReloadConfigs, player, true)) return;
            F0ggyDragonEggAPI.F0ggyDragonEggReloadConfigs();
            smartInventory.open(player);
        }, Throwable::printStackTrace);
    }

    private void ResetConfigsClick(Player player, InventoryClickEvent inventoryClickEvent){
        F0ggyDragonEggPermissions.ReturnStaticAsync(F0ggyDragonEggPermissions.class, craftLegendsCorePermissions -> {
            if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.ResetConfigs, player, true)) return;
            F0ggyDragonEggAPI.F0ggyDragonEggResetConfigs();
            smartInventory.open(player);
        }, Throwable::printStackTrace);
    }
}
