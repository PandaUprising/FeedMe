package me.pandauprising.feedme;

import java.util.Objects;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.pandauprising.feedme.commands.FeedCommand;

public final class FeedMe extends JavaPlugin {
    private ConsoleCommandSender clogger;

    @Override
    public void onEnable() {
        // Plugin startup logic
        clogger = getServer().getConsoleSender();
        clogger.sendMessage(ChatColor.AQUA + "---------------------------------------");
        clogger.sendMessage(ChatColor.GREEN + "      Thank You For Using FeedMe!");
        clogger.sendMessage(ChatColor.AQUA + "---------------------------------------");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Objects.requireNonNull(getCommand("feed")).setExecutor(new FeedCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        clogger.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
        clogger.sendMessage(ChatColor.GOLD + "                Goodbye!");
        clogger.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
    }
}
