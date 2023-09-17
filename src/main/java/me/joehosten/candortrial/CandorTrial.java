package me.joehosten.candortrial;

import games.negative.framework.BasePlugin;
import games.negative.framework.commands.CommandBuilder;
import lombok.Getter;
import lombok.Setter;
import me.joehosten.candortrial.components.commands.CommandFly;
import me.joehosten.candortrial.util.ConfigUtils;

public final class CandorTrial extends BasePlugin {

    @Getter
    @Setter
    private static CandorTrial instance;

    @Override
    public void onEnable() {
        // init
        super.onEnable();
        setInstance(this);

        // config init
        loadFiles(this, "config.yml");

        // register commands
        registerCommand(
                new CommandBuilder(new CommandFly())
                        .playerOnly()
                        .name("fly")
                        .permission(getPermissions("command.fly"))
                        .usage("/fly")
                        .description("Toggles your flight")
                        .aliases("flight"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // gets permission string from config
    private String getPermissions(String permission) {
        return new ConfigUtils("config").getConfig().getString("permissions." + permission);
    }
}
