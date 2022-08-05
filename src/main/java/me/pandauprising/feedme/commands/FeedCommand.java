package me.pandauprising.feedme.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class FeedCommand implements CommandExecutor {

    private final Plugin plugin;

    public FeedCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args){

        if (sender instanceof Player p){

            if (p.hasPermission("feedme.use")){

            p.setFoodLevel(20);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("feed-message"))));

        }else{

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("no-permission"))));

            }

        }else {
            sender.sendMessage(ChatColor.DARK_RED + "You must be a player to use this command!");
        }



        return true;
    }
}
