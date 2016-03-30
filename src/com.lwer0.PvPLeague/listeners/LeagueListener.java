package com.lwer0.PvPLeague.listeners;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.lwer0.PvPLeague.Leagues;
import com.lwer0.PvPLeague.Main;
import com.lwer0.PvPLeague.utils.RandomWin;

public class LeagueListener implements Listener {
	private final Main plugin;
	public LeagueListener(Main instance) {
		this.plugin = instance;
	}
	
	//On Win (When a player kill the other player)
	@EventHandler
	public void onPlayerDeath (PlayerDeathEvent event) {
		FileConfiguration config = plugin.getConfig();
		//Loser remove 8 - 16 points
		//Give that points when the guy is demoted
		int demotep = config.getInt("Config.onDemoted.GivePoints");
		//----------------------------------------
		int losep = RandomWin.RandomLose();
		Player p = (Player) event.getEntity();
		UUID uuid = p.getUniqueId();
		String pget = "Players." + uuid.toString() + ".Points";
		int pset = plugin.getConfig().getInt("Players." + uuid.toString() + ".Points");
		plugin.getConfig().set(pget, pset - losep);
		plugin.saveConfig();
		//Si el jugador tiene -0 puntos
		if (pset <= 0) {
			if (Leagues.five.containsKey(uuid)) {
				Leagues.five.remove(uuid);
				Leagues.six.put(uuid, 0);
				config.set(pget, demotep);
				plugin.saveConfig();
			}
			if (Leagues.four.containsKey(uuid)) {
				Leagues.four.remove(uuid);
				Leagues.five.put(uuid, 0);
				config.set(pget, demotep);
				plugin.saveConfig();
			}
			if (Leagues.three.containsKey(uuid)) {
				Leagues.three.remove(uuid);
				Leagues.four.put(uuid, 0);
				config.set(pget, demotep);
				plugin.saveConfig();
			}
			if (Leagues.two.containsKey(uuid)) {
				Leagues.two.remove(uuid);
				Leagues.three.put(uuid, 0);
				config.set(pget, demotep);
				plugin.saveConfig();
			}
			if (Leagues.one.containsKey(uuid)) {
				Leagues.one.remove(uuid);
				Leagues.two.put(uuid, 0);
				config.set(pget, demotep);
				plugin.saveConfig();
			}
		}
		//Winner add 20 - 30 points
		int winp = RandomWin.RandomWin();
		Player killer = (Player) event.getEntity().getKiller();
		UUID uuidk = killer.getUniqueId();
		String kset = "Players." + uuidk.toString() + ".Points";
		plugin.getConfig().set(kset, kset + winp);
		plugin.saveConfig();
	}
}
