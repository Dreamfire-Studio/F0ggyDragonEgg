package com.dreamfirestudios.f0ggydragonegg.Loop;

import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.dreamCore.DreamfireLoop.IDreamfireLoop;
import com.dreamfirestudios.dreamCore.DreamfirePersistentData.DreamfirePersistentItemStack;
import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;
import com.dreamfirestudios.f0ggydragonegg.PulseConfig.F0ggyDragonEggConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Locale;

@PulseAutoRegister
public class DragonEggLoop implements IDreamfireLoop {

    private int id;

    @Override
    public void Start() {

    }

    @Override
    public void Loop() {
        for(var player : Bukkit.getOnlinePlayers()){
            for(var itemStack : player.getInventory().getContents()){
                if(itemStack == null) continue;
                if(itemStack.getType() != Material.DRAGON_EGG) continue;
                if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, F0ggyDragonEggConfig.DRAGON_EGG)) continue;
                if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, F0ggyDragonEggConfig.DRAGON_EGG_EFFECT)) continue;
                if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, F0ggyDragonEggConfig.DRAGON_EGG_STRENGTH)) continue;
                var dragonEggEffectString = DreamfirePersistentItemStack.Get(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, F0ggyDragonEggConfig.DRAGON_EGG_EFFECT, PersistentDataType.STRING);
                if (dragonEggEffectString == null || dragonEggEffectString.isBlank()) continue;
                var dragonEggEffect = PotionEffectType.getByName(dragonEggEffectString.toUpperCase(Locale.ROOT));
                if (dragonEggEffect == null) continue;
                var dragonEggStrengthString = DreamfirePersistentItemStack.Get(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, F0ggyDragonEggConfig.DRAGON_EGG_STRENGTH, PersistentDataType.STRING);
                var dragonEggStrength = Integer.parseInt(dragonEggStrengthString);
                player.addPotionEffect(new PotionEffect(
                        dragonEggEffect,
                        40,
                        dragonEggStrength,
                        false,
                        false,
                        true
                ));
            }
        }
    }

    @Override
    public void End() {

    }

    @Override
    public void PassID(int i) {
        id = i;
    }

    @Override
    public int GetId() {
        return id;
    }
}
