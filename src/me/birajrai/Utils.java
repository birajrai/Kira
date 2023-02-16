package me.birajrai;

import me.birajrai.utils.JSONMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Utils {
    private static final String prefix = "§f§l[§r§e§lKira§f§l]§r ";
    public static void log(String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + msg);
    }

    public static void send(Player player, String msg) {
        player.sendMessage(prefix + msg);
    }

    public static void tellStaff(String msg, ChatColor color, String tooltip, String command) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.isOp()) {
                JSONMessage.create(prefix + msg).color(color).tooltip(tooltip).runCommand(command).send(p);
            }
        }
    }

    public static void saveConfig() {
        JavaPlugin.getProvidingPlugin(Kira.class).saveConfig();
    }

    public static FileConfiguration getConfig() {
        return JavaPlugin.getProvidingPlugin(Kira.class).getConfig();
    }
}
