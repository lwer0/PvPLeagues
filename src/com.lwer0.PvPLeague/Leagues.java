package com.lwer0.PvPLeague;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.ChatColor;

public enum Leagues {
	 BRONZE, SILVER, GOLD, PLATINIUM, DIAMOND, CHALLENGER;
	
	public static final Map<UUID, Integer> six = new HashMap<UUID, Integer>();
	public static final Map<UUID, Integer> five = new HashMap<UUID, Integer>();
	public static final Map<UUID, Integer> four = new HashMap<UUID, Integer>();
	public static final Map<UUID, Integer> three = new HashMap<UUID, Integer>();
	public static final Map<UUID, Integer> two = new HashMap<UUID, Integer>();
	public static final Map<UUID, Integer> one = new HashMap<UUID, Integer>();
	
	private static Leagues currentLeague;
	
	public static String sixprefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Leather" + ChatColor.DARK_GRAY + "]" + " ";
	public static String fiveprefix = ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Iron" + ChatColor.DARK_GRAY + "]" + " ";
	public static String fourprefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Gold" + ChatColor.DARK_GRAY + "]" + " ";
	public static String threeprefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Diamond" + ChatColor.DARK_GRAY + "]" + " ";
	public static String twoprefix = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Emerald" + ChatColor.DARK_GRAY + "]" + " ";
	public static String oneprefix = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Nether Star" + ChatColor.DARK_GRAY + "]" + " ";
	
	public static void setLeague(Leagues league) {
		Leagues.currentLeague = league;
	}
	
	
	public static boolean isInLeague(Leagues league) {
		return Leagues.currentLeague == league;
	}

}
