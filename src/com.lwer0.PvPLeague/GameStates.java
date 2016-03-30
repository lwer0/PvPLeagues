package com.lwer0.PvPLeague;

public enum GameStates {
	IN_LOBBY(true), IN_GAME(false), POST_GAME(false), RESETTING(false);
	
	private boolean canJoin;
	
	private static GameStates currentState;
	
	GameStates(boolean canJoin) {
		this.canJoin = canJoin;
	}
	
	public boolean canJoin() {
		return canJoin;
	}
	
	public static void setState(GameStates state) {
		GameStates.currentState = state;
	}
	
	public static boolean inGame() {
		GameStates.currentState = IN_GAME;
		return true;
	}
	
	public static boolean isState(GameStates state) {
		return GameStates.currentState == state;
	}
	
	public static GameStates getState() {
		return currentState;
	}
	
}
