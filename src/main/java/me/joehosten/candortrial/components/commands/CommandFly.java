package me.joehosten.candortrial.components.commands;

import games.negative.framework.commands.Command;
import games.negative.framework.commands.Context;
import games.negative.framework.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandFly implements Command {
    @Override
    public void execute(@NotNull Context context) {
        Player player = context.getPlayer();

        assert player != null;
        if (Bukkit.getPlayer(player.getUniqueId()) == null) {
            player.sendMessage(Utils.color("&4An error has occurred: null"));
            return;
        }

        if (player.getAllowFlight()) {
            // If the player is currently allowed to fly
            player.sendMessage(Utils.color("&cFlight disabled."));
        } else {
            // If the player is currently not allowed to fly
            player.sendMessage(Utils.color("&aFlight enabled."));
        }

        // Toggle the player's flight mode by negating the current status
        player.setAllowFlight(!player.getAllowFlight());

        // Set the player's flying state to match their updated flight status
        player.setFlying(player.getAllowFlight());

    }
}
