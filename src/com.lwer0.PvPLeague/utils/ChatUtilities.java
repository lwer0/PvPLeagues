package com.lwer0.PvPLeague.utils;

import static org.bukkit.ChatColor.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.lwer0.PvPLeague.Leagues;

public class ChatUtilities implements Listener {
	
	public static void broadcast(String msg) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage(starter() + msg);
		}
	}
	
	private static String starter() {
		return DARK_GRAY + "[" + RED + "Minigame" + DARK_GRAY + "]" + WHITE;
	}
	
	@EventHandler
	public void onPlayerChat (AsyncPlayerChatEvent event) {
		Player p = (Player) event.getPlayer();
		String uuid = p.getUniqueId().toString();
		String msg = event.getMessage();
		// Bronze Prefix!
		if (Leagues.six.containsKey(uuid)) {
			event.setMessage(Leagues.sixprefix + msg);
		}
		// Silver Prefix
		if (Leagues.five.containsKey(uuid)) {
			event.setMessage(Leagues.fiveprefix + msg);
		}
		// Gold Prefix
		if (Leagues.four.containsKey(uuid)) {
			event.setMessage(Leagues.fourprefix + msg);
		}
		// Platinum Prefix
		if (Leagues.three.containsKey(uuid)) {
			event.setMessage(Leagues.threeprefix + msg);
		}
		// Diamond Prefix
		if (Leagues.two.containsKey(uuid)) {
			event.setMessage(Leagues.twoprefix + msg);
		}
		// Challenger Prefix
		if (Leagues.one.containsKey(uuid)) {
			event.setMessage(Leagues.oneprefix + msg);
		}
	}

}

