package com.sentinel.starbasesentinel;

public class Player {
    private final int enemiesInfiltrated;
    private final static  int maxEnemiesInfiltrated = 3;
    private int coins;

    public Player() {
        enemiesInfiltrated = 0;
        coins = 200;
    }

    public void removeCoins(int cost) {
        coins -= cost;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int amount) {
        coins += amount;
    }
}
