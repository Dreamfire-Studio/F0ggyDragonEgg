package com.dreamfirestudios.\f0ggydragonegg.ServerCommand;

import com.dreamfirestudios.dreamCommand.Interface.PCMethod;
import com.dreamfirestudios.dreamCommand.Interface.PCSignature;
import com.dreamfirestudios.dreamCommand.ServerCommand;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.\f0ggydragonegg.API.\F0ggyDragonEggAPI;
import com.dreamfirestudios.\f0ggydragonegg.Enum.Messages;
import com.dreamfirestudios.\f0ggydragonegg.PulseConfig.\F0ggyDragonEggConfig;
import com.dreamfirestudios.\f0ggydragonegg.PulseConfig.\F0ggyDragonEggMessages;
import org.bukkit.command.CommandSender;

import java.util.LinkedHashMap;

@PulseAutoRegister
public class \F0ggyDragonEggServerCommand extends ServerCommand {

    public \F0ggyDragonEggServerCommand() {
        super("\f0ggydragoneggserver", false);
    }

    @Override
    public void NoMethodFound(CommandSender commandSender, String s, String[] strings) {}
    @Override
    public String helpMenuPrefix(CommandSender commandSender) {return "";}
    @Override
    public LinkedHashMap<String, String> helpMenuFormat(CommandSender commandSender, LinkedHashMap<String, String> linkedHashMap) {return new LinkedHashMap<>();}
    @Override
    public String helpMenuSuffix(CommandSender commandSender) {return "";}

    @PCMethod
    @PCSignature({})
    public void \F0ggyDragonEggMethod(CommandSender commandSender){
        \F0ggyDragonEggConfig.ReturnStaticAsync(\F0ggyDragonEggConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            \F0ggyDragonEggMessages.ReturnStaticAsync(\F0ggyDragonEggMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToConsole(Messages.SystemIsntEnabled);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    @PCMethod
    @PCSignature({"enable"})
    public void \F0ggyDragonEggEnableMethod(CommandSender commandSender, boolean state){
        \F0ggyDragonEggAPI.\F0ggyDragonEggEnableSystem(dreamCoreTestTemplateConfig -> {}, state);
        \F0ggyDragonEggMessages.ReturnStaticAsync(\F0ggyDragonEggMessages.class, craftLegendsCoreMessages -> {
            craftLegendsCoreMessages.SendMessageToConsole(state ? Messages.ConsoleEnabledSystem : Messages.ConsoleDisableSystem);
        }, Throwable::printStackTrace);
    }

    @PCMethod
    @PCSignature({"configs", "reset"})
    public void \F0ggyDragonEggConfigsResetMethod(CommandSender commandSender){
        \F0ggyDragonEggConfig.ReturnStaticAsync(\F0ggyDragonEggConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            \F0ggyDragonEggAPI.\F0ggyDragonEggResetConfigs();
            \F0ggyDragonEggMessages.ReturnStaticAsync(\F0ggyDragonEggMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToConsole(Messages.PlayerResetConfig);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    @PCMethod
    @PCSignature({"configs", "reload"})
    public void \F0ggyDragonEggConfigsReloadMethod(CommandSender commandSender){
        \F0ggyDragonEggConfig.ReturnStaticAsync(\F0ggyDragonEggConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            \F0ggyDragonEggAPI.\F0ggyDragonEggResetConfigs();
            \F0ggyDragonEggMessages.ReturnStaticAsync(\F0ggyDragonEggMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToConsole(Messages.PlayerReloadedConfig);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }
}
