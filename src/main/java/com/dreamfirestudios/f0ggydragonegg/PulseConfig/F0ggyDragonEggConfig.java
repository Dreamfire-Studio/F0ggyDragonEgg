package com.dreamfirestudios.f0ggydragonegg.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticPulseConfig;
import com.dreamfirestudios.dreamConfig.Interface.StorageComment;
import com.dreamfirestudios.dreamConfig.SaveableObjects.SaveableHashmap;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.dreamCore.DreamfirePersistentData.DreamfirePersistentItemStack;
import com.dreamfirestudios.f0ggydragonegg.F0ggyDragonEgg;
import com.dreamfirestudios.f0ggydragonegg.Event.F0ggyDragonEggEnableSystemEvent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.util.function.Consumer;

@PulseAutoRegister
public class F0ggyDragonEggConfig extends StaticPulseConfig<F0ggyDragonEggConfig> {
    public static String DRAGON_EGG = "dragon_egg";
    public static String DRAGON_EGG_EFFECT = "dragon_egg_effect";
    public static String DRAGON_EGG_STRENGTH = "dragon_eff_strength";

    @Override
    public JavaPlugin mainClass() {return F0ggyDragonEgg.GetF0ggyDragonEgg();}
    @StorageComment("WARNING: SYSTEM WONT RUN IF FALSE!")
    public boolean systemEnabled = true;
    @StorageComment("Display debugs in the console logs for changes in this config!")
    public boolean debugConfig = false;

    public double riptideDistance = 2.0;
    public boolean riptideRequiresGrounded = false;
    public SaveableHashmap<String, Integer> allowedPotionEffectLibrary = new SaveableHashmap<>(String.class, Integer.class);

    @Override
    public void FirstLoadConfig() {
        allowedPotionEffectLibrary.getHashMap().put(PotionEffectType.SPEED.getName(), 1);
    }

    public void CyclePotionEffectOnDragonEgg(ItemStack itemStack){
        if(allowedPotionEffectLibrary.getHashMap().isEmpty()) return;
        if(itemStack == null) return;
        if(itemStack.getType() != Material.DRAGON_EGG) return;
        if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, DRAGON_EGG)) return;
        if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, DRAGON_EGG_EFFECT)) return;
        if(!DreamfirePersistentItemStack.Has(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, DRAGON_EGG_STRENGTH)) return;
        var dragonEggEffectString = DreamfirePersistentItemStack.Get(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, DRAGON_EGG_EFFECT, PersistentDataType.STRING);
        var dragonEggEffectValid = allowedPotionEffectLibrary.getHashMap().keySet().contains(dragonEggEffectString);
        var dragonEggEffectlist = allowedPotionEffectLibrary.getHashMap().keySet().stream().toList();
        var dragonEggEffectIndex = dragonEggEffectValid ? dragonEggEffectlist.indexOf(dragonEggEffectString)  + 1 : 1;
        if(dragonEggEffectIndex >= dragonEggEffectlist.size()) dragonEggEffectIndex = 0;
        var nextDragonEggEffect = dragonEggEffectlist.get(dragonEggEffectIndex);
        var nextDragonEggStrength = allowedPotionEffectLibrary.getHashMap().get(nextDragonEggEffect);
        DreamfirePersistentItemStack.Add(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, DRAGON_EGG_EFFECT, nextDragonEggEffect);
        DreamfirePersistentItemStack.Add(F0ggyDragonEgg.GetF0ggyDragonEgg(), itemStack, PersistentDataType.STRING, DRAGON_EGG_STRENGTH, nextDragonEggStrength.toString());
    }

    public void ToggleSystemEnabled(Consumer<F0ggyDragonEggConfig> onSuccess, boolean newState){
        new F0ggyDragonEggEnableSystemEvent(systemEnabled, newState);
        systemEnabled = newState;
        SaveDreamConfig(F0ggyDragonEgg.GetF0ggyDragonEgg(), onSuccess);
    }
}
