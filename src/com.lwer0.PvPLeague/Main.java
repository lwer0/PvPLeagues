package com.lwer0.PvPLeague;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.lwer0.PvPLeague.GameStates;
import com.lwer0.PvPLeague.listeners.LeagueListener;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	@Override
	public void onEnable() {
		getLogger().info("PvPLeague loaded correctly!");
		GameStates.setState(GameStates.IN_LOBBY);
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new LeagueListener(instance), this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("PvPLeague disabled!");
	}
	
}
