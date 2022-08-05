package me.pandauprising.feedme;

import me.pandauprising.feedme.commands.FeedCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FeedMe extends JavaPlugin {

    ConsoleCommandSender clogger = this.getServer().getConsoleSender();

    @Override
    public void onEnable() {
        // Plugin startup logic

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
